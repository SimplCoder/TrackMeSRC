package com.trackme.spring.dao.jdbc;

import java.util.List;
import java.util.Map;

public interface VehicleNotifiactionJdbc {
	
	public List<Map<String, Object>> getVehicleNotificatioList();

	public void updateVehicleNotifaction(String string, boolean b,String vechicleNo);

}
