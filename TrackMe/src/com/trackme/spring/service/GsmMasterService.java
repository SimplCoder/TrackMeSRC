package com.trackme.spring.service;


public interface GsmMasterService {

	public int ignitionOnVehicleCount();
	public int ignitionOffVehicleCount();
	public int movingVehicleCount();
	public int idleVehicleCount();
	public int overSpeedVehicleCount();
	public int alertOnVehicleCount();
	public int getNotRespondingVehicleCount();
}
