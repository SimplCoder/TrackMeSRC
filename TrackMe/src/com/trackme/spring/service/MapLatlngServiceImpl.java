package com.trackme.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trackme.spring.dao.MapLatlngDAO;
import com.trackme.spring.model.UserMaster;

@Service("mapLatlngService")
public class MapLatlngServiceImpl implements MapLatlngService {

	@Autowired
	private MapLatlngDAO mapLatlngDAO;
	
	@Override
	@Transactional
	public List getAllVehicleLocation(UserMaster userMaster) {
		return mapLatlngDAO.getAllVehicleLocation(userMaster);
	}
	
	@Override
	@Transactional
	public List getLatlngDetailsByVehicleNo(String vehicleNo, String fromDate, String toDate){
		return mapLatlngDAO.getLatlngDetailsByVehicleNo(vehicleNo, fromDate, toDate);
	}

	@Override
	@Transactional
	public String getLastIngnitionOf(String vehicleNo) {
		// TODO Auto-generated method stub
		return mapLatlngDAO.getLastIngnitionOf(vehicleNo);
	}

	@Override
	@Transactional
	public double getDistance(double lat1, double lng1, double lat2, double lng2,
			String unit) {
		double theta = lng1 - lng2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		if (unit == "K") {
			dist = dist * 1.609344;
		} else if (unit == "N") {
			dist = dist * 0.8684;
		}

		return (dist);
	}
	
	private double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}
	
	private double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
}
