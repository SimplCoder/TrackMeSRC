package com.trackme.spring.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.trackme.spring.jsonview.Views;

public class StatusCount
{
	@JsonView(Views.Public.class)
	String totalVehicle;
	@JsonView(Views.Public.class)
	String ignitionOn;
	@JsonView(Views.Public.class)
	String ignitionOff;
	@JsonView(Views.Public.class)
	String moving;
	@JsonView(Views.Public.class)
	String idle;
	@JsonView(Views.Public.class)
	String alert;
	//@JsonView(Views.Public.class)
	//String notResponding;
	public String getTotalVehicle() {
		return totalVehicle;
	}
	public void setTotalVehicle(String totalVehicle) {
		this.totalVehicle = totalVehicle;
	}
	public String getIgnitionOn() {
		return ignitionOn;
	}
	public void setIgnitionOn(String ignitionOn) {
		this.ignitionOn = ignitionOn;
	}
	public String getIgnitionOff() {
		return ignitionOff;
	}
	public void setIgnitionOff(String ignitionOff) {
		this.ignitionOff = ignitionOff;
	}
	public String getMoving() {
		return moving;
	}
	public void setMoving(String moving) {
		this.moving = moving;
	}
	public String getIdle() {
		return idle;
	}
	public void setIdle(String idle) {
		this.idle = idle;
	}
	public String getAlert() {
		return alert;
	}
	public void setAlert(String alert) {
		this.alert = alert;
	}
	public StatusCount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StatusCount(String totalVehicle, String ignitionOn, String ignitionOff, String moving, String idle,
			String alert) {
		super();
		this.totalVehicle = totalVehicle;
		this.ignitionOn = ignitionOn;
		this.ignitionOff = ignitionOff;
		this.moving = moving;
		this.idle = idle;
		this.alert = alert;
		//this.notResponding = notResponding;
	}
	
	
}
