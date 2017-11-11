package com.trackme.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.trackme.constants.Constant;
import com.trackme.spring.model.DeviceMaster;
import com.trackme.spring.model.UserMaster;


@Repository
public class DeviceMasterDAOImpl implements DeviceMasterDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(DeviceMasterDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}


	@Override
	public void addDeviceMaster(DeviceMaster deviceMaster) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(deviceMaster);
		logger.info("deviceMaster saved successfully, deviceMaster Details="+deviceMaster);
	}

	@Override
	public void updateDeviceMaster(DeviceMaster deviceMaster) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(deviceMaster);
		session.flush();
		logger.info("deviceMaster updated successfully, deviceMaster Details="+deviceMaster);
	}

	@Override
	public List<DeviceMaster> listDeviceMaster() {
		Session session = this.sessionFactory.getCurrentSession();
		List<DeviceMaster> deviceMasterList = session.createQuery("from DeviceMaster where status like '"+Constant.STATUS_ACTIVE+"' ").list();
		
		return deviceMasterList;
	}

	@Override
	public DeviceMaster getDeviceMasterByDeviceNo(String deviceNo) {
		try{
			Session session = this.sessionFactory.getCurrentSession();		
			DeviceMaster deviceMaster = (DeviceMaster) session.load(DeviceMaster.class, deviceNo);
			logger.info("DeviceMaster loaded successfully, DeviceMaster details="+deviceMaster);
			return deviceMaster;
			}catch(Exception e){
				logger.equals(e.getMessage());
			}
			return null;
	}

	@Override
	public void removeDeviceMaster(String deviceNo) {
		Session session = this.sessionFactory.getCurrentSession();
		DeviceMaster p = (DeviceMaster) session.load(DeviceMaster.class, deviceNo);
		if(null != p){
			session.delete(p);
		}
		logger.info("DeviceMaster deleted successfully, DeviceMaster details="+p);
		
	}

}
