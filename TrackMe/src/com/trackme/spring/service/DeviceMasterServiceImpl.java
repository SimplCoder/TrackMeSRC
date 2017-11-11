package com.trackme.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trackme.constants.Constant;
import com.trackme.spring.dao.DeviceMasterDAO;
import com.trackme.spring.dao.UserMasterDAO;
import com.trackme.spring.model.DeviceMaster;
import com.trackme.spring.model.UserMaster;

@Service("deviceMasterService")

public class DeviceMasterServiceImpl implements DeviceMasterService {
	
	@Autowired
	private DeviceMasterDAO deviceMasterDAO;

	

	public DeviceMasterDAO getDeviceMasterDAO() {
		return deviceMasterDAO;
	}

	public void setDeviceMasterDAO(DeviceMasterDAO deviceMasterDAO) {
		this.deviceMasterDAO = deviceMasterDAO;
	}


	@Override
	@Transactional
	public void addDeviceMaster(DeviceMaster p) {
		deviceMasterDAO.addDeviceMaster(p);
	}

	@Override
	@Transactional
	public void updateDeviceMaster(DeviceMaster p) {
		deviceMasterDAO.updateDeviceMaster(p);
	}

	@Override
	@Transactional
	public List<DeviceMaster> listDeviceMasters() {
		return deviceMasterDAO.listDeviceMaster();
	}

	@Override
	@Transactional
	public DeviceMaster getDeviceMasterById(String deviceNo) {
		
		return deviceMasterDAO.getDeviceMasterByDeviceNo(deviceNo);
	}

	@Override
	@Transactional
	public void removeDeviceMaster(String deviceNo) {
		DeviceMaster deviceMaster= deviceMasterDAO.getDeviceMasterByDeviceNo(deviceNo);
		deviceMaster.setStatus(Constant.STATUS_INACTIVE);
		deviceMasterDAO.updateDeviceMaster(deviceMaster);
		
	}

}
