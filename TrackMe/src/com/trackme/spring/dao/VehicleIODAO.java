package com.trackme.spring.dao;

import java.util.List;

import com.trackme.spring.model.VehicleIO;

public interface VehicleIODAO {

	public void addVehicleIO(VehicleIO vehicleIO);
	public void updateVehicleIO(VehicleIO vehicleIO);
	public List<VehicleIO> listVehicleIO();
	public VehicleIO getVehicleIOById(String id);
	public void removeVehicleIO(String id);
}
