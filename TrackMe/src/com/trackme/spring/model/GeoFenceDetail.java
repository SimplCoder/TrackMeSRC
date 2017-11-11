package com.trackme.spring.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "geofencemaster")
public class GeoFenceDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "geoFenceName")
	private String geoFenceName;
	@Column(name = "latitude")
	private String latitude;
	@Column(name = "longitude")
	private String longitude;
	@Column(name = "radius")
	private float radius;
	@Column(name = "location")
	private String location;
	@Column(name = "createdBy")
	private String createdBy;
	@Column(name = "createdOn")
	private Date createdDate;
	@Column(name = "modifiedBy")
	private String modifiedBy;
	@Column(name = "modifiedOn")
	private Date modifiedDate;
	@Column(name = "status")
	private String status;
	@Transient
	private String geoFenceType;
	@Column(name = "userName")
	private String userName;
	
	@ElementCollection
	  @CollectionTable(
	        name="geofencevehicle",
	        joinColumns=@JoinColumn(name="geofenceid")
	  )
	  @Column(name="vehicleno")
	  private List<String> vehicles;

	 @Transient
	  private String[] vehicleShow;
	  
	 

	  public String getVehicleShow() {
		  
		  if (vehicleShow!=null && vehicleShow.length > 0) {
			    StringBuilder nameBuilder = new StringBuilder();

			    for (String n : vehicleShow) {
			        nameBuilder.append("'").append(n.replace("'", "\\'")).append("',");
			        // can also do the following
			        // nameBuilder.append("'").append(n.replace("'", "''")).append("',");
			    }

			    nameBuilder.deleteCharAt(nameBuilder.length() - 1);

			    return nameBuilder.toString();
			} else {
			    return "";
			}


	}

	public void setVehicleShow(String[] vehicleShow) {
		this.vehicleShow = vehicleShow;
		this.vehicles=new ArrayList<String>(Arrays.asList(vehicleShow));
		
	}

	
	public List<String> getVehicles() {
		return vehicles;
	}



	public void setVehicles(List<String> vehicles) {
		this.vehicles = vehicles;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGeoFenceType() {
		return geoFenceType;
	}

	public void setGeoFenceType(String geoFenceType) {
		this.geoFenceType = geoFenceType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGeoFenceName() {
		return geoFenceName;
	}

	public void setGeoFenceName(String geoFenceName) {
		this.geoFenceName = geoFenceName;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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
}
