package com.trackme.spring.model;

import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.util.StringUtils;

import com.trackme.constants.Constant;

@Entity
@Table(name="devicemaster")
public class DeviceMaster
{
@Id
@Column(name="Device_NO")
  private String deviceNo;

@Column(name="Device_IMEI")
  private String deviceIMEI;

@Column(name="Device_Module")
  private String deviceModule;

@Column(name="Sim_Number")
  private String simNumber;

@Column(name="Sim_Provider")
  private String simProvider;

@Column(name="createddate")
  private Date createdDate;

public String getCreatedBy() {
	return createdBy;
}

public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}

@Column(name="createdBy")
private String createdBy;

@Column(name="modifiedBy")
  private String modifiedBy;

@Column(name="modifiedDate")
  private Date modifiedDate;
@Transient
private String  createdDateShow;
@Transient
private String  modifiedDateShow;



  
  public String getDeviceNo() {
	return deviceNo;
}

public void setDeviceNo(String deviceNo) {
	this.deviceNo = deviceNo;
}

public String getDeviceIMEI() {
	return deviceIMEI;
}

public void setDeviceIMEI(String deviceIMEI) {
	this.deviceIMEI = deviceIMEI;
}

public String getDeviceModule() {
	return deviceModule;
}

public void setDeviceModule(String deviceModule) {
	this.deviceModule = deviceModule;
}

public String getSimNumber() {
	return simNumber;
}

public void setSimNumber(String simNumber) {
	this.simNumber = simNumber;
}

public String getSimProvider() {
	return simProvider;
}

public void setSimProvider(String simProvider) {
	this.simProvider = simProvider;
}

public Date getCreatedDate()
  {
    return this.createdDate;
  }
  
  public void setCreatedDate(Date createdDate)
  {
    this.createdDate = createdDate;
  }
  
  public String getModifiedBy()
  {
    return this.modifiedBy;
  }
  
  public void setModifiedBy(String modifiedBy)
  {
    this.modifiedBy = modifiedBy;
  }
  
  public Date getModifiedDate()
  {
	  
    return this.modifiedDate;
  }
  
  public void setModifiedDate(Date modifiedDate)
  {
    this.modifiedDate = modifiedDate;
  }

public String getCreatedDateShow() {
	if(this.createdDate!=null){
		return Constant.dateFormater.format(this.createdDate);
	}
		else{
		return "";
		}
//	return createdDateShow;
}

public void setCreatedDateShow(String createdDateShow) {
	if(StringUtils.isEmpty(createdDateShow))
	this.createdDate = null;
	else
		try {
			this.createdDate=Constant.dateFormater.parse(createdDateShow);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	this.createdDateShow = createdDateShow;
}

public String getModifiedDateShow() {
	if(this.modifiedDate!=null){
		return Constant.dateFormater.format(this.modifiedDate);
	}
		else{
		return "";
		}
//	return modifiedDateShow;
}

public void setModifiedDateShow(String modifiedDateShow) {
	if(StringUtils.isEmpty(modifiedDateShow))
	this.modifiedDate = null;
	else
		try {
			this.modifiedDate=Constant.dateFormater.parse(modifiedDateShow);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	this.modifiedDateShow = modifiedDateShow;
}
  
@Transient
boolean editFlag;

public boolean isEditFlag() {
	return editFlag;
}

public void setEditFlag(boolean editFlag) {
	this.editFlag = editFlag;
}

@Column(name="status")
String status;

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}
  
}
