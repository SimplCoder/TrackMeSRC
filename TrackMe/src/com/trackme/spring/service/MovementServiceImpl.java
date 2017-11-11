package com.trackme.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trackme.constants.Constant;
import com.trackme.spring.dao.MovementDAO;
import com.trackme.spring.dao.UserMasterDAO;
import com.trackme.spring.model.Movement;
import com.trackme.spring.model.UserMaster;

@Service("movementService")

public class MovementServiceImpl implements MovementService {
	
	@Autowired
	private MovementDAO movementDAO;

	

	public MovementDAO getMovementDAO() {
		return movementDAO;
	}

	public void setMovementDAO(MovementDAO movementDAO) {
		this.movementDAO = movementDAO;
	}


	@Override
	@Transactional
	public void addMovement(Movement p) {
		movementDAO.addMovement(p);
	}

	@Override
	@Transactional
	public void updateMovement(Movement p) {
		movementDAO.updateMovement(p);
	}

	@Override
	@Transactional
	public List<Movement> listMovements() {
		return movementDAO.listMovement();
	}

	@Override
	@Transactional
	public Movement getMovementById(String deviceNo) {
		
		return movementDAO.getMovementByDeviceNo(deviceNo);
	}

	@Override
	@Transactional
	public void removeMovement(String deviceNo) {
		Movement movement= movementDAO.getMovementByDeviceNo(deviceNo);
		movement.setStatus(Constant.STATUS_INACTIVE);
		movementDAO.updateMovement(movement);
		
	}

}
