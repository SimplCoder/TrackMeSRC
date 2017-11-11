package com.trackme.spring.model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.util.StringUtils;

import com.trackme.constants.Constant;

@Entity
@Table(name="vehiclegroup")
public class VehicleGroup
{  
  @Id	
  @Column(name="id") 	
  private String id;
  @Column(name="createdby") 
  private String createdBy;
  @Column(name="createddate") 
  private Date createdDate;
  
  
  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
 	@JoinTable(name = "groupvehicles", joinColumns = {
 			@JoinColumn(name = "groupid ", nullable = false, updatable = false) },
 			inverseJoinColumns = { @JoinColumn(name = "vehicleno",
 					nullable = false, updatable = false) })	
   private List<VehicleMaster> vehicleMasters;
 
  @Transient
  private List<String> vehicleNos;
  
  
  public String getId()
  {
    return this.id;
  }
  
  public void setId(String id)
  {
    this.id = id;
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
  
  @Column(name="modifieddate")
  private Date modifiedDate;
  
  @Column(name="modifiedby")
  private String modifiedBy;
 
  

  public String getStatus() {
  	return status;
  }

  public void setStatus(String status) {
  	this.status = status;
  }

public List<VehicleMaster> getVehicleMasters() {
	return vehicleMasters;
}

public void setVehicleMasters(List<VehicleMaster> vehicleMasters) {
	this.vehicleMasters = vehicleMasters;
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
  
  

	public Date getModifiedDate() {
	return modifiedDate;
}

public void setModifiedDate(Date modifiedDate) {
	this.modifiedDate = modifiedDate;
}

public String getModifiedBy() {
	return modifiedBy;
}

public void setModifiedBy(String modifiedBy) {
	this.modifiedBy = modifiedBy;
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

	public List<String> getVehicleNos() {
		if(this.vehicleNos==null && this.vehicleMasters!=null){
			this.vehicleNos= new ArrayList<>();
			for(VehicleMaster vehicleMaster : this.vehicleMasters)
			this.vehicleNos.add(vehicleMaster.getVehicleNo());
		}
		
		return vehicleNos;
	}

	public void setVehicleNos(List<String> vehicleNos) {
		this.vehicleNos = vehicleNos;
	}

  
}
