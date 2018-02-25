package com.trackme.spring.dao.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("VehicleNotifiactionJdbc")
public class VehicleNotifiactionJdbcImpl implements VehicleNotifiactionJdbc {


	@Autowired
	private JdbcTemplate jdbcTemplate;  
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}

	@Override
	public List<Map<String, Object>> getVehicleNotificatioList() {
	
		String query="select a.alertbysms,a.alertbymail,a.locationname,a.vehicleno,v.alertid,v.locationid,v.isentered,v.isexited,v.isentrynotified,v.isexitnotified,a.email from alert a, vehiclenotification v where a.vehicleno=v.vehicleno";
		try{
		List<Map<String, Object>> queryForList = jdbcTemplate.queryForList(query);
		return queryForList;
		}catch(Exception e){
				System.out.println(e);
		}
		return null;
	}

	@Override
	public void updateVehicleNotifaction(String string, boolean b,String vechicleNo) {
	
		String query="update vehiclenotification set isentered=true ,isentrynotified=true where vehicleno='"+vechicleNo+"'";
		jdbcTemplate.update(query);
	}  

}
