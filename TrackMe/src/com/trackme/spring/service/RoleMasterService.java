package com.trackme.spring.service;

import java.util.List;

import com.trackme.spring.model.RoleMaster;

public interface RoleMasterService {

	public void addRoleMaster(RoleMaster p);
	public void updateRoleMaster(RoleMaster p);
	public List<RoleMaster> listRoleMasters();
	public RoleMaster getRoleMasterById(String id);
	public void removeRoleMaster(String id); 
	public void removeExistingLink(RoleMaster roleMaster);
	
}
