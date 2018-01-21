package com.trackme.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trackme.spring.dao.jdbc.GsmMasterJDBC;
import com.trackme.spring.model.User;
import com.trackme.spring.model.UserMaster;



@Service("gsmMasterService")
public class GsmMasterServiceImpl implements GsmMasterService{

	@Autowired
	private GsmMasterJDBC gsmMasterJDBC;
	
	@Override
	@Transactional
	public int ignitionOnVehicleCount(UserMaster currentUser) {
		// TODO Auto-generated method stub
		String arrStatus="1";
		return gsmMasterJDBC.getVehicleCountByStatus(arrStatus,currentUser);
	}

	@Override
	@Transactional
	public int ignitionOffVehicleCount(UserMaster currentUser) {
		String arrStatus="0,14,68";
		return gsmMasterJDBC.getVehicleCountByStatus(arrStatus,currentUser);
	}

	@Override
	@Transactional
	public int movingVehicleCount(UserMaster currentUser) {
		String arrStatus="2,3,4,5,6,10,16,17,19,23";
		return gsmMasterJDBC.getVehicleCountByStatus(arrStatus,currentUser);
	}

	@Override
	@Transactional
	public int idleVehicleCount(UserMaster currentUser) {
		String arrStatus="8,18";
		return gsmMasterJDBC.getVehicleCountByStatus(arrStatus,currentUser);
	}

	@Override
	@Transactional
	public int overSpeedVehicleCount(UserMaster currentUser) {
		String arrStatus="7,15";
		return gsmMasterJDBC.getVehicleCountByStatus(arrStatus,currentUser);
	}

	@Override
	@Transactional
	public int alertOnVehicleCount(UserMaster currentUser) {
		String arrStatus="5,7,15";
		return gsmMasterJDBC.getVehicleCountByStatus(arrStatus,currentUser);
	}
	@Override
	@Transactional 
	public int getNotRespondingVehicleCount(UserMaster currentUser){
		return gsmMasterJDBC.getNotRespondingVehicleCount(currentUser);
	}
}
