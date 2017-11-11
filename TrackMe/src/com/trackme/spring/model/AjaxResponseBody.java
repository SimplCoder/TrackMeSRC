package com.trackme.spring.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.trackme.spring.jsonview.Views;

public class AjaxResponseBody {

	@JsonView(Views.Public.class)
	String msg;
	@JsonView(Views.Public.class)
	String code;
	@JsonView(Views.Public.class)
	List<StatusCount> result;
	
	@JsonView(Views.Public.class)
	String allVehicle;
	
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}



	public List<StatusCount> getResult() {
		return result;
	}

	public void setResult(List<StatusCount> result) {
		this.result = result;
	}
	

	public String getAllVehicle() {
		return allVehicle;
	}

	public void setAllVehicle(String allVehicle) {
		this.allVehicle = allVehicle;
	}

	@Override
	public String toString() {
		return "AjaxResponseResult [msg=" + msg + ", code=" + code + ", allVehicle=" + allVehicle + ", result=" + result + "]";
	}

}
