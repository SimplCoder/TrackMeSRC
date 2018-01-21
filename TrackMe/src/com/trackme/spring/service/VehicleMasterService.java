package com.trackme.spring.service;

import java.util.Date;
import java.util.List;

import com.trackme.spring.model.GPSTracking;
import com.trackme.spring.model.UserMaster;
import com.trackme.spring.model.VehicleMaster;

public interface VehicleMasterService {

	public void addVehicleMaster(VehicleMaster p);
	public void updateVehicleMaster(VehicleMaster p);
	public List<VehicleMaster> listVehicleMasters();
	public VehicleMaster getVehicleMasterById(String vehicleNo);
	public void removeVehicleMaster(String vehicleNo);
	public int totaNoOffVehicle(UserMaster currentUser );
	
	public void saveGPSTracking(GPSTracking gpsTracking);

	public List<VehicleMaster> getInsuranceExpiringVehicle(Date date);
	public List<VehicleMaster> getNPExpiringVehicle(Date date);
	public List<VehicleMaster> getServicingVeicle(Date date);
}
