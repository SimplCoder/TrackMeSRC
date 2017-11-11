package com.trackme.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trackme.constants.Constant;
import com.trackme.spring.dao.UserMasterDAO;
import com.trackme.spring.model.LinkConf;
import com.trackme.spring.model.UserMaster;

@Service("UserMasterService")
public class UserMasterServiceImpl implements UserMasterService {

	@Autowired
	private UserMasterDAO UserMasterDAO;

	public void setUserMasterDAO(UserMasterDAO UserMasterDAO) {
		this.UserMasterDAO = UserMasterDAO;
	}

	@Override
	@Transactional
	public void addUserMaster(UserMaster p) {
		this.UserMasterDAO.addUserMaster(p);
	}

	@Override
	@Transactional
	public void updateUserMaster(UserMaster p) {
		this.UserMasterDAO.updateUserMaster(p);
	}

	@Override
	@Transactional
	public List<UserMaster> listUserMasters() {
		return this.UserMasterDAO.listUserMasters();
	}

	@Override
	@Transactional
	public UserMaster getUserMasterById(String userName) {
		return this.UserMasterDAO.getUserMasterById(userName);
	}

	@Override
	@Transactional
	public void removeUserMaster(String userName) {
		UserMaster userMaster = UserMasterDAO.getUserMasterById(userName);
		userMaster.setStatus(Constant.STATUS_INACTIVE);
		this.UserMasterDAO.updateUserMaster(userMaster);
	}

	public static boolean checkForModule(UserMaster userMaster, String module) {

		if (userMaster != null && userMaster.getRoleMaster() != null
				&& userMaster.getRoleMaster().getLinks() != null) {

			for (LinkConf linkConf : userMaster.getRoleMaster().getLinks()) {

				if (module.equalsIgnoreCase(linkConf.getModule())) {
					return true;
				}
			}
			return false;
		}
		return true;
	}

	public static boolean checkForLink(UserMaster userMaster, String link) {

		if (userMaster != null && userMaster.getRoleMaster() != null
				&& userMaster.getRoleMaster().getLinks() != null) {

			for (LinkConf linkConf : userMaster.getRoleMaster().getLinks()) {

				if (link.equalsIgnoreCase(linkConf.getName())) {
					return true;
				}
			}
			return false;
		}
		return true;
	}

	@Override
	@Transactional
	public String updateNoticationId(String userName, String notificationId) {
		// TODO Auto-generated method stub
		UserMaster um = getUserMasterById(userName);
		if (um != null) {
			um.setNotificationId(notificationId);
			updateUserMaster(um);
			return um.getRoleMaster().getRole();
		}
		return "failed";
	}

	@Override
	@Transactional
	public UserMaster getCurrentUserUsingPrinciple(HttpServletRequest request) {
		return getUserMasterById(request.getUserPrincipal().getName());
	}

}
