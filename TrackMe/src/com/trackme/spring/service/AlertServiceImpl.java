package com.trackme.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trackme.constants.Constant;
import com.trackme.spring.dao.AlertDAO;
import com.trackme.spring.dao.UserMasterDAO;
import com.trackme.spring.model.Alert;
import com.trackme.spring.model.UserMaster;

@Service("alertService")

public class AlertServiceImpl implements AlertService {
	
	@Autowired
	private AlertDAO alertDAO;

	

	public AlertDAO getAlertDAO() {
		return alertDAO;
	}

	public void setAlertDAO(AlertDAO alertDAO) {
		this.alertDAO = alertDAO;
	}


	@Override
	@Transactional
	public void addAlert(Alert p) {
		alertDAO.addAlert(p);
	}

	@Override
	@Transactional
	public void updateAlert(Alert p) {
		alertDAO.updateAlert(p);
	}

	@Override
	@Transactional
	public List<Alert> listAlerts() {
		return alertDAO.listAlert();
	}

	@Override
	@Transactional
	public Alert getAlertById(String deviceNo) {
		
		return alertDAO.getAlertByDeviceNo(deviceNo);
	}

	@Override
	@Transactional
	public void removeAlert(String deviceNo) {
		Alert alert= alertDAO.getAlertByDeviceNo(deviceNo);
		alert.setStatus(Constant.STATUS_INACTIVE);
		alertDAO.updateAlert(alert);
		
	}

}
