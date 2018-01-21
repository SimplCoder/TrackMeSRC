package com.trackme.spring.model;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.util.StringUtils;

import com.trackme.constants.Constant;

@Entity
@Table(name="vehiclemaster")
public class VehicleMaster
{
@Id
@Column(name="vehicleNo")
  private String vehicleNo;

@Column(name="unitNo")
  private BigInteger unitNo;

@Column(name="gpsNo")
  private String gpsNo;

@Column(name="vehicleSerialNo")
  private String vehicleSerialNo;

@Column(name="vehicleType")
  private String vehicleType;

@Column(name="vehicleMake")
  private String vehicleMake;

@Column(name="insuranceIssuedBy")
  private String insuranceIssuedBy;

@Column(name="insuranceNo")
  private String insuranceNo;

@Column(name="insuranceDate")
  private Date insuranceDate;

@Transient
private String insuranceDateShow;

@Column(name="insuranceExpiryDate")
  private Date insuranceExpiryDate;

@Transient
private String insuranceExpiryDateShow;

@Column(name="nationalPermitNo")
  private String nationalPermitNo;

@Column(name="nationalPermitExpiryDate")
  private Date nationalPermitExpiryDate;

@Transient
private String nationalPermitExpiryDateShow;

@Column(name="otherPermitNo")
  private String otherPermitNo;

@Column(name="otherPermitExpiryDate")
  private Date otherPermitExpiryDate;
@Transient
private String otherPermitExpiryDateShow;


@Column(name="issuedRTO")
  private String issuedRTO;

@Column(name="serviceKm")
  private int serviceKm;

@Column(name="serviceDate")
  private Date serviceDate;

@Transient
private String serviceDateShow;


@Column(name="initialOdiMeter")
  private int initialOdiMeter;

@Column(name="currentOdiMeter")
  private int currentOdiMeter;

@Column(name="currentFuel")
  private int currentFuel;

@Column(name="ownerCompanyName")
  private String ownerCompanyName;

@Column(name="ownerAddress1")
  private String ownerAddress1;

@Column(name="ownerAddress2")
  private String ownerAddress2;

@Column(name="ownerAddress3")
  private String ownerAddress3;

@Column(name="ownerCity")
  private String ownerCity;

@Column(name="ownerPinCode")
  private int ownerPinCode;

@Column(name="ownerState")
  private String ownerState;

@Column(name="ownerLicense")
  private String ownerLicense;

@Column(name="ownerContact1")
  private String ownerContact1;

@Column(name="ownerContact2")
  private String ownerContact2;

@Column(name="ownerContact3")
  private String ownerContact3;

@Column(name="ownerEmail")
  private String ownerEmail;

@Column(name="sosAlertStatus")
  private String sosAlertStatus;

@Column(name="groupName")
  private String groupName;

@Column(name="userName")
  private String userName;

@Column(name="createdBy")
  private String createdBy;

@Column(name="createdDate")
  private Date createdDate;

@Column(name="modifiedBy")
  private String modifiedBy;

@Column(name="modifiedDate")
  private Date modifiedDate;


@OneToOne
@JoinColumn(name="company")
CompanyMaster companyMaster;

  
  public String getVehicleNo()
  {
    return this.vehicleNo;
  }
  
  public void setVehicleNo(String vehicleNo)
  {
    this.vehicleNo = vehicleNo;
  }
  
  public BigInteger getUnitNo()
  {
    return this.unitNo;
  }
  
  public void setUnitNo(BigInteger unitNo)
  {
    this.unitNo = unitNo;
  }
  
  public String getGpsNo()
  {
    return this.gpsNo;
  }
  
  public void setGpsNo(String gpsNo)
  {
    this.gpsNo = gpsNo;
  }
  
  public String getVehicleSerialNo()
  {
    return this.vehicleSerialNo;
  }
  
  public void setVehicleSerialNo(String vehicleSerialNo)
  {
    this.vehicleSerialNo = vehicleSerialNo;
  }
  
  public String getVehicleType()
  {
    return this.vehicleType;
  }
  
  public void setVehicleType(String vehicleType)
  {
    this.vehicleType = vehicleType;
  }
  
  public String getVehicleMake()
  {
    return this.vehicleMake;
  }
  
  public void setVehicleMake(String vehicleMake)
  {
    this.vehicleMake = vehicleMake;
  }
  
  public String getInsuranceIssuedBy()
  {
    return this.insuranceIssuedBy;
  }
  
