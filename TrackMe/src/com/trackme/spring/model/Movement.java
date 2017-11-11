package com.trackme.spring.model;

import java.text.ParseException;
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
@Table(name="movement")
public class Movement
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	  private Integer id;
	
  @Column(name="vehicle")
  private String vehicle;
  
  @Column(name="snoozetime")
  private String snoozetime;
  
  @Column(name="fromsnooze")
  private String fromSnooze;
  
  @Column(name="tosnooze")
  private String toSnooze;
  
 
  @Column(name="startdate")
  private Date startdate;
  
  @Column(name="enddate")
  private Date enddate;
  
  @Column(name="starttime")
  private String startTime;
  
  @Column(name="endtime")
  private String endTime;
  
  @Column(name="groups")
  private boolean groups;
  
  @Column(name="groupname")
  private String groupname;
  
  @Column(name="monday")
  private boolean monday;
  
  @Column(name="tuesday")
  private boolean tuesday;
  
  @Column(name="wednesday")
  private boolean wednesday;
  
  @Column(name="thursday")
  private boolean thursday;
  
  @Column(name="friday")
  private boolean friday;
  
  @Column(name="saturday")
  private boolean saturday;
  
  @Column(name="sunday")
  private boolean sunday;
  
  @Column(name="alertbysms")
  private boolean alertbysms;
  
  @Column(name="alertbymail")
  private boolean alertbymail;
  
  @Column(name="modifieddate")
  private Date modifiedDate;
  
  @Column(name="modifiedby")
  private String modifiedBy;
 
  
  @Column(name="createdon")
  private Date createdDate;
  
  @Column(name="createdby")
  private String createdBy;
  
  
  public String getVehicle()
  {
    return this.vehicle;
  }
  
  public void setVehicle(String vehicle)
  {
    this.vehicle = vehicle;
  }
  
  public String getSnoozetime()
  {
    return this.snoozetime;
  }
  
  public void setSnoozetime(String snoozetime)
  {
    this.snoozetime = snoozetime;
  }
  
  public Date getStartdate()
  {
    return this.startdate;
  }
  
  public void setStartdate(Date startdate)
  {
    this.startdate = startdate;
  }
  
  public Date getEnddate()
  {
    return this.enddate;
  }
  
  public void setEnddate(Date enddate)
  {
    this.enddate = enddate;
  }
  
  public String getStartTime()
  {
    return this.startTime;
  }
  
  public void setStartTime(String startTime)
  {
    this.startTime = startTime;
  }
  
  public String getEndTime()
  {
    return this.endTime;
  }
  
  public void setEndTime(String endTime)
  {
    this.endTime = endTime;
  }
  
  public boolean isGroups()
  {
    return this.groups;
  }
  
  public void setGroups(boolean group)
  {
    this.groups = group;
  }
  
  public boolean isMonday()
  {
    return this.monday;
  }
  
  public void setMonday(boolean monday)
  {
    this.monday = monday;
  }
  
  public boolean isTuesday()
  {
    return this.tuesday;
  }
  
  public void setTuesday(boolean tuesday)
  {
    this.tuesday = tuesday;
  }
  
  public boolean isWednesday()
  {
    return this.wednesday;
  }
  
  public void setWednesday(boolean wednesday)
  {
    this.wednesday = wednesday;
  }
  
  public boolean isThursday()
  {
    return this.thursday;
  }
  
  public void setThursday(boolean thursday)
  {
    this.thursday = thursday;
  }
  
  public boolean isFriday()
  {
    return this.friday;
  }
  
  public void setFriday(boolean friday)
  {
    this.friday = friday;
  }
  
  public boolean isSaturday()
  {
    return this.saturday;
  }
  
  public void setSaturday(boolean saturday)
  {
    this.saturday = saturday;
  }
  
  public boolean isSunday()
  {
    return this.sunday;
  }
  
  public void setSunday(boolean sunday)
  {
    this.sunday = sunday;
  }
  
  public boolean isAlertbysms()
  {
    return this.alertbysms;
  }
  
  public void setAlertbysms(boolean alertbysms)
  {
    this.alertbysms = alertbysms;
  }
  
  public boolean isAlertbymail()
  {
    return this.alertbymail;
  }
  
  public void setAlertbymail(boolean alertbymail)
  {
    this.alertbymail = alertbymail;
  }
  
  public String getGroupname()
  {
    return this.groupname;
  }
  
  public void setGroupname(String groupname)
  {
    this.groupname = groupname;
  }
  
  public Integer getId()
  {
    return this.id;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public Date getModifiedDate()
  {
    return this.modifiedDate;
  }
  
  public void setModifiedDate(Date modifiedDate)
  {
    this.modifiedDate = modifiedDate;
  }
 
  
  
  
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

public Date getCreatedDate() {
	return createdDate;
}

public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
}

public String getCreatedBy() {
	return createdBy;
}

public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
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

	@Transient
	  private String  startDateShow;
	  @Transient
	  private String  endDateShow;
	  
	  public String getStartDateShow() {
			if(this.startdate!=null){
				return Constant.dateFormater.format(this.startdate);
			}
				else{
				return "";
				}
//			return startdateShow;
		}

		public void setStartDateShow(String startdateShow) {
			if(StringUtils.isEmpty(startdateShow))
			this.startdate = null;
			else
				try {
					this.startdate=Constant.dateFormater.parse(startdateShow);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			this.startDateShow = startdateShow;
		}

		public String getEndDateShow() {
			if(this.enddate!=null){
				return Constant.dateFormater.format(this.enddate);
			}
				else{
				return "";
				}
//			return enddateShow;
		}

		public void setEndDateShow(String enddateShow) {
			if(StringUtils.isEmpty(enddateShow))
			this.enddate = null;
			else
				try {
					this.enddate=Constant.dateFormater.parse(enddateShow);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			this.endDateShow = enddateShow;
		}

		public String getModifiedBy() {
			return modifiedBy;
		}

		public void setModifiedBy(String modifiedBy) {
			this.modifiedBy = modifiedBy;
		}

	
}
