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
import com.trackme.spring.model.Alert;
import com.trackme.spring.model.UserMaster;


@Repository
public class AlertDAOImpl implements AlertDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(AlertDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}


	@Override
	public void addAlert(Alert alert) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(alert);
		logger.info("alert saved successfully, alert Details="+alert);
	}

	@Override
	public void updateAlert(Alert alert) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(alert);
		session.flush();
		logger.info("alert updated successfully, alert Details="+alert);
	}

	@Override
	public List<Alert> listAlert() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Alert> alertList = session.createQuery("from Alert where status like '"+Constant.STATUS_ACTIVE+"' ").list();
		
		return alertList;
	}

	@Override
	public Alert getAlertByDeviceNo(String deviceNo) {
		try{
			Session session = this.sessionFactory.getCurrentSession();		
			Alert alert = (Alert) session.load(Alert.class, deviceNo);
			logger.info("Alert loaded successfully, Alert details="+alert);
			return alert;
			}catch(Exception e){
				logger.equals(e.getMessage());
			}
			return null;
	}

	@Override
	public void removeAlert(String deviceNo) {
		Session session = this.sessionFactory.getCurrentSession();
		Alert p = (Alert) session.load(Alert.class, deviceNo);
		if(null != p){
			session.delete(p);
		}
		logger.info("Alert deleted successfully, Alert details="+p);
		
	}

}
