package com.trackme.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trackme.spring.dao.FuelDetailsDAO;
import com.trackme.spring.model.FuelDetail;

@Service("fuelService")
public class FuelServiceImpl implements FuelService {

	@Autowired
	private FuelDetailsDAO fuelDetailsDAO;
	
	@Override
	@Transactional
	public void addFuelDetails(FuelDetail fuelDetails) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void updateFuelDetails(FuelDetail fuelDetails) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public List<FuelDetail> listFuelDetails() {
		return fuelDetailsDAO.listFuelDetails();
	}

	@Override
	@Transactional
	public FuelDetail getFuelDetailsById(String fuelDetailId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void removeFuelDetail(String fuelDetailId) {
		// TODO Auto-generated method stub
		
	}

}
