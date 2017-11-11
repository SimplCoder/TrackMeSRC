package com.trackme.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trackme.constants.Constant;
import com.trackme.spring.model.DeviceMaster;
import com.trackme.spring.model.DriverMaster;
import com.trackme.spring.model.Location;

@Repository
public class LocationDAOImpl implements LocationDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(LocationDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}


	@Override
	public void addLocationMaster(Location location) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(location);
		logger.info("location saved successfully, location Details="+location);
	}

	@Override
	public void updateLocation(Location location) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(location);
		session.flush();
		logger.info("location updated successfully, location Details="+location);
	
	}

	@Override
	public List<Location> listLocation() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Location> list = session.createQuery("from Location where status like '"+Constant.STATUS_ACTIVE+"' ").list();	
		return list;
	}

	@Override
	public Location getLocationByLocationName(String locationName) {
		try{
			Session session = this.sessionFactory.getCurrentSession();		
			Location location = (Location) session.load(Location.class, locationName);
			logger.info("location loaded successfully, location details="+location);
			return location;
			}catch(Exception e){
				logger.equals(e.getMessage());
			}
			return null;
	
	}

	@Override
	public void removeLocation(String locationName) {
		// TODO Auto-generated method stub

	}

}