  public void setInsuranceIssuedBy(String insuranceIssuedBy)
  {
    this.insuranceIssuedBy = insuranceIssuedBy;
  }
  
  public String getInsuranceNo()
  {
    return this.insuranceNo;
  }
  
  public void setInsuranceNo(String insuranceNo)
  {
    this.insuranceNo = insuranceNo;
  }
  
  public Date getInsuranceDate()
  {
    return this.insuranceDate;
  }
  
  public void setInsuranceDate(Date insuranceDate)
  {
    this.insuranceDate = insuranceDate;
  }
  
  public Date getInsuranceExpiryDate()
  {
    return this.insuranceExpiryDate;
  }
  
  public void setInsuranceExpiryDate(Date insuranceExpiryDate)
  {
    this.insuranceExpiryDate = insuranceExpiryDate;
  }
  
  public String getNationalPermitNo()
  {
    return this.nationalPermitNo;
  }
  
  public void setNationalPermitNo(String nationalPermitNo)
  {
    this.nationalPermitNo = nationalPermitNo;
  }
  
  public Date getNationalPermitExpiryDate()
  {
    return this.nationalPermitExpiryDate;
  }
  
  public void setNationalPermitExpiryDate(Date nationalPermitExpiryDate)
  {
    this.nationalPermitExpiryDate = nationalPermitExpiryDate;
  }
  
  public String getOtherPermitNo()
  {
    return this.otherPermitNo;
  }
  
  public void setOtherPermitNo(String otherPermitNo)
  {
    this.otherPermitNo = otherPermitNo;
  }
  
  public Date getOtherPermitExpiryDate()
  {
    return this.otherPermitExpiryDate;
  }
  
  public void setOtherPermitExpiryDate(Date otherPermitExpiryDate)
  {
    this.otherPermitExpiryDate = otherPermitExpiryDate;
  }
  
  public String getIssuedRTO()
  {
    return this.issuedRTO;
  }
  
  public void setIssuedRTO(String issuedRTO)
  {
    this.issuedRTO = issuedRTO;
  }
  
  public int getServiceKm()
  {
    return this.serviceKm;
  }
  
  public void setServiceKm(int serviceKm)
  {
    this.serviceKm = serviceKm;
  }
  
  public Date getServiceDate()
  {
    return this.serviceDate;
  }
  
  public void setServiceDate(Date serviceDate)
  {
    this.serviceDate = serviceDate;
  }
  
  public int getInitialOdiMeter()
  {
    return this.initialOdiMeter;
  }
  
  public void setInitialOdiMeter(int initialOdiMeter)
  {
    this.initialOdiMeter = initialOdiMeter;
  }
  
  public int getCurrentOdiMeter()
  {
    return this.currentOdiMeter;
  }
  
  public void setCurrentOdiMeter(int currentOdiMeter)
  {
    this.currentOdiMeter = currentOdiMeter;
  }
  
  public int getCurrentFuel()
  {
    return this.currentFuel;
  }
  
  public void setCurrentFuel(int currentFuel)
  {
    this.currentFuel = currentFuel;
  }
  
  public String getOwnerCompanyName()
  {
    return this.ownerCompanyName;
  }
  
  public void setOwnerCompanyName(String ownerCompanyName)
  {
    this.ownerCompanyName = ownerCompanyName;
  }
  
  public String getOwnerAddress1()
  {
    return this.ownerAddress1;
  }
  
  public void setOwnerAddress1(String ownerAddress1)
  {
    this.ownerAddress1 = ownerAddress1;
  }
  
  public String getOwnerAddress2()
  {
    return this.ownerAddress2;
  }
  
  public void setOwnerAddress2(String ownerAddress2)
  {
    this.ownerAddress2 = ownerAddress2;
  }
  
  public String getOwnerAddress3()
  {
    return this.ownerAddress3;
  }
  
  public void setOwnerAddress3(String ownerAddress3)
  {
    this.ownerAddress3 = ownerAddress3;
  }
  
  public String getOwnerCity()
  {
    return this.ownerCity;
  }
  
  public void setOwnerCity(String ownerCity)
  {
    this.ownerCity = ownerCity;
  }
  
  public int getOwnerPinCode()
  {
    return this.ownerPinCode;
  }
  
  public void setOwnerPinCode(int ownerPinCode)
  {
    this.ownerPinCode = ownerPinCode;
  }
  
  public String getOwnerState()
  {
    return this.ownerState;
  }
  
  public void setOwnerState(String ownerState)
  {
    this.ownerState = ownerState;
  }
  
  public String getOwnerLicense()
  {
    return this.ownerLicense;
  }
  
