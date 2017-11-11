package com.trackme.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trackme.constants.Constant;
import com.trackme.spring.dao.RouteDetailsDAO;
import com.trackme.spring.model.Route;

@Service("routeService")
public class RouteServiceImpl implements RouteService{

	@Autowired
	private RouteDetailsDAO routeDetailsDAO;
	
	@Override
	@Transactional
	public void addRouteDetails(Route routeDetails) {
	routeDetailsDAO.addRouteDetails(routeDetails);	
	}

	@Override
	@Transactional
	public void updateRouteDetails(Route routeDetails) {
		routeDetailsDAO.updateRouteDetails(routeDetails);
	}

	@Override
	@Transactional
	public List<Route> listRouteDetails() {
		return routeDetailsDAO.listRouteDetails();
	}

	@Override
	@Transactional
	public Route getRouteDetailsById(String routeDetailsId) {
		return routeDetailsDAO.getRouteDetailsById(routeDetailsId);
		
	}

	@Override
	@Transactional
	public void removeRouteDetails(String routeDetailsId) {
		Route Route = routeDetailsDAO.getRouteDetailsById(routeDetailsId);
		Route.setStatus(Constant.STATUS_INACTIVE);
		routeDetailsDAO.updateRouteDetails(Route);
	}

}
