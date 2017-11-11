package com.trackme.spring.dao;

import java.util.List;

import com.trackme.spring.model.UserMaster;

public interface MapLatlngDAO {
	public List getAllVehicleLocation(UserMaster userMaster); 
	public List getLatlngDetailsByVehicleNo(String vehicleNo, String fromDate, String toDate);
	public  String getLastIngnitionOf(String vehicleNo);
}
