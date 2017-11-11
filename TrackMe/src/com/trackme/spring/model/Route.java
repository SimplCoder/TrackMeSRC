package com.trackme.spring.model;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.trackme.constants.Constant;

@Entity
@Table(name="route")
public class Route
{
  @Id
  @Column(name="routename")	
  private String routeName;
  
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="route",orphanRemoval = true)	
  @JsonBackReference
  private List<LocationsForRoute> locationsForRoute;
  
  @Column(name="createdby")	
  private String createdBy;
  
  //
  //@Column(name="username") 
  @ManyToOne 
  @JoinColumn(name="userName")
  private UserMaster username;
  
  @Column(name="createddate")	
  private Date createdDate;
  
  @Column(name="modifiedby")	
  private String modifiedBy;
  
  @Column(name="modifieddate")	
  private Date modifiedDate;
  
  @Transient
  private int locationCount;
  
  @Transient
  private String[] locations;

  
  public String[] getLocations() {
	return locations;
}

public void setLocations(String[] locations) {
	this.locations = locations;
}

@Transient
  private String  createdDateShow;
  @Transient
  private String  modifiedDateShow;

  public int getLocationCount() {
	//String[] location=  this.locations.split(",");
	return locationsForRoute.size();
  }

public String getRouteName() {
	return routeName;
}

public void setRouteName(String routeName) {
	this.routeName = routeName;
}





public List<LocationsForRoute> getLocationsForRoute() {
	return locationsForRoute;
}

public void setLocationsForRoute(List<LocationsForRoute> locationsForRoute) {
	this.locationsForRoute = locationsForRoute;
}

public void setLocationCount(int locationCount) {
	this.locationCount = locationCount;
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

public UserMaster getUsername() {
	return username;
}

public void setUsername(UserMaster username) {
	this.username = username;
}
  
public String getCreatedDateShow() {
	if(this.createdDate!=null){
		return Constant.dateFormater.format(this.createdDate);
	}
		else{
		return "";
		}
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
