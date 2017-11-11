package com.trackme.spring.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.trackme.spring.jsonview.Views;

public class GPSTracking
{
	@JsonView(Views.Public.class)
	String datetime;
	@JsonView(Views.Public.class)
	String key;
	@JsonView(Views.Public.class)
	String vehicleNo;
	@JsonView(Views.Public.class)
	String latitude;
	@JsonView(Views.Public.class)
	String longitude;
	@JsonView(Views.Public.class)
	String datetimeDate;

	public GPSTracking() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getDatetime() {
		return datetime;
	}


	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public String getVehicleNo() {
		return vehicleNo;
	}


	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	public String getDatetimeDate() {
		return datetimeDate;
	}


	public void setDatetimeDate(String datetimeDate) {
		this.datetimeDate = datetimeDate;
	}


	public GPSTracking(String datetime, String key, String vehicleNo, String latitude, String longitude,
			String datetimeDate) {
		super();
		this.datetime = datetime;
		this.key = key;
		this.vehicleNo = vehicleNo;
		this.latitude = latitude;
		this.longitude = longitude;
		this.datetimeDate = datetimeDate;
	}


	
	
	
}
