package com.trackme.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trackme.constants.Constant;
import com.trackme.spring.dao.RouteScheduleDAO;
import com.trackme.spring.model.Route;
import com.trackme.spring.model.RouteSchedule;

@Service("routeScheduleService")
public class RouteScheduleServiceImpl implements RouteScheduleService{

	@Autowired
	private RouteScheduleDAO routeScheduleDAO;
	
	@Override
	@Transactional
	public void addRouteScheduleDetails(RouteSchedule routeSchedule) {
		routeScheduleDAO.addRouteScheduleDetails(routeSchedule);
	}

	@Override
	@Transactional
	public void updateRouteScheduleDetails(RouteSchedule routeSchedule) {
		routeScheduleDAO.updateRouteScheduleDetails(routeSchedule);
	}

	@Override
	@Transactional
	public List<RouteSchedule> listRouteScheduleDetails() {
		
		return routeScheduleDAO.listRouteScheduleDetails();
	}

	@Override
	@Transactional
	public RouteSchedule getRouteScheduleDetailsById(String routeScheduleId) {
		return routeScheduleDAO.getRouteScheduleDetailsById(routeScheduleId);
	}

	@Override
	@Transactional
	public void removeRouteScheduleDetails(String routeScheduleId) {
	RouteSchedule routeSchedule = routeScheduleDAO.getRouteScheduleDetailsById(routeScheduleId);
			routeSchedule.setStatus(Constant.STATUS_INACTIVE);
	routeScheduleDAO.updateRouteScheduleDetails(routeSchedule);
	}

	@Override
	public void deleteVehicleSchedule(String id) {
		routeScheduleDAO.deleteVehicleSchedule(id);
	}
	
}
