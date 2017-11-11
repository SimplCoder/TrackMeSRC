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
@Table(name="driverconf")
public class DriverConf
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	  private Integer id;
	

@OneToOne
	@JoinColumn(name="driverid")
  private DriverMaster driverId;
  
	@Column(name="vehicleNo")
	private String vehicleNo;
  
	@Column(name="groupName")
	private String groupName;
 
	@Column(name="starttime")
	private String startTime;

	@Column(name="endtime")
	private String endTime;
	
	@Column(name="startdate")
	private String startDate;
	
	@Column(name="enddate")
	private String endDate;

	@Column(name="tripid")
	private String tripId ;

	@Column(name="shiftname")
	private String shiftName;

	
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

	public DriverMaster getDriverId() {
		return driverId;
	}

	public void setDriverId(DriverMaster driverId) {
		this.driverId = driverId;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	

	
	public String getTripId() {
		return tripId;
	}

	public void setTripId(String tripId) {
		this.tripId = tripId;
	}

	public String getShiftName() {
		return shiftName;
	}

	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
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
