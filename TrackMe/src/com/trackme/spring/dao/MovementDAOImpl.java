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
import com.trackme.spring.model.Movement;
import com.trackme.spring.model.UserMaster;


@Repository
public class MovementDAOImpl implements MovementDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(MovementDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}


	@Override
	public void addMovement(Movement movement) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(movement);
		logger.info("movement saved successfully, movement Details="+movement);
	}

	@Override
	public void updateMovement(Movement movement) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(movement);
		session.flush();
		logger.info("movement updated successfully, movement Details="+movement);
	}

	@Override
	public List<Movement> listMovement() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Movement> movementList = session.createQuery("from Movement where status like '"+Constant.STATUS_ACTIVE+"' ").list();
		
		return movementList;
	}

	@Override
	public Movement getMovementByDeviceNo(String deviceNo) {
		try{
			 if(deviceNo!=null && deviceNo !=""){
			Integer id= Integer.parseInt(deviceNo);
			Session session = this.sessionFactory.getCurrentSession();
			String q ="from Movement where id="+id;
			org.hibernate.Query query =session.createQuery(q);
			Movement movement =(Movement) query.list().get(0);
			return movement;
			 }else{
				 return null;
			 }
		  
		}catch(Exception e){
			return null;
		}
			
			
	}

	@Override
	public void removeMovement(String deviceNo) {
		Session session = this.sessionFactory.getCurrentSession();
		Movement p = (Movement) session.load(Movement.class, Integer.parseInt(deviceNo));
		if(null != p){
			session.delete(p);
		}
		logger.info("Movement deleted successfully, Movement details="+p);
		
	}

}
