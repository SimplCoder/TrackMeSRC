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
import com.trackme.spring.model.LinkConf;
import com.trackme.spring.model.UserMaster;


@Repository
public class LinkConfDAOImpl implements LinkConfDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(LinkConfDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}


	@Override
	public void addLinkConf(LinkConf linkConf) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(linkConf);
		logger.info("linkConf saved successfully, linkConf Details="+linkConf);
	}

	@Override
	public void updateLinkConf(LinkConf linkConf) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(linkConf);
		session.flush();
		logger.info("linkConf updated successfully, linkConf Details="+linkConf);
	}

	@Override
	public List<LinkConf> listLinkConf() {
		Session session = this.sessionFactory.getCurrentSession();
		List<LinkConf> linkConfList = session.createQuery("from LinkConf where status like '"+Constant.STATUS_ACTIVE+"' ").list();
		
		return linkConfList;
	}

	@Override
	public LinkConf getLinkConfById(String id1) {
		try{
			 if(id1!=null && id1 !=""){
			Integer id= Integer.parseInt(id1);
			Session session = this.sessionFactory.getCurrentSession();
			String q ="from LinkConf where id="+id;
	 		org.hibernate.Query query =session.createQuery(q);
			LinkConf linkConf =(LinkConf) query.list().get(0);
			return linkConf;
			 }else{
				 return null;
			 }
		  
		}catch(Exception e){
			return null;
		}
			
			
	}

	@Override
	public void removeLinkConf(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		LinkConf p = (LinkConf) session.load(LinkConf.class, Integer.parseInt(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("LinkConf deleted successfully, LinkConf details="+p);
		
	}

}
