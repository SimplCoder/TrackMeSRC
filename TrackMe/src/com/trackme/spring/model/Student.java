package com.trackme.spring.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Basic;
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
@Table(name="student")
public class Student
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name="id" ,unique=true, nullable = false)
	  private Integer id;

	
@Column(name="studentid")
  private String studentNo;

@Column(name="studentname")
  private String studentName;

@Column(name="std")
  private String std;

@Column(name="division")
  private String division;

@Column(name="fathername")
  private String fatherName;

@Column(name="fathermobileno")
  private String fatherMobile;


@Column(name="mothername")
private String motherName;

@Column(name="mothermobileno")
private String motherMobile;

@Column(name="gaurdianname")
private String gaurdianName;

@Column(name="gaurdianmobileno")
private String gaurdianMobile;



@Column(name="schedulename")
private String routeScheduleId;

@Column(name="pickuplocation")
private String pickUpLocation;

@Column(name="droplocation")
private String dropLocation;

@Column(name="routename")
private String routeName;


@Column(name="dropschedulename")
private String dropRouteScheduleId;



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

public String getStudentNo() {
	return studentNo;
}

public void setStudentNo(String studentNo) {
	this.studentNo = studentNo;
}

public String getStudentName() {
	return studentName;
}

public void setStudentName(String studentName) {
	this.studentName = studentName;
}

public String getStd() {
	return std;
}

public void setStd(String std) {
	this.std = std;
}

public String getDivision() {
	return division;
}

public void setDivision(String division) {
	this.division = division;
}

public String getFatherName() {
	return fatherName;
}

public void setFatherName(String fatherName) {
	this.fatherName = fatherName;
}

public String getFatherMobile() {
	return fatherMobile;
}

public void setFatherMobile(String fatherMobile) {
	this.fatherMobile = fatherMobile;
}

public String getMotherName() {
	return motherName;
}

public void setMotherName(String motherName) {
	this.motherName = motherName;
}

public String getMotherMobile() {
	return motherMobile;
}

public void setMotherMobile(String motherMobile) {
	this.motherMobile = motherMobile;
}

public String getGaurdianName() {
	return gaurdianName;
}

public void setGaurdianName(String gaurdianName) {
	this.gaurdianName = gaurdianName;
}

public String getGaurdianMobile() {
	return gaurdianMobile;
}

public void setGaurdianMobile(String gaurdianMobile) {
	this.gaurdianMobile = gaurdianMobile;
}

public String getRouteScheduleId() {
	return routeScheduleId;
}

public void setRouteScheduleId(String routeScheduleId) {
	this.routeScheduleId = routeScheduleId;
}




public String getPickUpLocation() {
	return pickUpLocation;
}

public void setPickUpLocation(String pickUpLocation) {
	this.pickUpLocation = pickUpLocation;
}

public String getDropLocation() {
	return dropLocation;
}

public void setDropLocation(String dropLocation) {
	this.dropLocation = dropLocation;
}

public String getRouteName() {
	return routeName;
}

public void setRouteName(String routeName) {
	this.routeName = routeName;
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

public String getDropRouteScheduleId() {
	return dropRouteScheduleId;
}

public void setDropRouteScheduleId(String dropRouteScheduleId) {
	this.dropRouteScheduleId = dropRouteScheduleId;
}


}
