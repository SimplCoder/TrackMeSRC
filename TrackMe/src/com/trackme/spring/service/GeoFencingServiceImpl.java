package com.trackme.spring.service;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trackme.spring.dao.GeoFencingDAO;
import com.trackme.spring.model.GeoFenceDetail;
import com.trackme.spring.model.UserMaster;

import javafx.scene.shape.Circle;

@Service("geoFencingService")
public class GeoFencingServiceImpl implements GeoFencingService {
	
	@Autowired
	private GeoFencingDAO geoFencingDAO;

	@Autowired
	FirebaseService firebaseService;
	
	@Autowired
	UserMasterService userMasterService;
	
	@Autowired
	private MapLatlngService mapLatlngService;
	
	public GeoFencingDAO getGeoFencingDAO() {
		return geoFencingDAO;
	}

	public void setGeoFencingDAO(GeoFencingDAO geoFencingDAO) {
		this.geoFencingDAO = geoFencingDAO;
	}

	@Override
	@Transactional
	public void addGeoFence(GeoFenceDetail geoFenceDetail) {
		//geoFencingDAO.addGeoFence(geoFenceDetail);
		geoFencingDAO.saveGeoFenceUsingHibrnate(geoFenceDetail);
	}

	@Override
	@Transactional
	public void updateGeoFence(GeoFenceDetail geoFenceDetail) {
		geoFencingDAO.updateGeoFence(geoFenceDetail);
	}

	@Override
	@Transactional
	public List<GeoFenceDetail> getGeoFenceList() {
		return geoFencingDAO.getGeoFenceList();
	}

	@Override
	@Transactional
	public GeoFenceDetail getGeoFenceById(int geoFenceId) {
		return geoFencingDAO.getGeoFenceById(geoFenceId);
	}

	@Override
	@Transactional
	public void removeGeoFence(int geoFenceId) {
		geoFencingDAO.removeGeoFence(geoFenceId);
	}

	@Override
	public void createPushNotification() {
			UserMaster userMaster=null;
			String body= "VTS notifation for app";
			String title= "VTS notifation";
			List<UserMaster> userMasters =userMasterService.listUserMasters();
			if(userMasters!=null)
			{
				Iterator<UserMaster> iter= userMasters.iterator();
				while(iter.hasNext())
					{
					 userMaster= iter.next();
					 if(userMaster!=null && userMaster.getNotificationId()!=null){
						 firebaseService.pushNotification(userMaster.getNotificationId(),body,title,"" );	 
					 }
					}
			}
			
			
	
	}
	
	
	@Override
	public void studentGeofencePushNotification() {
		
		this.getGeoFenceOutDetails();
		this.getGeoFenceInDetails();
	}
	
	
	public void deleteVehicleGeoFence(String id){
	geoFencingDAO.deleteVehicleGeoFence(id);	
	}

	@Override
	public void getGeoFenceOutDetails() {
		// TODO Auto-generated method stub
		
		
		UserMaster userMaster=null;
		String body= "School bus is started from ";
		String title= "VTS notifation";
		String notificationId=null;
		String geofenceName=null;
		List<Map<String, Object>> userMasters =geoFencingDAO.getGeoFenceOutDetails();
		if(userMasters!=null)
		{
			Iterator<Map<String, Object>> iter= userMasters.iterator();
			while(iter.hasNext())
				{
				 Map user= iter.next();
				 notificationId=(String)user.get("notificationid");
				 geofenceName=(String)user.get("geofencename");
				
				 if(notificationId!=null && notificationId!=""){
					 firebaseService.pushNotification(notificationId,body+geofenceName,title,"" );	 
				 }
				}
		}

		
		
		
	}

	@Override
	public void getGeoFenceInDetails() {
		// TODO Auto-generated method stub
		
		UserMaster userMaster=null;
		String body= "School bus is reached at ";
		String title= "VTS notifation";
		String notificationId=null;
		String geofenceName=null;
		List<Map<String, Object>> userMasters =geoFencingDAO.getGeoFenceInDetails();
		if(userMasters!=null)
		{
			Iterator<Map<String, Object>> iter= userMasters.iterator();
			while(iter.hasNext())
				{
				 Map user= iter.next();
				 notificationId=(String)user.get("notificationid");
				 geofenceName=(String)user.get("geofencename");
				
				 if(notificationId!=null && notificationId!=""){
					 firebaseService.pushNotification(notificationId,body+geofenceName,title,"" );	 
				 }
				}
		}

		
		
	}
	

	
	

}