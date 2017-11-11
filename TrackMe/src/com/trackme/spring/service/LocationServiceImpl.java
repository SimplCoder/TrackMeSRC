package com.trackme.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trackme.constants.Constant;
import com.trackme.spring.dao.DeviceMasterDAO;
import com.trackme.spring.dao.LocationDAO;
import com.trackme.spring.model.DeviceMaster;
import com.trackme.spring.model.Location;

@Service("locationService")
public class LocationServiceImpl implements LocationService{

	@Autowired
	private LocationDAO locationDAO;

	@Override
	@Transactional
	public void addLocation(Location p) {
		locationDAO.addLocationMaster(p);
	}

	@Override
	@Transactional
	public void updateLocation(Location p) {
		locationDAO.updateLocation(p);
	}

	@Override
	@Transactional
	public List<Location> listLocations() {
		return locationDAO.listLocation();
		}

	@Override
	@Transactional
	public Location getLocationByName(String name) {
		return locationDAO.getLocationByLocationName(name);
	}

	@Override
	@Transactional
	public void removeLocation(String name) {
		Location location= locationDAO.getLocationByLocationName(name);
		location.setStatus(Constant.STATUS_INACTIVE);
		locationDAO.updateLocation(location);
			
	}

}
