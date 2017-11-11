package com.trackme.spring.service;

import java.util.List;

import com.trackme.spring.model.DeviceMaster;
import com.trackme.spring.model.Location;

public interface LocationService {
	public void addLocation(Location p);
	public void updateLocation(Location p);
	public List<Location> listLocations();
	public Location getLocationByName(String name);
	public void removeLocation(String name);
}
