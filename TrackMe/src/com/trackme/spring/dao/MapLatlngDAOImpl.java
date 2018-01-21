package com.trackme.spring.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trackme.constants.Constant;
import com.trackme.spring.model.UserMaster;

@Repository("mapLatlngDAO")
public class MapLatlngDAOImpl implements MapLatlngDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(VehicleMasterDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public List getAllVehicleLocation(UserMaster userMaster) {
		Session session = this.sessionFactory.getCurrentSession();
		StringBuffer strBuf = new StringBuffer();
		strBuf.append(" select vm.vehicleno,  sd.description, gsm.speed,round(CAST(cast(coalesce(gsm.distance,'0')  as float8 )/1000 as numeric),2) as distance, gsm.location, gsm.latitude, gsm.longitude, ");
		strBuf.append(" to_char(gsm.datetimedate , 'YYYY-MM-DD') ||' '|| to_char(gsm.datetime, 'HH:MI PM') ");
		strBuf.append(" as datetime1 , ");
		strBuf.append(" case when (sd.description='Health Check' or sd.description='Ignition Off' or sd.description='Ignoff Restarting') then ");
		strBuf.append("	cast(EXTRACT(EPOCH FROM current_timestamp-((select max(gsm2.datetimedate+gsm2.datetime) as lastDateTime ");
		strBuf.append(" from gsmmaster gsm2 join statusdesc sd1 on  gsm2.status  = sd1.code ");
		strBuf.append(" where sd1.description='Ignition Off' and gsm2.unitno=gsm.unitNo ");
		strBuf.append(" ))) as Integer ) ");
		strBuf.append(" when sd.description='Idling Start' then ");
		strBuf.append(" cast(EXTRACT(EPOCH FROM current_timestamp-((select max(gsm2.datetimedate+gsm2.datetime) as lastDateTime ");
		strBuf.append(" from gsmmaster gsm2 join statusdesc sd1 on  gsm2.status  = sd1.code ");
		strBuf.append(" where sd1.description='Idling Start' and gsm2.unitno=gsm.unitNo ");
		strBuf.append(" ))) as Integer ) "); 
		strBuf.append(" else 0 end as idleTime ");
		strBuf.append(" , vm.ownercompanyname as ownerName ");
		strBuf.append(" ,(select to_char(vs.servicedate , 'YYYY-MM-DD') from vehicleservice vs where vs.vehicleno=vm.vehicleno and vs.servicedate>= current_timestamp order by vs.servicedate asc fetch first 1 row only ) as nextService ");
		strBuf.append(" ,gsm.unitno as deviceNo ");
		strBuf.append(" ,dm.device_imei as imeiNo ");
		strBuf.append(" ,vm.vehicleType as vehicleType ");
		strBuf.append(" ,vm.ownercontact1 as ownerPhone ");
		strBuf.append(" ,fd.currentodo as odometer ");
		strBuf.append(" ,um.gsmno as gsmNumber ");
		strBuf.append(" ,(select dm1.drivername from drivermaster dm1 left join driverconf dc1 on dm1.id=driverid where dc1.vehicleno = vm.vehicleno and "); 
		strBuf.append(" to_timestamp((to_char(gsm.datetimedate+gsm.datetime, 'MM/DD/YYYY HH:MI PM')),'MM/DD/YYYY HH:MI PM') between to_timestamp(dc1.startdate||' '||dc1.starttime,'MM/DD/YYYY HH:MI PM') and to_timestamp(dc1.enddate||' '|| dc1.endtime,'MM/DD/YYYY HH:MI PM') ");
		strBuf.append(" fetch first 1 row only) as driverName ");
		strBuf.append(" ,(select dm1.contact1 from drivermaster dm1 left join driverconf dc1 on dm1.id=driverid where dc1.vehicleno = vm.vehicleno and "); 
		strBuf.append(" to_timestamp((to_char(gsm.datetimedate+gsm.datetime, 'MM/DD/YYYY HH:MI PM')),'MM/DD/YYYY HH:MI PM') between to_timestamp(dc1.startdate||' '||dc1.starttime,'MM/DD/YYYY HH:MI PM') and to_timestamp(dc1.enddate||' '|| dc1.endtime,'MM/DD/YYYY HH:MI PM') ");
		strBuf.append(" fetch first 1 row only) as driverPhone,  ");
		strBuf.append(" (case when gsm.status2=1 then 'AC ON' when gsm.status2=0 then 'AC OFF' end ) as acStatus  ");
		strBuf.append(" from vehiclemaster vm join gsmstatus gsm on vm.unitno= gsm.unitNo and LOWER(vm.status)=LOWER('ACTIVE') ");
		strBuf.append(" left join statusdesc sd on  gsm.status  = sd.code ");
		strBuf.append(" left join devicemaster dm on cast(gsm.unitno as text) = dm.device_no ");
		strBuf.append(" left join fueldetail fd on vm.vehicleno = fd.vehicleno ");
		strBuf.append(" left join unitmaster um on gsm.unitno = um.unitno where 1=1 ");
		
		if(userMaster != null && userMaster.getRoleMaster() != null && (userMaster.getRoleMaster().getRole() != null && !userMaster.getRoleMaster().getRole().isEmpty())){
			if(userMaster.getRoleMaster().getRole().equalsIgnoreCase(Constant.ROLE_PARENT)){
				strBuf.append(" and vm.vehicleno in ( ");
				strBuf.append(" select vehicleno from routevehicle  where schedulename in (select result from ( ");
				strBuf.append(" select schedulename as result from student  where (mothermobileno = '"+userMaster.getUserName().trim()+"' or fathermobileno = '"+userMaster.getUserName().trim()+"' or gaurdianmobileno = '"+userMaster.getUserName().trim()+"') ");  
				strBuf.append(" union all ");
				strBuf.append(" select dropschedulename as result from student  where (mothermobileno = '"+userMaster.getUserName().trim()+"' or fathermobileno = '"+userMaster.getUserName().trim()+"' or gaurdianmobileno = '"+userMaster.getUserName().trim()+"') "); 
				strBuf.append(" ) as resultAll) ");
				strBuf.append(" ) ");
			}else if(!userMaster.getRoleMaster().getRole().equalsIgnoreCase(Constant.ROLE_SUPERUSER)){
				strBuf.append(" and vm.company = " +userMaster.getCompanyMaster().getId() );
			}
		}
		strBuf.append(" order by gsm.datetimedate+gsm.datetime desc  ");
		 
		String query = strBuf.toString();
		logger.info("getAllVehicleLocation Query== " + query);
		Query sqlQuery = session.createSQLQuery(query);
		sqlQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
		List<Map<String, Object>> mapLatlngList = sqlQuery.list();
		return mapLatlngList;
	}

	@Override
	public List getLatlngDetailsByVehicleNo(String vehicleNo, String fromDate, String toDate) {
		List<Map<String, Object>> vehicleLatlngList = null;
		if (vehicleNo != null || !"".equals(vehicleNo)) {
			Session session = this.sessionFactory.getCurrentSession();
			StringBuffer strBuf = new StringBuffer();
			strBuf.append(" select vm.vehicleno,  sd.description, gsm.speed, gsm.location,gsm.latitude, gsm.longitude, ");
			strBuf.append(" to_char(gsm.datetimedate , 'YYYY-MM-DD') ||' '|| to_char(gsm.datetime, 'HH:MI PM')as datetime1  from vehiclemaster vm join gsmmaster gsm on vm.unitno= gsm.unitNo  ");
			strBuf.append(" join statusdesc sd on  gsm.status  = sd.code ");
			strBuf.append(" where vm.vehicleno like '");
			strBuf.append(vehicleNo.trim());
			strBuf.append("'");
			if (fromDate != null && !"".equals(fromDate) ){
				strBuf.append(" and gsm.datetimedate+gsm.datetime >= '");
				strBuf.append(fromDate);
				strBuf.append("'");
			}
			if (toDate != null && !"".equals(toDate) ){
				strBuf.append(" and gsm.datetimedate+gsm.datetime <=  '");
				strBuf.append(toDate);
				strBuf.append("'");
			}
			strBuf.append(" order by gsm.datetimedate+gsm.datetime asc ");
			strBuf.append(" fetch first 99 rows only ");			//google map api limit
			String query = strBuf.toString();
			logger.info("getLatlngDetailsByVehicleNo Query== " + query);
			Query sqlQuery = session.createSQLQuery(query);
			sqlQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
			vehicleLatlngList = sqlQuery.list();
			logger.info("Empty VehicleNo returning NULL");
		}
		return vehicleLatlngList;
	}

	@Override
	public String getLastIngnitionOf(String vehicleNo) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		StringBuffer strBuf= new StringBuffer();
		strBuf.append("select gsm1.datetimedate+ gsm1.datetime as lastIgnition "
				+ "from gsmmaster  gsm1 " );
		if(vehicleNo !=null && vehicleNo !="" ){
			strBuf.append(" join vehiclemaster vm on ( gsm1.unitno= vm.unitno and vm.vehicleno = '"+vehicleNo +"') ");
		}
		
		strBuf.append( "  where gsm1.status=1  order by gsm1.datetimedate+ gsm1.datetime desc  fetch first 1 rows only ");
		
        		
		String query = strBuf.toString();
		logger.info("getInginationOf Query== " + query);
		Query sqlQuery = session.createSQLQuery(query);
		sqlQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
		List<Map<String, Object>>	vehicleLatlngList = sqlQuery.list();
		if(vehicleLatlngList!=null && !vehicleLatlngList.isEmpty() ){
			return ((Timestamp)vehicleLatlngList.get(0).get("lastignition")).toString();
			
		}
		
		return "";
	}

}
