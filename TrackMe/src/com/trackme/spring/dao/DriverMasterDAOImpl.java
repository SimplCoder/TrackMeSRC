package com.trackme.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.trackme.constants.Constant;
import com.trackme.spring.model.DriverMaster;


@Repository("DriverDetailsDAO")
public class DriverMasterDAOImpl implements DriverMasterDAO{

	private static final Logger logger = LoggerFactory.getLogger(VehicleMasterDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public List<DriverMaster> getDriverMasterList() {
		Session session = this.sessionFactory.getCurrentSession();
		List<DriverMaster> driverMasterList = session.createQuery("from DriverMaster where status like '"+Constant.STATUS_ACTIVE+"' ").list();	
		return driverMasterList;
	}

	@Override
	public void removeDriverMaster(String driverId) {
		Session session = this.sessionFactory.getCurrentSession();
		DriverMaster driverMaster = (DriverMaster) session.load(DriverMaster.class, Integer.parseInt(driverId));
		if(null != driverMaster){
			session.delete(driverMaster);
		}
		logger.info("DriverMaster deleted successfully");
		
	}

	@Override
	public void updateDriverMaster(DriverMaster d) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(d);
		logger.info("DriverMaster updated successfully");
	}

	@Override
	public void saveDriverMaster(DriverMaster driverMaster) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save("DriverMaster",driverMaster);
		logger.info("DriverMaster updated successfully");
		
	}

	@Override
	public DriverMaster getDriverMaster(String driverID) {
		DriverMaster driverMaster=null;
		Session session = this.sessionFactory.getCurrentSession();		
		try{
		Query query=session.createQuery("Select o from DriverMaster o where o.id="+Integer.parseInt(driverID));	
		driverMaster = (DriverMaster)query.list().get(0);
		}
		catch(Exception e){
			return null;
		}
		return driverMaster;
	
	}

	
}
