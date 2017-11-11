package com.trackme.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trackme.constants.Constant;
import com.trackme.spring.dao.DriverConfDAO;
import com.trackme.spring.dao.UserMasterDAO;
import com.trackme.spring.model.DriverConf;
import com.trackme.spring.model.UserMaster;

@Service("driverConfService")

public class DriverConfServiceImpl implements DriverConfService {
	
	@Autowired
	private DriverConfDAO driverConfDAO;

	

	public DriverConfDAO getDriverConfDAO() {
		return driverConfDAO;
	}

	public void setDriverConfDAO(DriverConfDAO driverConfDAO) {
		this.driverConfDAO = driverConfDAO;
	}


	@Override
	@Transactional
	public void addDriverConf(DriverConf p) {
		driverConfDAO.addDriverConf(p);
	}

	@Override
	@Transactional
	public void updateDriverConf(DriverConf p) {
		driverConfDAO.updateDriverConf(p);
	}

	@Override
	@Transactional
	public List<DriverConf> listDriverConfs() {
		return driverConfDAO.listDriverConf();
	}

	@Override
	@Transactional
	public DriverConf getDriverConfById(String id) {
		
		return driverConfDAO.getDriverConfById(id);
	}

	@Override
	@Transactional
	public void removeDriverConf(String id) {
		DriverConf driverConf= driverConfDAO.getDriverConfById(id);
		driverConf.setStatus(Constant.STATUS_INACTIVE);
		driverConfDAO.updateDriverConf(driverConf);
		
	}

}
