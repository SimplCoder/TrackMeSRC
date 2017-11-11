package com.trackme.spring.dao;

import java.util.List;

import com.trackme.spring.model.Alert;

public interface AlertDAO {

	public void addAlert(Alert alert);
	public void updateAlert(Alert alert);
	public List<Alert> listAlert();
	public Alert getAlertByDeviceNo(String deviceNo);
	public void removeAlert(String deviceNo);
}
