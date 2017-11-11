package com.trackme.spring.model;

import java.text.ParseException;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.trackme.constants.Constant;

@Entity
@Table(name="LocationsForRoute")
public class LocationsForRoute
{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="id")
  private Integer id;
@ManyToOne 
@JoinColumn(name="locationId")
  private Location location;
@ManyToOne 
@JsonManagedReference
@JoinColumn(name="route")
  private Route route;

@Column(name="sequence")
private Integer sequence;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public Location getLocation() {
	return location;
}

public void setLocation(Location location) {
	this.location = location;
}

public Route getRoute() {
	return route;
}

public void setRoute(Route route) {
	this.route = route;
}

public Integer getSequence() {
	return sequence;
}

public void setSequence(Integer sequence) {
	this.sequence = sequence;
}



}
