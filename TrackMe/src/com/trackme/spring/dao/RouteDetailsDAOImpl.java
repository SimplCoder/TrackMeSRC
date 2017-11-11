package com.trackme.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trackme.constants.Constant;
import com.trackme.spring.model.DeviceMaster;
import com.trackme.spring.model.LocationsForRoute;
import com.trackme.spring.model.Route;

@Repository("RouteDetailsDAO")
public class RouteDetailsDAOImpl implements RouteDetailsDAO{

	private static final Logger logger = LoggerFactory.getLogger(VehicleMasterDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}	
	
	@Override
	public void addRouteDetails(Route routeDetails) {
		Session session = this.sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(routeDetails);
	/*	for(LocationsForRoute l : routeDetails.getLocationsForRoute()){
			session.saveOrUpdate(l);
		}*/
		logger.info("routeDetails saved successfully, routeDetails Details="+routeDetails);
	}

	
	

	@Override
	public void updateRouteDetails(Route routeDetails) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(routeDetails);
		session.flush();
		logger.info("routeDetails updated successfully, routeDetails Details="+routeDetails);
	
	}

	@Override
	public List<Route> listRouteDetails() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Route> routeDetailList =null;
		try{
			routeDetailList = session.createQuery("from Route where status like '"+Constant.STATUS_ACTIVE+"' ").list();
		}catch(Exception e){
			return null;
		}
		return routeDetailList;
	}

	@Override
	public Route getRouteDetailsById(String routeDetailsId) {
		try{
			Session session = this.sessionFactory.getCurrentSession();
			
			Route route = (Route) session.load(Route.class, routeDetailsId);
			logger.info("routeDetailsId loaded successfully, routeDetailsId details="+route);
			return route;
			}catch(Exception e){
				logger.equals(e.getMessage());
			}
			return null;
	}

		


	@Override
	public void removeRouteDetails(String routeDetailsId) {
		Session session = this.sessionFactory.getCurrentSession();
		Route p = (Route) session.load(DeviceMaster.class, routeDetailsId);
		if(null != p){
			session.delete(p);
		}
		logger.info("Route deleted successfully, Route details="+p);
		
	}

}
