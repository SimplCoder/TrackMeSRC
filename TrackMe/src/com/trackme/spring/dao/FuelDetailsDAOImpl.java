package com.trackme.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trackme.constants.Constant;
import com.trackme.spring.model.FuelDetail;

@Repository("FuelDetailsDAO")
public class FuelDetailsDAOImpl implements FuelDetailsDAO{

	private static final Logger logger = LoggerFactory.getLogger(VehicleMasterDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	
	@Override
	public void addFuelDetails(FuelDetail fuelDetails) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateFuelDetails(FuelDetail fuelDetails) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FuelDetail> listFuelDetails() {
		Session session = this.sessionFactory.getCurrentSession();
		List<FuelDetail> fuelDetailList =null;
		try{
		 fuelDetailList = session.createQuery("from FuelDetail where status like '"+Constant.STATUS_ACTIVE+"' ").list();
		}catch(Exception e){
			return null;
		}
		return fuelDetailList;
	}

	@Override
	public FuelDetail getFuelDetailsById(String fuelDetailId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeFuelDetail(String fuelDetailId) {
		// TODO Auto-generated method stub
		
	}

}
