package com.trackme.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trackme.constants.Constant;
import com.trackme.spring.dao.VehicleGroupDAO;
import com.trackme.spring.model.LinkConf;
import com.trackme.spring.model.RoleMaster;
import com.trackme.spring.model.VehicleGroup;
import com.trackme.spring.model.VehicleMaster;

@Service("vehicleGroupService")
public class VehicleGroupServiceImpl implements VehicleGroupService {

	@Autowired
	private VehicleGroupDAO vehicleGroupDAO;
	
	@Autowired
	VehicleMasterService vehicleMasterService;
	
	@Override
	@Transactional
	public void addVehicleGroup(VehicleGroup vehicleGroup) {
		attachVehiclesToGroup(vehicleGroup);
		vehicleGroupDAO.addVehicleGroup(vehicleGroup);
		
	}

	@Override
	@Transactional
	public void updateVehicleGroup(VehicleGroup vehicleGroup) {
		attachVehiclesToGroup(vehicleGroup);
		vehicleGroupDAO.updateVehicleGroup(vehicleGroup);
		
	}
	

	@Override
	@Transactional
	public List<VehicleGroup> listVehicleGroup() {
		return vehicleGroupDAO.listVehicleGroup();
	}

	@Override
	@Transactional
	public VehicleGroup getVehicleGroupById(String VehicleGroupId) {
		return vehicleGroupDAO.getVehicleGroupById(VehicleGroupId);
	}

	@Override
	@Transactional
	public void removeVehicleGroup(String VehicleGroupId) {
		VehicleGroup vehicleGroup = vehicleGroupDAO.getVehicleGroupById(VehicleGroupId);
		vehicleGroup.setStatus(Constant.STATUS_INACTIVE);
	vehicleGroupDAO.updateVehicleGroup(vehicleGroup);
		
	}

	@Override
	@Transactional
	public void reomoveExistingVehiclesFromGroup(String VehicleGroupId) {
		vehicleGroupDAO.reomoveExistingVehiclesFromGroup(VehicleGroupId);
	}

	void attachVehiclesToGroup(VehicleGroup vehicleGroup ){
		List<VehicleMaster> vehicles= new ArrayList<>();
		if(vehicleGroup.getVehicleNos()!=null){
		for(String vehicleMaster: vehicleGroup.getVehicleNos()){
			if(vehicleMaster!=null )
			vehicles.add(vehicleMasterService.getVehicleMasterById(vehicleMaster));
		}
		vehicleGroup.setVehicleMasters(vehicles);
		
		}
		
	}
	
}
