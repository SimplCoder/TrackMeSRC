package com.trackme.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.trackme.spring.model.UserMaster;

public interface UserMasterService {

	public void addUserMaster(UserMaster p);
	public void updateUserMaster(UserMaster p);
	public List<UserMaster> listUserMasters();
	public UserMaster getUserMasterById(String userName);
	public void removeUserMaster(String userName);
	public String updateNoticationId(String userName, String notificationId);
	public UserMaster getCurrentUserUsingPrinciple(HttpServletRequest request);
}
