package com.trackme.spring.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.util.StringUtils;

import com.trackme.constants.Constant;
 
@Entity
@Table(name="vehicleio")
public class VehicleIO
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	  private Integer id;

	
@Column(name="vehicleNo")
  private String vehicleNo;

@Column(name="deviceno")
  private String deviceNo;

@Column(name="gpo1")
  private String gpo1;

@Column(name="type1")
  private String type1;

@Column(name="levelmax1")
  private String leveMax1;

@Column(name="statustype1")
  private String statusType1;


@Column(name="gpo2")
private String gpo2;

@Column(name="type2")
private String type2;

@Column(name="levelmax2")
private String leveMax2;

@Column(name="statustype2")
private String statusType2;


@Column(name="gpo3")
private String gpo3;

@Column(name="type3")
private String type3;

@Column(name="levelmax3")
private String leveMax3;

@Column(name="statustype3")
private String statusType3;


@Column(name="gpo4")
private String gpo4;

@Column(name="type4")
private String type4;

@Column(name="levelmax4")
private String leveMax4;

@Column(name="statustype4")
private String statusType4;

@Column(name="gpo5")
private String gpo5;

@Column(name="type5")
private String type5;

@Column(name="levelmax5")
private String leveMax5;

@Column(name="statustype5")
private String statusType5;


@Column(name="gpo6")
private String gpo6;

@Column(name="type6")
private String type6;

@Column(name="levelmax6")
private String leveMax6;

@Column(name="statustype6")
private String statusType6;


@Column(name="adc1")
private String adc1;

@Column(name="adc2")
private String adc2;

@Column(name="createdby")
  private String createdBy;

@Column(name="createddate")
  private Date createdDate;

@Column(name="modifiedby")
  private String modifiedBy;

@Column(name="modifieddate")
  private Date modifiedDate;





  public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getVehicleNo() {
	return vehicleNo;
}

public void setVehicleNo(String vehicleNo) {
	this.vehicleNo = vehicleNo;
}

public String getDeviceNo() {
	return deviceNo;
}

public void setDeviceNo(String deviceNo) {
	this.deviceNo = deviceNo;
}

public String getGpo1() {
	return gpo1;
}

public void setGpo1(String gpo1) {
	this.gpo1 = gpo1;
}

public String getType1() {
	return type1;
}

public void setType1(String type1) {
	this.type1 = type1;
}

public String getLeveMax1() {
	return leveMax1;
}

public void setLeveMax1(String leveMax1) {
	this.leveMax1 = leveMax1;
}

public String getStatusType1() {
	return statusType1;
}

public void setStatusType1(String statusType1) {
	this.statusType1 = statusType1;
}

public String getGpo2() {
	return gpo2;
}

public void setGpo2(String gpo2) {
	this.gpo2 = gpo2;
}

public String getType2() {
	return type2;
}

public void setType2(String type2) {
	this.type2 = type2;
}

public String getLeveMax2() {
	return leveMax2;
}

public void setLeveMax2(String leveMax2) {
	this.leveMax2 = leveMax2;
}

public String getStatusType2() {
	return statusType2;
}

public void setStatusType2(String statusType2) {
	this.statusType2 = statusType2;
}

public String getGpo3() {
	return gpo3;
}

public void setGpo3(String gpo3) {
	this.gpo3 = gpo3;
}

public String getType3() {
	return type3;
}

public void setType3(String type3) {
	this.type3 = type3;
}

public String getLeveMax3() {
	return leveMax3;
}

public void setLeveMax3(String leveMax3) {
	this.leveMax3 = leveMax3;
}

public String getStatusType3() {
	return statusType3;
}

public void setStatusType3(String statusType3) {
	this.statusType3 = statusType3;
}

public String getGpo4() {
	return gpo4;
}

public void setGpo4(String gpo4) {
	this.gpo4 = gpo4;
}

public String getType4() {
	return type4;
}

public void setType4(String type4) {
	this.type4 = type4;
}

public String getLeveMax4() {
	return leveMax4;
}

public void setLeveMax4(String leveMax4) {
	this.leveMax4 = leveMax4;
}

public String getStatusType4() {
	return statusType4;
}

public void setStatusType4(String statusType4) {
	this.statusType4 = statusType4;
}

public String getGpo5() {
	return gpo5;
}

public void setGpo5(String gpo5) {
	this.gpo5 = gpo5;
}

public String getType5() {
	return type5;
}

public void setType5(String type5) {
	this.type5 = type5;
}

public String getLeveMax5() {
	return leveMax5;
}

public void setLeveMax5(String leveMax5) {
	this.leveMax5 = leveMax5;
}

public String getStatusType5() {
	return statusType5;
}

public void setStatusType5(String statusType5) {
	this.statusType5 = statusType5;
}

public String getGpo6() {
	return gpo6;
}

public void setGpo6(String gpo6) {
	this.gpo6 = gpo6;
}

public String getType6() {
	return type6;
}

public void setType6(String type6) {
	this.type6 = type6;
}

public String getLeveMax6() {
	return leveMax6;
}

public void setLeveMax6(String leveMax6) {
	this.leveMax6 = leveMax6;
}

public String getStatusType6() {
	return statusType6;
}

public void setStatusType6(String statusType6) {
	this.statusType6 = statusType6;
}



public String getAdc1() {
	return adc1;
}

public void setAdc1(String adc1) {
	this.adc1 = adc1;
}

public String getAdc2() {
	return adc2;
}

public void setAdc2(String adc2) {
	this.adc2 = adc2;
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

@Transient
  String createdOnShow;
  @Transient
  String modifiedOnShow;
  
  

public String getCreatedOnShow() {
	if(this.createdDate!=null)
	return Constant.dateFormater.format(this.createdDate);
	else
	return "";
}

public String getModifiedOnShow() {
	if(this.modifiedDate!=null)
	return Constant.dateFormater.format(this.modifiedDate);
	else
	return "";
}

public void setCreatedOnShow(String createdOnShow) {
	
	if(StringUtils.isEmpty(createdOnShow))
	this.createdDate = null;
	else
		try {
			this.createdDate=Constant.dateFormater.parse(createdOnShow);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	this.createdOnShow = createdOnShow;
}

public void setModifiedOnShow(String modifiedOnShow) {
	if(StringUtils.isEmpty(modifiedOnShow))
	this.modifiedDate = null;
	else
		try {
			this.modifiedDate=Constant.dateFormater.parse(modifiedOnShow);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	this.modifiedOnShow = modifiedOnShow;
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
