package com.trackme.spring.dao;

import java.util.List;

import com.trackme.spring.model.Movement;

public interface MovementDAO {

	public void addMovement(Movement movement);
	public void updateMovement(Movement movement);
	public List<Movement> listMovement();
	public Movement getMovementByDeviceNo(String deviceNo);
	public void removeMovement(String deviceNo);
}
