package com.trackme.spring.model;

import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.util.StringUtils;

import com.trackme.constants.Constant;

@Entity
@Table(name="usermaster")
public class UserMaster
{
@Id
@Column(name="username")
  private String userName;

@Column(name="password")
  private String password;

@Column(name="level")
  private String level;

@Column(name="mapview")
  private String mapView;

@OneToOne
@JoinColumn(name="company")
CompanyMaster companyMaster;


@OneToOne
@JoinColumn(name="vehiclegroup")
VehicleGroup vehicleGroup;

@OneToOne
@JoinColumn(name="roleid")
RoleMaster roleMaster;

@Column(name="notificationid")
String notificationId;


@Column(name="createdby")
  private String createdBy;

@Column(name="createddate")
  private Date createdDate;

@Column(name="modifiedBy")
  private String modifiedBy;

@Column(name="modifiedDate")
  private Date modifiedDate;

@Transient
private String  createdDateShow;
@Transient
private String  modifiedDateShow;

  public String getUserName()
  {
    return this.userName;
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String password)
  {
    this.password = password;
  }
  
  public String getLevel()
  {
    return this.level;
  }
  
  public void setLevel(String level)
  {
    this.level = level;
  }
  
  
  
 
public String getMapView()
  {
    return this.mapView;
  }
  
  public void setMapView(String mapView)
  {
    this.mapView = mapView;
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

public String getCreatedDateShow() {
	if(this.createdDate!=null){
		return Constant.dateFormater.format(this.createdDate);
	}
		else{
		return "";
		}
	//return createdDateShow;
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
	//return modifiedDateShow;
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

public CompanyMaster getCompanyMaster() {
	return companyMaster;
}

public void setCompanyMaster(CompanyMaster companyMaster) {
	this.companyMaster = companyMaster;
}

public RoleMaster getRoleMaster() {
	return roleMaster;
}

public void setRoleMaster(RoleMaster roleMaster) {
	this.roleMaster = roleMaster;
}

public VehicleGroup getVehicleGroup() {
	return vehicleGroup;
}

public void setVehicleGroup(VehicleGroup vehicleGroup) {
	this.vehicleGroup = vehicleGroup;
}

public String getNotificationId() {
	return notificationId;
}

public void setNotificationId(String notificationId) {
	this.notificationId = notificationId;
}





}
