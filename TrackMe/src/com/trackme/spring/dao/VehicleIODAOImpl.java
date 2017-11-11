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
import com.trackme.spring.model.VehicleIO;
import com.trackme.spring.model.UserMaster;


@Repository
public class VehicleIODAOImpl implements VehicleIODAO {
	
	private static final Logger logger = LoggerFactory.getLogger(VehicleIODAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}


	@Override
	public void addVehicleIO(VehicleIO vehicleIO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(vehicleIO);
		logger.info("vehicleIO saved successfully, vehicleIO Details="+vehicleIO);
	}

	@Override
	public void updateVehicleIO(VehicleIO vehicleIO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(vehicleIO);
		session.flush();
		logger.info("vehicleIO updated successfully, vehicleIO Details="+vehicleIO);
	}

	@Override
	public List<VehicleIO> listVehicleIO() {
		Session session = this.sessionFactory.getCurrentSession();
		List<VehicleIO> vehicleIOList = session.createQuery("from VehicleIO where status like '"+Constant.STATUS_ACTIVE+"' ").list();
		
		return vehicleIOList;
	}

	@Override
	public VehicleIO getVehicleIOById(String id1) {
		try{
			 if(id1!=null && id1 !=""){
			Integer id= Integer.parseInt(id1);
			Session session = this.sessionFactory.getCurrentSession();
			String q ="from VehicleIO where id="+id;
	 		org.hibernate.Query query =session.createQuery(q);
			VehicleIO vehicleIO =(VehicleIO) query.list().get(0);
			return vehicleIO;
			 }else{
				 return null;
			 }
		  
		}catch(Exception e){
			return null;
		}
			
			
	}

	@Override
	public void removeVehicleIO(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		VehicleIO p = (VehicleIO) session.load(VehicleIO.class, Integer.parseInt(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("VehicleIO deleted successfully, VehicleIO details="+p);
		
	}

}
