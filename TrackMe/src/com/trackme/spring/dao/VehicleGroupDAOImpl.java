package com.trackme.spring.dao;

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
import com.trackme.spring.model.VehicleGroup;


@Repository("VehicleGroupDAO")
public class VehicleGroupDAOImpl implements VehicleGroupDAO {

	private static final Logger logger = LoggerFactory.getLogger(VehicleMasterDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;  
	
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addVehicleGroup(VehicleGroup vehicleGroup) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save("VehicleGroup",vehicleGroup);
		logger.info("VehicleGroup updated successfully");
		
	}

	@Override
	public void updateVehicleGroup(VehicleGroup vehicleGroup) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(vehicleGroup);
		logger.info("vehicleGroup updated successfully");
		
	}

	@Override
	public List<VehicleGroup> listVehicleGroup() {
		Session session = this.sessionFactory.getCurrentSession();
		List<VehicleGroup> vehicleMasterList = session.createQuery("from VehicleGroup where status like '"+Constant.STATUS_ACTIVE+"' ").list();
		return vehicleMasterList;
	}

	@Override
	public VehicleGroup getVehicleGroupById(String vehicleGroupId) {
		VehicleGroup vehicleGroup=null;
		Session session = this.sessionFactory.getCurrentSession();		
		try{
		Query query=session.createQuery("Select o from VehicleGroup o where o.id='"+vehicleGroupId+"'");	
		vehicleGroup = (VehicleGroup)query.list().get(0);
		}
		catch(Exception e){
			return null;
		}
		return vehicleGroup;
	}

	@Override
	public void removeVehicleGroup(String VehicleGroupId) {
		Session session = this.sessionFactory.getCurrentSession();
		VehicleGroup vehicleGroup = (VehicleGroup) session.load(VehicleGroup.class, VehicleGroupId);
		if(null != vehicleGroup){
			session.delete(vehicleGroup);
		}
		logger.info("DriverMaster deleted successfully");
		
	}

	@Override
	public void reomoveExistingVehiclesFromGroup(String VehicleGroupId) {
		String query = "delete from groupvehicles where groupid='"+VehicleGroupId+"'";
		jdbcTemplate.execute(query);
	}

}
