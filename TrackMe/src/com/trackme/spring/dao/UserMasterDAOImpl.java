package com.trackme.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trackme.constants.Constant;
import com.trackme.spring.model.UserMaster;


@Repository("UserMasterDAO")
public class UserMasterDAOImpl implements UserMasterDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserMasterDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addUserMaster(UserMaster p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("UserMaster saved successfully, UserMaster Details="+p);
	}

	@Override
	public void updateUserMaster(UserMaster p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("UserMaster updated successfully, UserMaster Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserMaster> listUserMasters() {
		Session session = this.sessionFactory.getCurrentSession();
		List<UserMaster> UserMastersList = session.createQuery("from UserMaster where status like '"+Constant.STATUS_ACTIVE+"' ").list();
		
		return UserMastersList;
	}

	@Override
	public UserMaster getUserMasterById(String userName) {
		try{
		Session session = this.sessionFactory.getCurrentSession();		
		UserMaster p = (UserMaster) session.load(UserMaster.class, userName);
		logger.info("UserMaster loaded successfully, UserMaster details="+p);
		return p;
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public void removeUserMaster(String userName) {
		Session session = this.sessionFactory.getCurrentSession();
		UserMaster p = (UserMaster) session.load(UserMaster.class, userName);
		if(null != p){
			session.delete(p);
		}
		logger.info("UserMaster deleted successfully, UserMaster details="+p);
	}

	
}
