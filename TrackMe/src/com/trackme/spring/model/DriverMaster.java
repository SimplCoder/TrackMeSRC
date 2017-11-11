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
@Table(name="drivermaster")
public class DriverMaster
{
  @Id
  @Column(name="id")  	
  private Integer id;
  
  @Column(name="drivername")  
  private String driverName;
  
  @Column(name="address")  
  private String address;
  
  @Column(name="contact1")  
  private String contact1;
  
  @Column(name="contact2")  
  private String contact2;
  
  @Column(name="licenseno")  
  private String licenseNo;
  
  @Column(name="licenseexpirydate")  
  private Date licenseExpiryDate;
  
  @Column(name="rtoname")  
  private String rtoName;
  
  @Column(name="bloodgroup")  
  private String bloodGroup;
  
  @Column(name="username")  
  private String userName;
  
  @Column(name="createdby")  
  private String createdBy;
  
  @Column(name="createddate")  
  private Date createdDate;
  
  @Column(name="modifiedby")  
  private String modifiedBy;
  
  @Column(name="modifieddate")  
  private Date modifiedDate;
  
  @Column(name="driverexp")  
  private String driverexp;
  
  @Column(name="remark")  
  private String remark;
 
 @Transient
 private String formatedCreatedDate;  
 @Transient
  private String formatedExpireDate;
 @Transient
  private String formatedModifiedDate;



public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}

public String getDriverName() {
	return driverName;
}
public void setDriverName(String driverName) {
	this.driverName = driverName;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getContact1() {
	return contact1;
}
public void setContact1(String contact1) {
	this.contact1 = contact1;
}
public String getContact2() {
	return contact2;
}
public void setContact2(String contact2) {
	this.contact2 = contact2;
}
public String getLicenseNo() {
	return licenseNo;
}
public void setLicenseNo(String licenseNo) {
	this.licenseNo = licenseNo;
}
public Date getLicenseExpiryDate() {
	return licenseExpiryDate;
}
public void setLicenseExpiryDate(Date licenseExpiryDate) {
	this.licenseExpiryDate = licenseExpiryDate;
}
public String getRtoName() {
	return rtoName;
}
public void setRtoName(String rtoName) {
	this.rtoName = rtoName;
}
public String getBloodGroup() {
	return bloodGroup;
}
public void setBloodGroup(String bloodGroup) {
	this.bloodGroup = bloodGroup;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}
public Date getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
}
public String getModifiedBy() {
	return modifiedBy;
}
public void setModifiedBy(String modifiedBy) {
	this.modifiedBy = modifiedBy;
}
public Date getModifiedDate() {
	return modifiedDate;
}
public void setModifiedDate(Date modifiedDate) {
	this.modifiedDate = modifiedDate;
}
public String getDriverexp() {
	return driverexp;
}
public void setDriverexp(String driverexp) {
	this.driverexp = driverexp;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}

public String getFormatedCreatedDate() {
	
	if(this.createdDate!=null){
		return Constant.dateFormater.format(this.createdDate);
	}
		else{
		return "";
		}
}

public void setFormatedCreatedDate(String formatedCreatedDate) {
	if(StringUtils.isEmpty(formatedCreatedDate))
		this.createdDate = null;
		else
			try {
				this.createdDate=Constant.dateFormater.parse(formatedCreatedDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		this.formatedCreatedDate = formatedCreatedDate;
}
public String getFormatedExpireDate() {
	if(this.licenseExpiryDate!=null){
		return Constant.dateFormater.format(this.licenseExpiryDate);
	}
		else{
		return "";
		}
}
public void setFormatedExpireDate(String formatedExpireDate) {
	
	if(StringUtils.isEmpty(formatedExpireDate))
		this.licenseExpiryDate = null;
		else
			try {
				this.licenseExpiryDate=Constant.dateFormater.parse(formatedExpireDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	this.formatedExpireDate = formatedExpireDate;
}
public String getFormatedModifiedDate() {
	if(this.modifiedDate!=null){
		return Constant.dateFormater.format(this.modifiedDate);
	}
		else{
		return "";
		}
}
public void setFormatedModifiedDate(String formatedModifiedDate) {
	
	if(StringUtils.isEmpty(formatedModifiedDate))
		this.modifiedDate = null;
		else
			try {
				this.modifiedDate=Constant.dateFormater.parse(formatedModifiedDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	this.formatedModifiedDate = formatedModifiedDate;
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
