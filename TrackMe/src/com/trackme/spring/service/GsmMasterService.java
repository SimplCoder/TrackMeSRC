package com.trackme.spring.service;

import com.trackme.spring.model.UserMaster;

public interface GsmMasterService {

	public int ignitionOnVehicleCount(UserMaster currentUser);
	public int ignitionOffVehicleCount(UserMaster currentUser);
	public int movingVehicleCount(UserMaster currentUser);
	public int idleVehicleCount(UserMaster currentUser);
	public int overSpeedVehicleCount(UserMaster currentUser);
	public int alertOnVehicleCount(UserMaster currentUser);
	public int getNotRespondingVehicleCount(UserMaster currentUser);
}
