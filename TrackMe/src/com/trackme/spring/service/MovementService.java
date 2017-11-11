package com.trackme.spring.service;

import java.util.List;

import com.trackme.spring.model.Movement;

public interface MovementService {

	public void addMovement(Movement p);
	public void updateMovement(Movement p);
	public List<Movement> listMovements();
	public Movement getMovementById(String deviceNo);
	public void removeMovement(String userName);
	
}