  public void setOwnerLicense(String ownerLicense)
  {
    this.ownerLicense = ownerLicense;
  }
  
  public String getOwnerContact1()
  {
    return this.ownerContact1;
  }
  
  public void setOwnerContact1(String ownerContact1)
  {
    this.ownerContact1 = ownerContact1;
  }
  
  public String getOwnerContact2()
  {
    return this.ownerContact2;
  }
  
  public void setOwnerContact2(String ownerContact2)
  {
    this.ownerContact2 = ownerContact2;
  }
  
  public String getOwnerContact3()
  {
    return this.ownerContact3;
  }
  
  public void setOwnerContact3(String ownerContact3)
  {
    this.ownerContact3 = ownerContact3;
  }
  
  public String getOwnerEmail()
  {
    return this.ownerEmail;
  }
  
  public void setOwnerEmail(String ownerEmail)
  {
    this.ownerEmail = ownerEmail;
  }
  
  public String getSosAlertStatus()
  {
    return this.sosAlertStatus;
  }
  
  public void setSosAlertStatus(String sosAlertStatus)
  {
    this.sosAlertStatus = sosAlertStatus;
  }
  
  public String getGroupName()
  {
    return this.groupName;
  }
  
  public void setGroupName(String groupName)
  {
    this.groupName = groupName;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getCreatedBy()
  {
    return this.createdBy;
  }
  
  public void setCreatedBy(String createdBy)
  {
    this.createdBy = createdBy;
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

public String getInsuranceDateShow() {
	if(this.insuranceDate!=null)
		return Constant.dateFormater.format(this.insuranceDate);
		else
		return "";
	
}

public void setInsuranceDateShow(String insuranceDateShow) {
	if(StringUtils.isEmpty(insuranceDateShow))
	this.insuranceDate = null;
	else
		try {
			this.insuranceDate=Constant.dateFormater.parse(insuranceDateShow);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	this.insuranceDateShow=insuranceDateShow;
		
}

public String getInsuranceExpiryDateShow() {
	
	if(this.insuranceExpiryDate!=null)
		return Constant.dateFormater.format(this.insuranceExpiryDate);
		else
		return "";
	
}


public void setInsuranceExpiryDateShow(String insuranceExpiryDateShow) {
	
	if(StringUtils.isEmpty(insuranceExpiryDateShow))
	this.insuranceExpiryDate = null;
	else
		try {
			this.insuranceExpiryDate=Constant.dateFormater.parse(insuranceExpiryDateShow);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	this.insuranceExpiryDateShow = insuranceExpiryDateShow;
}

public String getNationalPermitExpiryDateShow() {
	
	if(this.nationalPermitExpiryDate!=null)
		return Constant.dateFormater.format(this.nationalPermitExpiryDate);
		else
		return "";
	
}

public void setNationalPermitExpiryDateShow(String nationalPermitExpiryDateShow) {
	
	if(StringUtils.isEmpty(nationalPermitExpiryDateShow))
	this.nationalPermitExpiryDate = null;
	else
		try {
			this.nationalPermitExpiryDate=Constant.dateFormater.parse(nationalPermitExpiryDateShow);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	this.nationalPermitExpiryDateShow = nationalPermitExpiryDateShow;
}

public String getOtherPermitExpiryDateShow() {
	
	if(this.otherPermitExpiryDate!=null)
		return Constant.dateFormater.format(this.otherPermitExpiryDate);
		else
		return "";
	
}

public void setOtherPermitExpiryDateShow(String otherPermitExpiryDateShow) {
	if(StringUtils.isEmpty(otherPermitExpiryDateShow))
	this.otherPermitExpiryDate = null;
	else
		try {
			this.otherPermitExpiryDate=Constant.dateFormater.parse(otherPermitExpiryDateShow);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	this.otherPermitExpiryDateShow = otherPermitExpiryDateShow;
}

public String getServiceDateShow() {
	if(this.serviceDate!=null)
		return Constant.dateFormater.format(this.serviceDate);
		else
		return "";

}

public void setServiceDateShow(String serviceDateShow) {
	
	if(StringUtils.isEmpty(serviceDateShow))
	this.serviceDate = null;
	else
		try {
			this.serviceDate=Constant.dateFormater.parse(serviceDateShow);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	this.serviceDateShow = serviceDateShow;
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

public CompanyMaster getCompanyMaster() {
	return companyMaster;
}

public void setCompanyMaster(CompanyMaster companyMaster) {
	this.companyMaster = companyMaster;
}



}
