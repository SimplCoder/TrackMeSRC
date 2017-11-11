package com.trackme.spring.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.trackme.constants.Constant;
import com.trackme.spring.model.GeoFenceDetail;

@Repository
public class GeoFencingDAOImpl implements GeoFencingDAO {

	private static final Logger logger = LoggerFactory.getLogger(GeoFencingDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	

	@Autowired
	private JdbcTemplate jdbcTemplate;  

	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
	
	
	@Override
	public void addGeoFence(GeoFenceDetail geoFenceDetail) {}

	@Override
	public void updateGeoFence(GeoFenceDetail geoFenceDetail) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(geoFenceDetail);
		session.flush();
		logger.info("geoFenceDetail updated successfully, geoFenceDetail Details="+geoFenceDetail);

	}

	@Override
	public List<GeoFenceDetail> getGeoFenceList() {
		Session session = this.sessionFactory.getCurrentSession();
		List<GeoFenceDetail> geoFenceList = session.createQuery("from GeoFenceDetail where status like '"+Constant.STATUS_ACTIVE+"' ").list();
		return geoFenceList;
	}

	@Override
	public GeoFenceDetail getGeoFenceById(int geoFenceId) {
		try{
			Session session = this.sessionFactory.getCurrentSession();		
			GeoFenceDetail geoFenceDetail = (GeoFenceDetail) session.load(GeoFenceDetail.class, geoFenceId);
			if(null!=geoFenceDetail.getStatus()){
				if(geoFenceDetail.getStatus().equals(Constant.STATUS_INACTIVE)){
					logger.info("GeoFenceDetail status is Inactive, GeoFenceDetail details="+geoFenceDetail);
					return null;
				}
			}
			logger.info("GeoFenceDetail loaded successfully, GeoFenceDetail details="+geoFenceDetail);
			return geoFenceDetail;
			}catch(Exception e){
				logger.equals(e.getMessage());
			}
			return null;
	}

	@Override
	public void removeGeoFence(int geoFenceId) {
		Session session = this.sessionFactory.getCurrentSession();
		GeoFenceDetail geoFenceDetail = (GeoFenceDetail) session.load(GeoFenceDetail.class, geoFenceId);
		if(null != geoFenceDetail){
//			session.delete(geoFenceDetail);
			geoFenceDetail.setStatus(Constant.STATUS_INACTIVE);
			session.update(geoFenceDetail);
			session.flush();
		}
		logger.info("GeoFenceDetail deleted successfully, GeoFenceDetail details="+geoFenceDetail);
	}

	@Override
	public void saveGeoFenceUsingHibrnate(GeoFenceDetail geoFenceDetail) {
	Session session = this.sessionFactory.getCurrentSession();
	session.save(geoFenceDetail);
		
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void deleteVehicleGeoFence(String id) {
		String query = "delete from routevehicle where scheduleName= '"+id+"' ";
		jdbcTemplate.execute(query);
	}

	@Override
	public List getGeoFenceOutDetails() {
		List<Map<String, Object>>  outVehicles= null;
		

String query= "select um.notificationid, gf.geofencename from geofencemaster gf "+
"join geofencevehicle gv on gf.id= gv.geofenceid "+
"join vehiclemaster vm on vm.vehicleno=gv.vehicleno "+
"join gsmstatus gsm on gsm.unitno= vm.unitno "+
"join routeschedule rs  on rs.vehicleno=vm.vehicleno  "+
"join student st on (st.schedulename = rs.schedulename or st.dropschedulename= rs.schedulename) "+
"join usermaster um on (um.username like fathermobileno  "+
			"or um.username like mothermobileno   "+
			"or um.username like gaurdianmobileno)  "+
"where (point(cast(gsm.latitude as float8),cast(gsm.longitude as float8)) <@> point(cast(gf.latitude as float8),cast(gf.longitude as float8)))* 1.609344 <gf.radius  "+
"and (gv.vehicleout is null or gv.vehicleout like 'N' )  "+
"and  gsm.datetimedate   between rs.startdate and enddate  "+
"and  gsm.datetime   between rs.starttime and endtime  ";
		
		outVehicles = jdbcTemplate.queryForList(query);
		
		String updateQuery="update geofencevehicle set vehicleout='Y' , vehiclein='N'   where (geofenceid,vehicleno) in ( "+
						" select gf.id,vm.vehicleno from geofencemaster gf  "+
						" join geofencevehicle gv on gf.id= gv.geofenceid "+
						"join vehiclemaster vm on vm.vehicleno=gv.vehicleno "+
						" join gsmstatus gsm on gsm.unitno= vm.unitno  "+
						"where (point(cast(gsm.latitude as float8),cast(gsm.longitude as float8)) <@> point(cast(gf.latitude as float8),cast(gf.longitude as float8)))* 1.609344 >gf.radius  "+
						"and (gv.vehiclein is null or gv.vehiclein like 'N' )) ";
		
		jdbcTemplate.update(updateQuery);

		
		
	return outVehicles;
		
		
	}

	@Override
	public List getGeoFenceInDetails() {
		List<Map<String, Object>>  outVehicles= null;
		

		String query= "select um.notificationid, gf.geofencename from geofencemaster gf "+
		"join geofencevehicle gv on gf.id= gv.geofenceid "+
		"join vehiclemaster vm on vm.vehicleno=gv.vehicleno "+
		"join gsmstatus gsm on gsm.unitno= vm.unitno "+
		"join routeschedule rs  on rs.vehicleno=vm.vehicleno  "+
		"join student st on (st.schedulename = rs.schedulename or st.dropschedulename= rs.schedulename) "+
		"join usermaster um on (um.username like fathermobileno  "+
					"or um.username like mothermobileno   "+
					"or um.username like gaurdianmobileno)  "+
		"where (point(cast(gsm.latitude as float8),cast(gsm.longitude as float8)) <@> point(cast(gf.latitude as float8),cast(gf.longitude as float8)))* 1.609344 <gf.radius  "+
		"and (gv.vehiclein is null or gv.vehiclein like 'N' )  "+
		"and  gsm.datetimedate   between rs.startdate and enddate  "+
		"and  gsm.datetime   between rs.starttime and endtime  ";
				
				outVehicles = jdbcTemplate.queryForList(query);
				
				String updateQuery="update geofencevehicle set vehiclein='Y' , vehicleout='N'   where (geofenceid,vehicleno) in ( "+
								" select gf.id,vm.vehicleno from geofencemaster gf  "+
								" join geofencevehicle gv on gf.id= gv.geofenceid "+
								"join vehiclemaster vm on vm.vehicleno=gv.vehicleno "+
								" join gsmstatus gsm on gsm.unitno= vm.unitno  "+
								"where (point(cast(gsm.latitude as float8),cast(gsm.longitude as float8)) <@> point(cast(gf.latitude as float8),cast(gf.longitude as float8)))* 1.609344 <gf.radius  "+
								"and (gv.vehiclein is null or gv.vehiclein like 'N' )) ";
				
				jdbcTemplate.update(updateQuery);

				
				
			return outVehicles;
				

	}


}
