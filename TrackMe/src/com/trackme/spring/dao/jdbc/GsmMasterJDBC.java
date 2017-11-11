package com.trackme.spring.dao.jdbc;


public interface GsmMasterJDBC {

	public int getVehicleCountByStatus(String status);
	public int getNotRespondingVehicleCount();
}
