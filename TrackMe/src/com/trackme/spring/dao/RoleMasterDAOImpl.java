package com.trackme.spring.dao;

import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.trackme.constants.Constant;
import com.trackme.spring.model.RoleMaster;
import com.trackme.spring.model.UserMaster;


@Repository
public class RoleMasterDAOImpl implements RoleMasterDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(RoleMasterDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;  
	
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}


	@Override
	public void addRoleMaster(RoleMaster roleMaster) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(roleMaster);
		logger.info("roleMaster saved successfully, roleMaster Details="+roleMaster);
	}

	@Override
	public void updateRoleMaster(RoleMaster roleMaster) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(roleMaster);
		session.flush();
		logger.info("roleMaster updated successfully, roleMaster Details="+roleMaster);
	}

	@Override
	public List<RoleMaster> listRoleMaster() {
		Session session = this.sessionFactory.getCurrentSession();
		List<RoleMaster> roleMasterList = session.createQuery("from RoleMaster where status like '"+Constant.STATUS_ACTIVE+"' ").list();
		
		return roleMasterList;
	}

	@Override
	public RoleMaster getRoleMasterById(String id1) {
		try{
			 if(id1!=null && id1 !=""){
			Integer id= Integer.parseInt(id1);
			Session session = this.sessionFactory.getCurrentSession();
			String q ="from RoleMaster where id="+id;
	 		org.hibernate.Query query =session.createQuery(q);
			RoleMaster roleMaster =(RoleMaster) query.list().get(0);
			return roleMaster;
			 }else{
				 return null;
			 }
		  
		}catch(Exception e){
			return null;
		}
			
			
	}

	@Override
	public void removeRoleMaster(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		RoleMaster p = (RoleMaster) session.load(RoleMaster.class, Integer.parseInt(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("RoleMaster deleted successfully, RoleMaster details="+p);
		
	}


	@Override
	public void deleteRoleLink(String id) {
		String query = "delete from rolelink where roleid="+id;
		jdbcTemplate.execute(query);
	}

}
