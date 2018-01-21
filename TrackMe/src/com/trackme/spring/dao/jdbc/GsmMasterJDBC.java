package com.trackme.spring.dao.jdbc;

import com.trackme.spring.model.UserMaster;

public interface GsmMasterJDBC {

	public int getVehicleCountByStatus(String status,UserMaster user);
	public int getNotRespondingVehicleCount(UserMaster user);
}
