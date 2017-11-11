package com.trackme.spring.service;

import java.util.List;

import com.trackme.spring.model.DriverConf;

public interface DriverConfService {

	public void addDriverConf(DriverConf p);
	public void updateDriverConf(DriverConf p);
	public List<DriverConf> listDriverConfs();
	public DriverConf getDriverConfById(String id);
	public void removeDriverConf(String id);
	
}
