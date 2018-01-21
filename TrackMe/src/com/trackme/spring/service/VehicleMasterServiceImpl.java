package com.trackme.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trackme.constants.Constant;
import com.trackme.spring.dao.VehicleMasterDAO;
import com.trackme.spring.model.GPSTracking;
import com.trackme.spring.model.User;
import com.trackme.spring.model.UserMaster;
import com.trackme.spring.model.VehicleMaster;

@Service("vehicleMasterService")
public class VehicleMasterServiceImpl implements VehicleMasterService {
	
	@Autowired
	private VehicleMasterDAO vehicleMasterDAO;

	public void setVehicleMasterDAO(VehicleMasterDAO vehicleMasterDAO) {
		this.vehicleMasterDAO = vehicleMasterDAO;
	}

	@Override
	@Transactional
	public void addVehicleMaster(VehicleMaster p) {
		this.vehicleMasterDAO.addVehicleMaster(p);
	}

	@Override
	@Transactional
	public void updateVehicleMaster(VehicleMaster p) {
		this.vehicleMasterDAO.updateVehicleMaster(p);
	}

	@Override
	@Transactional
	public List<VehicleMaster> listVehicleMasters() {
		return this.vehicleMasterDAO.listVehicleMasters();
	}

	@Override
	@Transactional
	public VehicleMaster getVehicleMasterById(String vehicleNo) {
		return this.vehicleMasterDAO.getVehicleMasterById(vehicleNo);
	}

	@Override
	@Transactional
	public void removeVehicleMaster(String vehicleNo) {
		VehicleMaster vehicleMaster=vehicleMasterDAO.getVehicleMasterById(vehicleNo);
		vehicleMaster.setStatus(Constant.STATUS_INACTIVE);
		this.vehicleMasterDAO.updateVehicleMaster(vehicleMaster);
	}

	@Override
	@Transactional
	public int totaNoOffVehicle(UserMaster currentUser) {
		// TODO Auto-generated method stub
		return this.vehicleMasterDAO.totaNoOffVehicle(currentUser);
	}

	@Override
	@Transactional
	public void saveGPSTracking(GPSTracking gpsTracking) {
	this.vehicleMasterDAO.saveGPSTracking(gpsTracking);
	}

	@Override
	@Transactional
	public List<VehicleMaster> getInsuranceExpiringVehicle(Date date) {
		// TODO Auto-generated method stub
		return vehicleMasterDAO.getInsuranceExpiringVehicle(date);
	}

	@Override
	@Transactional
	public List<VehicleMaster> getNPExpiringVehicle(Date date) {
		// TODO Auto-generated method stub
		return vehicleMasterDAO.getNPExpiringVehicle(date);
	}

	@Override
	@Transactional
	public List<VehicleMaster> getServicingVeicle(Date date) {
		// TODO Auto-generated method stub
		return vehicleMasterDAO.getServicingVeicle(date);
	}

}
