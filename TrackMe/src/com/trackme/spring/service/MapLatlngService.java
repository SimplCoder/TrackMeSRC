package com.trackme.spring.service;

import java.util.List;

import com.trackme.spring.model.UserMaster;

public interface MapLatlngService {
	public List getAllVehicleLocation(UserMaster userMaster);
	public List getLatlngDetailsByVehicleNo(String vehicleNo,String fromDate, String toDate);
	public  String getLastIngnitionOf(String vehicleNo);
	public double getDistance(double lat1, double lng1, double lat2, double lng2, String unit);
}
