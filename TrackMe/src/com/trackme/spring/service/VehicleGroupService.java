package com.trackme.spring.service;

import java.util.List;

import com.trackme.spring.model.VehicleGroup;

public interface VehicleGroupService {
	
	public void addVehicleGroup(VehicleGroup vehicleGroup);
	public void updateVehicleGroup(VehicleGroup vehicleGroup);
	public List<VehicleGroup> listVehicleGroup();
	public VehicleGroup getVehicleGroupById(String VehicleGroupId);
	public void removeVehicleGroup(String VehicleGroupId);
	public void reomoveExistingVehiclesFromGroup(String VehicleGroupId);
	
}
