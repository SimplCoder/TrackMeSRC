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
@Table(name="company")
public class CompanyMaster
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	  private Integer id;

@Column(name="companyname")
  private String companyName;


@Column(name="logopath")
private String logoPath;



@Column(name="createdby")
  private String createdBy;

@Column(name="createdon")
  private Date createdDate;

@Column(name="modifiedBy")
  private String modifiedBy;

@Column(name="modifiedon")
  private Date modifiedDate;

@Transient
private String  createdDateShow;
@Transient
private String  modifiedDateShow;




  
  public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getCompanyName() {
	return companyName;
}

public void setCompanyName(String companyName) {
	this.companyName = companyName;
}

public String getLogoPath() {
	return logoPath;
}

public void setLogoPath(String logoPath) {
	this.logoPath = logoPath;
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
}
