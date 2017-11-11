package com.trackme.spring.dao;

import java.util.List;

import com.trackme.spring.model.GeoFenceDetail;

public interface GeoFencingDAO {

	public void addGeoFence(GeoFenceDetail geoFenceDetail);
	public void updateGeoFence(GeoFenceDetail geoFenceDetail);
	public List<GeoFenceDetail> getGeoFenceList();
	public GeoFenceDetail getGeoFenceById(int geoFenceId);
	public void removeGeoFence(int geoFenceId);
	
	public void saveGeoFenceUsingHibrnate(GeoFenceDetail geoFenceDetail);
	public void deleteVehicleGeoFence(String id);
	public List getGeoFenceOutDetails();
	public List getGeoFenceInDetails();
	
}
