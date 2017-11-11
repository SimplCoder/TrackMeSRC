package com.trackme.spring.model;

import java.text.ParseException;
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
@Table(name="vehicleservice")
public class VehicleService
{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="serviceId")
  private int serviceId;
@Column(name="vehicleNo")
  private String vehicleNo;

@OneToOne
@JoinColumn(name="driverid")
  private DriverMaster driverMaster;

@Column(name="serviceDate")
  private Date serviceDate;
@Column(name="fromTime")
  private String fromTime;
@Column(name="toTime")
  private String toTime;
@Column(name="serviceLocation")
  private String serviceLocation;
@Column(name="serviceStation")
  private String serviceStation;
@Column(name="serviceDesc")
  private String serviceDesc;
@Column(name="componentDesc")
  private String componentDesc;
@Column(name="billNo")
  private String billNo;
@Column(name="amount")
  private int amount;
@Column(name="currentOdo")
  private int currentOdo;
@Column(name="nextOdo")
  private int nextOdo;

@Column(name="createdby")
private String createdBy;

@Column(name="createddate")
private Date createdDate;

@Column(name="modifiedby")
private String modifiedBy;

@Column(name="modifieddate")
private Date modifiedDate;

  
  public int getServiceId()
  {
    return this.serviceId;
  }
  
  public void setServiceId(int serviceId)
  {
    this.serviceId = serviceId;
  }
  
  public String getVehicleNo()
  {
    return this.vehicleNo;
  }
  
  public void setVehicleNo(String vehicleNo)
  {
    this.vehicleNo = vehicleNo;
  }
  
  
  public DriverMaster getDriverMaster() {
	return driverMaster;
}

public void setDriverMaster(DriverMaster driverMaster) {
	this.driverMaster = driverMaster;
}

public Date getServiceDate()
  {
    return this.serviceDate;
  }
  
  public void setServiceDate(Date serviceDate)
  {
    this.serviceDate = serviceDate;
  }
  
  public String getFromTime()
  {
    return this.fromTime;
  }
  
  public void setFromTime(String fromTime)
  {
    this.fromTime = fromTime;
  }
  
  public String getToTime()
  {
    return this.toTime;
  }
  
  public void setToTime(String toTime)
  {
    this.toTime = toTime;
  }
  
  public String getLocation()
  {
    return this.serviceLocation;
  }
  
  public void setLocation(String serviceLocation)
  {
    this.serviceLocation = serviceLocation;
  }
  
  public String getServiceStation()
  {
    return this.serviceStation;
  }
  
  public void setServiceStation(String serviceStation)
  {
    this.serviceStation = serviceStation;
  }
  
  public String getServiceDesc()
  {
    return this.serviceDesc;
  }
  
  public void setServiceDesc(String serviceDesc)
  {
    this.serviceDesc = serviceDesc;
  }
  
  public String getComponentDesc()
  {
    return this.componentDesc;
  }
  
  public void setComponentDesc(String componentDesc)
  {
    this.componentDesc = componentDesc;
  }
  
  public String getBillNo()
  {
    return this.billNo;
  }
  
  public void setBillNo(String billNo)
  {
    this.billNo = billNo;
  }
  
  public int getAmount()
  {
    return this.amount;
  }
  
  public void setAmount(int amount)
  {
    this.amount = amount;
  }
  
  public int getCurrentOdo()
  {
    return this.currentOdo;
  }
  
  public void setCurrentOdo(int currentOdo)
  {
    this.currentOdo = currentOdo;
  }
  
  public int getNextOdo()
  {
    return this.nextOdo;
  }
  
  public void setNextOdo(int nextOdo)
  {
    this.nextOdo = nextOdo;
  }
  
  
  

public String getServiceLocation() {
	return serviceLocation;
}

public void setServiceLocation(String serviceLocation) {
	this.serviceLocation = serviceLocation;
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

@Transient
String serviceDateShow;


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

  
}
