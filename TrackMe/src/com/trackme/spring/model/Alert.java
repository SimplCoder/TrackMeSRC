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
@Table(name="alert")
public class Alert
{
 @Id
 @Column(name="vehicleno")
  private String vehicleNo;
 
 @Column(name="overspeed")
  private boolean overSpeed;
 
 @Column(name="suddenbreak")
  private boolean suddenBreak;
 
 @Column(name="idletime")
  private boolean idleTime; 
 
 @Column(name="panic")
  private boolean panic;
 
 @Column(name="geofency")
  private boolean geofency;
 
 @Column(name="alertbySms")
  private boolean alertBySms;
 
 @Column(name="alertbyMail")
  private boolean alertByMail;
 
 @Column(name="snoozetime")
  private String snoozeTime;
 
 @Column(name="createdby")
  private String createdBy;
 
 @Column(name="createddate")
  private Date createdDate;
 
 @Column(name="modifiedby")
  private String modifiedBy;
 
 @Column(name="modifieddate")
  private Date modifiedDate;
 
 @Column(name="isgroup")
  private boolean group;
  
  @Column(name="contactno")
  private String contactNo;
  
  public boolean isGroup()
  {
    return this.group;
  }
  
  public void setGroup(boolean group)
  {
    this.group = group;
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
  
  public String getVehicleNo()
  {
    return this.vehicleNo;
  }
  
  public void setVehicleNo(String vehicleNo)
  {
    this.vehicleNo = vehicleNo;
  }
  
  public boolean isOverSpeed()
  {
    return this.overSpeed;
  }
  
  public void setOverSpeed(boolean overSpeed)
  {
    this.overSpeed = overSpeed;
  }
  
  public boolean isSuddenBreak()
  {
    return this.suddenBreak;
  }
  
  public void setSuddenBreak(boolean suddenBreak)
  {
    this.suddenBreak = suddenBreak;
  }
  
  public boolean isIdleTime()
  {
    return this.idleTime;
  }
  
  public void setIdleTime(boolean idleTime)
  {
    this.idleTime = idleTime;
  }
  
  public boolean isPanic()
  {
    return this.panic;
  }
  
  public void setPanic(boolean panic)
  {
    this.panic = panic;
  }
  
  public boolean isGeofency()
  {
    return this.geofency;
  }
  
  public void setGeofency(boolean geofency)
  {
    this.geofency = geofency;
  }
  
  public boolean isAlertBySms()
  {
    return this.alertBySms;
  }
  
  public void setAlertBySms(boolean alertBySms)
  {
    this.alertBySms = alertBySms;
  }
  
  public boolean isAlertByMail()
  {
    return this.alertByMail;
  }
  
  public void setAlertByMail(boolean alertByMail)
  {
    this.alertByMail = alertByMail;
  }
  
  public String getSnoozeTime()
  {
    return this.fromSnooze +" to "+ this.toSnooze;
  }
  
  public void setSnoozeTime(String snoozeTime)
  {
    this.snoozeTime = snoozeTime;
  }
  
  public String getContactNo()
  {
    return this.contactNo;
  }
  
  public void setContactNo(String contactNo)
  {
    this.contactNo = contactNo;
  }
  
  @Transient
  private String  createdDateShow;
  @Transient
  private String  modifiedDateShow;
  
  public String getCreatedDateShow() {
		if(this.createdDate!=null){
			return Constant.dateFormater.format(this.createdDate);
		}
			else{
			return "";
			}
//		return createdDateShow;
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
//		return modifiedDateShow;
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
	
	@Column(name="fromsnooze")
	String fromSnooze;
	
	@Column(name="tosnooze")
	String toSnooze;

	public String getFromSnooze() {
		return fromSnooze;
	}

	public void setFromSnooze(String fromSnooze) {
		this.fromSnooze = fromSnooze;
	}

	public String getToSnooze() {
		return toSnooze;
	}

	public void setToSnooze(String toSnooze) {
		this.toSnooze = toSnooze;
	}
	
	
	
}
