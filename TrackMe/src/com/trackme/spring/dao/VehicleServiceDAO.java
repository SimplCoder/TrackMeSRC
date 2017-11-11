package com.trackme.spring.dao;

import java.util.List;

import com.trackme.spring.model.VehicleService;

public interface VehicleServiceDAO {

	public void addVehicleService(VehicleService vehicleService);
	public void updateVehicleService(VehicleService vehicleService);
	public List<VehicleService> listVehicleService();
	public VehicleService getVehicleServiceById(String id);
	public void removeVehicleService(String id);
}
