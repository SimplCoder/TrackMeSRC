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
import com.trackme.spring.model.DriverConf;
import com.trackme.spring.model.UserMaster;


@Repository
public class DriverConfDAOImpl implements DriverConfDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(DriverConfDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}


	@Override
	public void addDriverConf(DriverConf driverConf) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(driverConf);
		logger.info("driverConf saved successfully, driverConf Details="+driverConf);
	}

	@Override
	public void updateDriverConf(DriverConf driverConf) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(driverConf);
		session.flush();
		logger.info("driverConf updated successfully, driverConf Details="+driverConf);
	}

	@Override
	public List<DriverConf> listDriverConf() {
		Session session = this.sessionFactory.getCurrentSession();
		List<DriverConf> driverConfList = session.createQuery("from DriverConf where status like '"+Constant.STATUS_ACTIVE+"' ").list();
		
		return driverConfList;
	}

	@Override
	public DriverConf getDriverConfById(String id1) {
		try{
			 if(id1!=null && id1 !=""){
			Integer id= Integer.parseInt(id1);
			Session session = this.sessionFactory.getCurrentSession();
			String q ="from DriverConf where id="+id;
	 		org.hibernate.Query query =session.createQuery(q);
			DriverConf driverConf =(DriverConf) query.list().get(0);
			return driverConf;
			 }else{
				 return null;
			 }
		  
		}catch(Exception e){
			return null;
		}
			
			
	}

	@Override
	public void removeDriverConf(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		DriverConf p = (DriverConf) session.load(DriverConf.class, Integer.parseInt(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("DriverConf deleted successfully, DriverConf details="+p);
		
	}

}
