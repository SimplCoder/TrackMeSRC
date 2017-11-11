package com.trackme.spring.service;

import java.util.List;

import com.trackme.spring.model.VehicleService;

public interface VehicleServiceService {

	public void addVehicleService(VehicleService p);
	public void updateVehicleService(VehicleService p);
	public List<VehicleService> listVehicleServices();
	public VehicleService getVehicleServiceById(String id);
	public void removeVehicleService(String id);
	
}
