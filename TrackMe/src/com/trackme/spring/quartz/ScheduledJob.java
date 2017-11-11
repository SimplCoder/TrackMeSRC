package com.trackme.spring.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;


public class ScheduledJob extends QuartzJobBean{
 
	
	ScheduledJobService  scheduledJobService;
     
     
	public ScheduledJobService getScheduledJobService() {
		return scheduledJobService;
	}


	public void setScheduledJobService(ScheduledJobService scheduledJobService) {
		this.scheduledJobService = scheduledJobService;
	}


	@Override
    protected void executeInternal(JobExecutionContext arg0)
            throws JobExecutionException {
		scheduledJobService.sendReminderMailForVehicleExpry();
    	System.out.println("hiii i am working");
    }
 
   
}

