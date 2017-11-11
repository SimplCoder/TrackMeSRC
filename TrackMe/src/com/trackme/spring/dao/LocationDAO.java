package com.trackme.spring.dao;

import java.util.List;

import com.trackme.spring.model.Location;

public interface LocationDAO {
	
	public void addLocationMaster(Location location);
	public void updateLocation(Location location);
	public List<Location> listLocation();
	public Location getLocationByLocationName(String locationName);
	public void removeLocation(String locationName);

}
