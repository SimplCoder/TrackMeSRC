package com.trackme.spring.service;

import java.util.List;

import com.trackme.spring.model.Alert;

public interface AlertService {

	public void addAlert(Alert p);
	public void updateAlert(Alert p);
	public List<Alert> listAlerts();
	public Alert getAlertById(String deviceNo);
	public void removeAlert(String userName);
	
}
