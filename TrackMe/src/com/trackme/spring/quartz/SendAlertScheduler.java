package com.trackme.spring.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.trackme.spring.service.MailService;
import com.trackme.spring.service.VehicleNotificationService;

@Configuration
@EnableScheduling
public class SendAlertScheduler {

	@Autowired
	private MailService mailService;
	
	@Autowired
	@Qualifier(value="vehicleNotificationServiceImpl")
	private VehicleNotificationService vehicleNotificationService;
	
	
	 @Scheduled(cron = "* */2 * * * SUN,MON,TUE,WED,THU,FRI,SAT")
	   public void sendAlert() {
	     System.out.println("::::Alert");  
	     vehicleNotificationService.sendAlert();
	    }
}
