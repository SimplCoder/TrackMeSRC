package com.trackme.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trackme.spring.dao.jdbc.GsmMasterJDBC;



@Service("gsmMasterService")
public class GsmMasterServiceImpl implements GsmMasterService{

	@Autowired
	private GsmMasterJDBC gsmMasterJDBC;
	
	@Override
	@Transactional
	public int ignitionOnVehicleCount() {
		// TODO Auto-generated method stub
		String arrStatus="1";
		return gsmMasterJDBC.getVehicleCountByStatus(arrStatus);
	}

	@Override
	@Transactional
	public int ignitionOffVehicleCount() {
		String arrStatus="0,14,68";
		return gsmMasterJDBC.getVehicleCountByStatus(arrStatus);
	}

	@Override
	@Transactional
	public int movingVehicleCount() {
		String arrStatus="2,3,4,5,6,10,16,17,19,23";
		return gsmMasterJDBC.getVehicleCountByStatus(arrStatus);
	}

	@Override
	@Transactional
	public int idleVehicleCount() {
		String arrStatus="8,18";
		return gsmMasterJDBC.getVehicleCountByStatus(arrStatus);
	}

	@Override
	@Transactional
	public int overSpeedVehicleCount() {
		String arrStatus="7,15";
		return gsmMasterJDBC.getVehicleCountByStatus(arrStatus);
	}

	@Override
	@Transactional
	public int alertOnVehicleCount() {
		String arrStatus="5,7,15";
		return gsmMasterJDBC.getVehicleCountByStatus(arrStatus);
	}
	@Override
	@Transactional 
	public int getNotRespondingVehicleCount(){
		return gsmMasterJDBC.getNotRespondingVehicleCount();
	}
}
