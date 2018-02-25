package com.trackme.spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trackme.spring.dao.jdbc.VehicleNotifiactionJdbc;
import com.trackme.spring.model.VehicleNotification;

@Service("vehicleNotificationServiceImpl")
public class VehicleNotificationServiceImpl implements VehicleNotificationService{

	@Autowired
	VehicleNotifiactionJdbc vehicleNotifiactionJdbc;
	
	@Autowired
	private MailService mailService;
	
	
	
	@Override
	public void sendAlert() {
		Map<Integer,VehicleNotification> vehicleNotificatioList=vehicleNotificatioList();
		 for (Entry<Integer, VehicleNotification> entry : vehicleNotificatioList.entrySet()) {
			 VehicleNotification vehicleNotification=  entry.getValue();
			 String msgToSend=vehicleNotification.vehicleNo+vehicleNotification.locationName;
			 if((vehicleNotification.isEntered==false && vehicleNotification.isEntrynotified==false) || (vehicleNotification.isEntered==true && vehicleNotification.isEntrynotified==false)){
				 msgToSend=msgToSend+" has entered";
				 vehicleNotifiactionJdbc.updateVehicleNotifaction("Entred",true,vehicleNotification.vehicleNo);
			 }
			 if((vehicleNotification.isExited==false && vehicleNotification.isExitnotified==false) || (vehicleNotification.isExited==true && vehicleNotification.isExitnotified==false)){
				 msgToSend=msgToSend+" has exited";
				 vehicleNotifiactionJdbc.updateVehicleNotifaction("Exited",true,vehicleNotification.vehicleNo);
			 }
				List<String> emailIds=new ArrayList<String>();
				emailIds.add(vehicleNotification.mailId);
				
			    mailService.sendMail("vinitkumarbhardwaj@gmail.com", emailIds, emailIds, msgToSend, "vechicle");
			    
				// mailService.sendMail("vinitkumarbhardwaj@gmail.com", emailIds, emailIds, "ddd", "vechicle");
		 }
		 
	}
	
	public Map<Integer,VehicleNotification> vehicleNotificatioList(){
		Map<Integer,VehicleNotification> mapVehicle=new HashMap<Integer,VehicleNotification>();  
		 List<Map<String, Object>> vehicleNotificatioList = vehicleNotifiactionJdbc.getVehicleNotificatioList();
		 int i=0;
		 for (Map<String, Object> map : vehicleNotificatioList) {
			VehicleNotification vehicleNotification=new VehicleNotification();
			for (Map.Entry<String,Object> entry : map.entrySet()) {
				switch(entry.getKey()){
                case "vehicleno":      vehicleNotification.vehicleNo=(String) entry.getValue();break;
				case "alertid":        vehicleNotification.alertId=(String) entry.getValue();break;
				case "locationid":     vehicleNotification.locationId=(String) entry.getValue();break;
				case "locationname":   vehicleNotification.locationName=(String) entry.getValue();break;
				case "alertbysms":     vehicleNotification.alertBySms=(Boolean) entry.getValue();break;
				case "alertbymail":    vehicleNotification.alertByMail=(Boolean) entry.getValue();break;
				case "isentered":      vehicleNotification.isEntered=(Boolean) entry.getValue();break;
				case "isexited":       vehicleNotification.isExited=(Boolean) entry.getValue();break;
				case "isentrynotified":vehicleNotification.isEntrynotified=(Boolean) entry.getValue();break;
				case "isexitnotified": vehicleNotification.isEntrynotified=(Boolean) entry.getValue();break;
				case "email":       vehicleNotification.mailId=(String) entry.getValue();break;
			
				}
	            System.out.println("Key = " + entry.getKey() +", Value = " + entry.getValue());
			}
			mapVehicle.put(i++, vehicleNotification);
	    }
		 System.out.println(":::::::::::::::"+mapVehicle.size());
	
		 return mapVehicle;
	}

}
