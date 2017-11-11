package com.trackme.spring.dao;

import java.util.List;

import com.trackme.spring.model.DriverConf;

public interface DriverConfDAO {

	public void addDriverConf(DriverConf driverConf);
	public void updateDriverConf(DriverConf driverConf);
	public List<DriverConf> listDriverConf();
	public DriverConf getDriverConfById(String id);
	public void removeDriverConf(String id);
}
