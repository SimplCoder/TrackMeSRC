package com.trackme.spring.model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import javax.persistence.JoinColumn;
import org.springframework.util.StringUtils;

import com.trackme.constants.Constant;

@Entity
@Table(name="rolemaster")
public class RoleMaster
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	  private Integer id;
	
  @Column(name="role")
  private String role;
  
  
  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "rolelink", joinColumns = {
			@JoinColumn(name = "roleid", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "linkid",
					nullable = false, updatable = false) })	
  private List<LinkConf> links;
   
  @Transient
  private List<Integer> linksId;
  
  @Column(name="modifieddate")
  private Date modifiedDate;
  
  @Column(name="modifiedby")
  private String modifiedBy;
 
  
  @Column(name="createddate")
  private Date createdDate;
  
  @Column(name="createdby")
  private String createdBy;
  
  
  
  public Integer getId()
  {
    return this.id;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  
  
  public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public List<LinkConf> getLinks() {
	return links;
}

public void setLinks(List<LinkConf> links) {
	this.links = links;
}



public List<Integer> getLinksId() {
	if(this.linksId==null && this.links!=null){
		this.linksId= new ArrayList<>();
		for(LinkConf linkConf : this.links)
		this.linksId.add(linkConf.getId());
	}
	
	return linksId;
}

public void setLinksId(List<Integer> linksId) {
	this.linksId = linksId;
}

public Date getModifiedDate()
  {
    return this.modifiedDate;
  }
  
  public void setModifiedDate(Date modifiedDate)
  {
    this.modifiedDate = modifiedDate;
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

		public String getModifiedBy() {
			return modifiedBy;
		}

		public void setModifiedBy(String modifiedBy) {
			this.modifiedBy = modifiedBy;
		}

	
}
