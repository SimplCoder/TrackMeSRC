package com.trackme.spring.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.trackme.constants.Constant;
import com.trackme.spring.model.FuelDetail;
import com.trackme.spring.model.GPSTracking;
import com.trackme.spring.model.UserMaster;
import com.trackme.spring.model.VehicleMaster;


@Repository("vehicleMasterDAO")
public class VehicleMasterDAOImpl implements VehicleMasterDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(VehicleMasterDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;  
	
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addVehicleMaster(VehicleMaster p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("VehicleMaster saved successfully, VehicleMaster Details="+p);
	}

	@Override
	public void updateVehicleMaster(VehicleMaster p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("VehicleMaster updated successfully, VehicleMaster Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VehicleMaster> listVehicleMasters() {
		Session session = this.sessionFactory.getCurrentSession();
		List<VehicleMaster> VehicleMastersList = session.createQuery("from VehicleMaster where status like '"+Constant.STATUS_ACTIVE+"' ").list();
		
		return VehicleMastersList;
	}

	@Override
	public VehicleMaster getVehicleMasterById(String vehicleNo) {
		try{
		Session session = this.sessionFactory.getCurrentSession();		
		VehicleMaster p = (VehicleMaster) session.load(VehicleMaster.class, vehicleNo);
		logger.info("VehicleMaster loaded successfully, VehicleMaster details="+p);
		return p;
		}catch(Exception e){
			logger.equals(e.getMessage());
		}
		return null;
	}

	@Override
	public void removeVehicleMaster(String vehicleNo) {
		Session session = this.sessionFactory.getCurrentSession();
		VehicleMaster p = (VehicleMaster) session.load(VehicleMaster.class, vehicleNo);
		if(null != p){
			session.delete(p);
		}
		logger.info("VehicleMaster deleted successfully, VehicleMaster details="+p);
	}

	@Override
	public int totaNoOffVehicle(UserMaster userMaster) {
		
		
		int total=0;
		try{
		StringBuilder queryStr=new StringBuilder();
		queryStr.append("select count(distinct vm.vehicleno) from gsmstatus gsm join vehiclemaster vm on ( gsm.unitno= vm.unitno and LOWER(vm.status)=LOWER('ACTIVE'))");
		 if(!userMaster.getRoleMaster().getRole().equalsIgnoreCase(Constant.ROLE_SUPERUSER)){
			 queryStr.append(" and vm.company = " +userMaster.getCompanyMaster().getId() );
			}
		total = jdbcTemplate.queryForInt(queryStr.toString());
		return total;}catch(Exception e){
			return total;
		}
		
		
		
	}

	@Override
	public void saveGPSTracking(GPSTracking gpsTracking) {
		

		Session session = this.sessionFactory.getCurrentSession();

		StringBuffer strBuf = new StringBuffer();
		strBuf.append("INSERT INTO gsmmaster(");
		strBuf.append("unitno, speed,");
		strBuf.append("latitude, longitude,");
		strBuf.append("status,"); 
		strBuf.append("datetime,");
		strBuf.append("datetimedate)");
		strBuf.append("VALUES ( ");
		strBuf.append(gpsTracking.getVehicleNo()+",1,'"+gpsTracking.getLatitude()+"',"
				+ "'"+gpsTracking.getLongitude()+"',1,'"+gpsTracking.getDatetime()+"',"); 
		strBuf.append("'"+gpsTracking.getDatetimeDate()+"');");
		String query = strBuf.toString();
		logger.info("getAllVehicleLocation Query== " + query);
		Query sqlQuery = session.createSQLQuery(query);
		sqlQuery.executeUpdate();
		
			}

	@Override
	public List<VehicleMaster> getInsuranceExpiringVehicle(Date date) {
		// TODO Auto-generated method stub
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		StringBuffer query =new StringBuffer("from VehicleMaster vm where 1=1 and vm.status like 'Active' ");
		query.append(" and year(vm.insuranceExpiryDate)= "+ calendar.get(Calendar.YEAR)); 
	query.append(" and month(vm.insuranceExpiryDate)=  " + (calendar.get(Calendar.MONTH)+1)); 
		query.append(" and day(vm.insuranceExpiryDate)=" + calendar.get(Calendar.DAY_OF_MONTH)); 
		
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query q= session.createQuery(query.toString());
			List<VehicleMaster> vehicleMastersList = q.list();
			return vehicleMastersList;
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		
		return null;
	}
	
	

	@Override
	public List<VehicleMaster> getNPExpiringVehicle(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		StringBuffer query =new StringBuffer("from VehicleMaster vm where 1=1 and vm.status like 'Active' ");
		query.append(" and year(vm.nationalPermitExpiryDate)= "+ calendar.get(Calendar.YEAR)); 
	query.append(" and month(vm.nationalPermitExpiryDate)=  " + (calendar.get(Calendar.MONTH)+1)); 
		query.append(" and day(vm.nationalPermitExpiryDate)=" + calendar.get(Calendar.DAY_OF_MONTH)); 
		
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query q= session.createQuery(query.toString());
			List<VehicleMaster> vehicleMastersList = q.list();
			return vehicleMastersList;
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<VehicleMaster> getServicingVeicle(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		StringBuffer query =new StringBuffer("from VehicleMaster vm where 1=1 and vm.status like 'Active' ");
		query.append(" and year(vm.serviceDate)= "+ calendar.get(Calendar.YEAR)); 
	query.append(" and month(vm.serviceDate)=  " + (calendar.get(Calendar.MONTH)+1)); 
		query.append(" and day(vm.serviceDate)=" + calendar.get(Calendar.DAY_OF_MONTH)); 
		
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query q= session.createQuery(query.toString());
			List<VehicleMaster> vehicleMastersList = q.list();
			return vehicleMastersList;
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		
		return null;
	}

}
