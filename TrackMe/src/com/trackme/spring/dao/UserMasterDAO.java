package com.trackme.spring.dao;

import java.util.List;

import com.trackme.spring.model.UserMaster;

public interface UserMasterDAO {

	public void addUserMaster(UserMaster p);
	public void updateUserMaster(UserMaster p);
	public List<UserMaster> listUserMasters();
	public UserMaster getUserMasterById(String userName);
	public void removeUserMaster(String userName);
}
