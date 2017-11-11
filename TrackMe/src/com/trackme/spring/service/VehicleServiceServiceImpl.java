package com.trackme.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trackme.constants.Constant;
import com.trackme.spring.dao.VehicleServiceDAO;
import com.trackme.spring.dao.UserMasterDAO;
import com.trackme.spring.model.VehicleService;
import com.trackme.spring.model.UserMaster;

@Service("vehicleServiceService")

public class VehicleServiceServiceImpl implements VehicleServiceService {
	
	@Autowired
	private VehicleServiceDAO vehicleServiceDAO;

	

	public VehicleServiceDAO getVehicleServiceDAO() {
		return vehicleServiceDAO;
	}

	public void setVehicleServiceDAO(VehicleServiceDAO vehicleServiceDAO) {
		this.vehicleServiceDAO = vehicleServiceDAO;
	}


	@Override
	@Transactional
	public void addVehicleService(VehicleService p) {
		vehicleServiceDAO.addVehicleService(p);
	}

	@Override
	@Transactional
	public void updateVehicleService(VehicleService p) {
		vehicleServiceDAO.updateVehicleService(p);
	}

	@Override
	@Transactional
	public List<VehicleService> listVehicleServices() {
		return vehicleServiceDAO.listVehicleService();
	}

	@Override
	@Transactional
	public VehicleService getVehicleServiceById(String id) {
		
		return vehicleServiceDAO.getVehicleServiceById(id);
	}

	@Override
	@Transactional
	public void removeVehicleService(String id) {
		VehicleService vehicleService= vehicleServiceDAO.getVehicleServiceById(id);
		vehicleService.setStatus(Constant.STATUS_INACTIVE);
		vehicleServiceDAO.updateVehicleService(vehicleService);
		
	}

}
