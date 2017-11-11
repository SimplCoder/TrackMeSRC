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
import com.trackme.spring.model.CompanyMaster;
import com.trackme.spring.model.UserMaster;


@Repository
public class CompanyMasterDAOImpl implements CompanyMasterDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(CompanyMasterDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}


	@Override
	public void addCompanyMaster(CompanyMaster companyMaster) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(companyMaster);
		logger.info("companyMaster saved successfully, companyMaster Details="+companyMaster);
	}

	@Override
	public void updateCompanyMaster(CompanyMaster companyMaster) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(companyMaster);
		session.flush();
		logger.info("companyMaster updated successfully, companyMaster Details="+companyMaster);
	}

	@Override
	public List<CompanyMaster> listCompanyMaster() {
		Session session = this.sessionFactory.getCurrentSession();
		List<CompanyMaster> companyMasterList = session.createQuery("from CompanyMaster where status like '"+Constant.STATUS_ACTIVE+"' ").list();
		
		return companyMasterList;
	}

	@Override
	public CompanyMaster getCompanyMasterByCompanyId(String companyId) {
		try{
			 if(companyId!=null && companyId !=""){
			Integer id= Integer.parseInt(companyId);
			Session session = this.sessionFactory.getCurrentSession();
			String q ="from CompanyMaster where id="+id;
			org.hibernate.Query query =session.createQuery(q);
			CompanyMaster companyMaster =(CompanyMaster) query.list().get(0);
			return companyMaster;
			 }else{
				 return null;
			 }
		  
		}catch(Exception e){
			return null;
		}
			
			
	}

	@Override
	public void removeCompanyMaster(String companyId) {
		Session session = this.sessionFactory.getCurrentSession();
		CompanyMaster p = (CompanyMaster) session.load(CompanyMaster.class, Integer.parseInt(companyId));
		if(null != p){
			session.delete(p);
		}
		logger.info("CompanyMaster deleted successfully, CompanyMaster details="+p);
		
	}

}
