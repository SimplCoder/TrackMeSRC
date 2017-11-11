package com.trackme.spring.quartz;

import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trackme.spring.model.VehicleMaster;
import com.trackme.spring.service.GeoFencingService;
import com.trackme.spring.service.MailService;
import com.trackme.spring.service.VehicleMasterService;

@Service
public class ScheduledJobService {

	@Autowired
	private VehicleMasterService vehicleMasterService;

	@Autowired
	private MailService mailService;

	@Autowired
	private GeoFencingService geoFencingService;

	Properties prop = new Properties();

	@PostConstruct
	void init() {
		prop = new Properties();
		InputStream input = null;

		try {

			String filename = "email.properties";
			input = ScheduledJobService.class.getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				return;
			}

			// load a properties file from class path, inside static method
			prop.load(input);
		} catch (Exception e) {

		}
	}

	void sendReminderMailForVehicleExpry() {
		Date date = new Date();
		List<VehicleMaster> insuranceVehicleList = vehicleMasterService.getInsuranceExpiringVehicle(date);
		sendMailToInsuranceExpiryVehicles(insuranceVehicleList);
		List<VehicleMaster> npVehicleList = vehicleMasterService.getNPExpiringVehicle(date);
		sendMailToNPExpiryVehicles(npVehicleList);

		List<VehicleMaster> serviceAlertVehicleList = vehicleMasterService.getServicingVeicle(date);
		sendMailToServiceAlertVehicles(serviceAlertVehicleList);

	}

	private void sendMailToInsuranceExpiryVehicles(List<VehicleMaster> insuranceVehicleList) {
		String subject = prop.getProperty("email.insuranceExpirySubject");
		String fromEmail = prop.getProperty("fromEmail");
		String from = prop.getProperty("from");

		if (insuranceVehicleList != null) {
			for (VehicleMaster vehicleMaster : insuranceVehicleList) {
				MessageFormat messageFormat = new MessageFormat(prop.getProperty("email.insuranceExpiry"));
				String[] args = { vehicleMaster.getOwnerCompanyName(), vehicleMaster.getVehicleNo(),
						vehicleMaster.getInsuranceNo(), vehicleMaster.getInsuranceIssuedBy(),
						vehicleMaster.getInsuranceDateShow(), vehicleMaster.getInsuranceExpiryDateShow(), from };
				String message = messageFormat.format(args);

				List<String> toList = new ArrayList<>();
				toList.add(vehicleMaster.getOwnerEmail());

				mailService.sendMail(fromEmail, toList, null, message, subject);

			}
		}
	}

	private void sendMailToNPExpiryVehicles(List<VehicleMaster> npVehicleList) {
		String subject = prop.getProperty("email.npExpirySubject");
		String fromEmail = prop.getProperty("fromEmail");
		String from = prop.getProperty("from");

		if (npVehicleList != null) {
			for (VehicleMaster vehicleMaster : npVehicleList) {
				MessageFormat messageFormat = new MessageFormat(prop.getProperty("email.npExpiry"));
				String[] args = { vehicleMaster.getOwnerCompanyName(), vehicleMaster.getVehicleNo(),
						vehicleMaster.getNationalPermitNo(), vehicleMaster.getNationalPermitExpiryDateShow(), from };
				String message = messageFormat.format(args);

				List<String> toList = new ArrayList<>();
				toList.add(vehicleMaster.getOwnerEmail());

				mailService.sendMail(fromEmail, toList, null, message, subject);

			}
		}
	}

	private void sendMailToServiceAlertVehicles(List<VehicleMaster> serviceAlertVehicleList) {
		String subject = prop.getProperty("email.serviceAlertSubject");
		String fromEmail = prop.getProperty("fromEmail");
		String from = prop.getProperty("from");

		if (serviceAlertVehicleList != null) {
			for (VehicleMaster vehicleMaster : serviceAlertVehicleList) {
				MessageFormat messageFormat = new MessageFormat(prop.getProperty("email.serviceAlert"));
				String[] args = { vehicleMaster.getOwnerCompanyName(), vehicleMaster.getVehicleNo(),
						String.valueOf(vehicleMaster.getServiceKm()), vehicleMaster.getServiceDateShow(), from };
				String message = messageFormat.format(args);

				List<String> toList = new ArrayList<>();
				toList.add(vehicleMaster.getOwnerEmail());

				mailService.sendMail(fromEmail, toList, null, message, subject);

			}
		}
	}
	
	public void pushNotificationForApp()
	{
		geoFencingService.createPushNotification();	
		
	}
	
	public void pushNotificationStudentForApp()
	{
		geoFencingService.studentGeofencePushNotification();	
		
	}
}
