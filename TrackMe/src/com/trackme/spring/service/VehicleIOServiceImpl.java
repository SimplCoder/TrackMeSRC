package com.trackme.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trackme.constants.Constant;
import com.trackme.spring.dao.VehicleIODAO;
import com.trackme.spring.dao.UserMasterDAO;
import com.trackme.spring.model.VehicleIO;
import com.trackme.spring.model.UserMaster;

@Service("vehicleIOService")

public class VehicleIOServiceImpl implements VehicleIOService {
	
	@Autowired
	private VehicleIODAO vehicleIODAO;

	

	public VehicleIODAO getVehicleIODAO() {
		return vehicleIODAO;
	}

	public void setVehicleIODAO(VehicleIODAO vehicleIODAO) {
		this.vehicleIODAO = vehicleIODAO;
	}


	@Override
	@Transactional
	public void addVehicleIO(VehicleIO p) {
		vehicleIODAO.addVehicleIO(p);
	}

	@Override
	@Transactional
	public void updateVehicleIO(VehicleIO p) {
		vehicleIODAO.updateVehicleIO(p);
	}

	@Override
	@Transactional
	public List<VehicleIO> listVehicleIOs() {
		return vehicleIODAO.listVehicleIO();
	}

	@Override
	@Transactional
	public VehicleIO getVehicleIOById(String id) {
		
		return vehicleIODAO.getVehicleIOById(id);
	}

	@Override
	@Transactional
	public void removeVehicleIO(String id) {
		VehicleIO vehicleIO= vehicleIODAO.getVehicleIOById(id);
		vehicleIO.setStatus(Constant.STATUS_INACTIVE);
		vehicleIODAO.updateVehicleIO(vehicleIO);
		
	}

}
