package com.trackme.spring.dao;

import java.util.List;

import com.trackme.spring.model.FuelDetail;

public interface FuelDetailsDAO {
	public void addFuelDetails(FuelDetail fuelDetails);
	public void updateFuelDetails(FuelDetail fuelDetails);
	public List<FuelDetail> listFuelDetails();
	public FuelDetail getFuelDetailsById(String fuelDetailId);
	public void removeFuelDetail(String fuelDetailId);
	
}
