package com.trackme.spring.dao;

import java.util.List;

import com.trackme.spring.model.RoleMaster;

public interface RoleMasterDAO {

	public void addRoleMaster(RoleMaster roleMaster);
	public void updateRoleMaster(RoleMaster roleMaster);
	public List<RoleMaster> listRoleMaster();
	public RoleMaster getRoleMasterById(String id);
	public void removeRoleMaster(String id);
	public void deleteRoleLink(String id );
}
