package com.trackme.spring.service;

import java.util.List;

import com.trackme.spring.model.VehicleIO;

public interface VehicleIOService {

	public void addVehicleIO(VehicleIO p);
	public void updateVehicleIO(VehicleIO p);
	public List<VehicleIO> listVehicleIOs();
	public VehicleIO getVehicleIOById(String id);
	public void removeVehicleIO(String id);
	
}
