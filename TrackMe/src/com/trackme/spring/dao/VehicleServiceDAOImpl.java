package com.trackme.spring.dao;

import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.trackme.constants.Constant;
import com.trackme.spring.model.VehicleService;
import com.trackme.spring.model.UserMaster;


@Repository
public class VehicleServiceDAOImpl implements VehicleServiceDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(VehicleServiceDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}


	@Override
	public void addVehicleService(VehicleService vehicleService) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(vehicleService);
		logger.info("vehicleService saved successfully, vehicleService Details="+vehicleService);
	}

	@Override
	public void updateVehicleService(VehicleService vehicleService) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(vehicleService);
		session.flush();
		logger.info("vehicleService updated successfully, vehicleService Details="+vehicleService);
	}

	@Override
	public List<VehicleService> listVehicleService() {
		Session session = this.sessionFactory.getCurrentSession();
		List<VehicleService> vehicleServiceList = session.createQuery("from VehicleService where status like '"+Constant.STATUS_ACTIVE+"' ").list();
		
		return vehicleServiceList;
	}

	@Override
	public VehicleService getVehicleServiceById(String id1) {
		try{
			 if(id1!=null && id1 !=""){
			Integer id= Integer.parseInt(id1);
			Session session = this.sessionFactory.getCurrentSession();
			String q ="from VehicleService where serviceId="+id;
	 		org.hibernate.Query query =session.createQuery(q);
			VehicleService vehicleService =(VehicleService) query.list().get(0);
			return vehicleService;
			 }else{
				 return null;
			 }
		  
		}catch(Exception e){
			return null;
		}
			
			
	}

	@Override
	public void removeVehicleService(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		VehicleService p = (VehicleService) session.load(VehicleService.class, Integer.parseInt(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("VehicleService deleted successfully, VehicleService details="+p);
		
	}

}
