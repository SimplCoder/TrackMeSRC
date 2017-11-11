package com.trackme.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.trackme.constants.Constant;
import com.trackme.spring.model.DeviceMaster;
import com.trackme.spring.model.Route;
import com.trackme.spring.model.RouteSchedule;

@Repository("RouteScheduleDAO")
public class RouteScheduleDAOImpl implements RouteScheduleDAO{

	private static final Logger logger = LoggerFactory.getLogger(VehicleMasterDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;  

	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addRouteScheduleDetails(RouteSchedule routeSchedule) {
		Session session = this.sessionFactory.getCurrentSession();
		
		
		session.saveOrUpdate(routeSchedule);
			logger.info("routeSchedule saved successfully, routeSchedule Details="+routeSchedule);

	}

	@Override
	public void updateRouteScheduleDetails(RouteSchedule routeSchedule) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(routeSchedule);
		session.flush();
		logger.info("routeSchedule updated successfully, routeSchedule Details="+routeSchedule);
		
	}

	@Override
	public List<RouteSchedule> listRouteScheduleDetails() {
		Session session = this.sessionFactory.getCurrentSession();
		List<RouteSchedule> routeScheduleList =null;
		try{
			routeScheduleList = session.createQuery("from RouteSchedule where status like '"+Constant.STATUS_ACTIVE+"' ").list();
		}catch(Exception e){
			return null;
		}
		return routeScheduleList;
	}

	@Override
	public RouteSchedule getRouteScheduleDetailsById(String routeScheduleId) {
		try{
			Session session = this.sessionFactory.getCurrentSession();
			
			RouteSchedule route = (RouteSchedule) session.load(RouteSchedule.class, routeScheduleId);
			logger.info("routeDetailsId loaded successfully, routeDetailsId details="+route);
			return route;
			}catch(Exception e){
				logger.equals(e.getMessage());
			}
			return null;
	}

	@Override
	public void removeRouteScheduleDetails(String routeScheduleId) {
		Session session = this.sessionFactory.getCurrentSession();
		RouteSchedule p = (RouteSchedule) session.load(RouteSchedule.class, routeScheduleId);
		if(null != p){
			session.delete(p);
		}
		logger.info("RouteSchedule deleted successfully, RouteSchedule details="+p);
		
	}

	
	@Override
	public void deleteVehicleSchedule(String id) {
		String query = "delete from routevehicle where scheduleName= '"+id+"' ";
		jdbcTemplate.execute(query);
	}

	
}
