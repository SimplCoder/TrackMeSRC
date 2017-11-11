package com.trackme.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GenericDAOImpl implements GenericDAO {

	private static final Logger logger = LoggerFactory.getLogger(VehicleMasterDAOImpl.class);
	
	
	@Autowired
	 private SessionFactory sessionFactory;
	 
	 private Session getSession() {
	        return sessionFactory.getCurrentSession();
	 }
	 

	@Override
	public void persist(Object e) {		
		getSession().persist(e);
		logger.info("Object saved successfully");
	}

	@Override
	public void update(Object e) {
		getSession().update(e);
		logger.info("Object updated successfully");
		
	}

	@Override
	public void delete(Object e) {
		getSession().delete(e);
		logger.info("Object deleted successfully");		
	}

	@Override
	public List getAllObjects() {	
		 return null;
	
	}

	@Override
	public Object getObjectById(Object e) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void saveOrUpdate(Object e) {
		getSession().saveOrUpdate(e);
		logger.info("Object deleted successfully");		
		
	}



}
