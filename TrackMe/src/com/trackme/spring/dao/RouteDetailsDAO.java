package com.trackme.spring.dao;

import java.util.List;

import com.trackme.spring.model.Route;

public interface RouteDetailsDAO {

	public void addRouteDetails(Route routeDetails);
	public void updateRouteDetails(Route routeDetails);
	public List<Route> listRouteDetails();
	public Route getRouteDetailsById(String routeDetailsId);
	public void removeRouteDetails(String routeDetailsId);
	
}
