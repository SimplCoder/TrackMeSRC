package com.trackme.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trackme.constants.Constant;
import com.trackme.spring.dao.RoleMasterDAO;
import com.trackme.spring.dao.UserMasterDAO;
import com.trackme.spring.model.LinkConf;
import com.trackme.spring.model.RoleMaster;
import com.trackme.spring.model.UserMaster;

@Service("roleMasterService")

public class RoleMasterServiceImpl implements RoleMasterService {
	
	@Autowired
	private RoleMasterDAO roleMasterDAO;

	@Autowired
	private LinkConfService linkConfService;
	

	public RoleMasterDAO getRoleMasterDAO() {
		return roleMasterDAO;
	}

	public void setRoleMasterDAO(RoleMasterDAO roleMasterDAO) {
		this.roleMasterDAO = roleMasterDAO;
	}


	@Override
	@Transactional
	public void addRoleMaster(RoleMaster p) {
		attachLinksToRole(p);
		roleMasterDAO.addRoleMaster(p);
	}

	@Override
	@Transactional
	public void updateRoleMaster(RoleMaster p) {
		attachLinksToRole(p);
		roleMasterDAO.updateRoleMaster(p);
	}

	@Override
	@Transactional
	public List<RoleMaster> listRoleMasters() {
		return roleMasterDAO.listRoleMaster();
	}

	@Override
	@Transactional
	public RoleMaster getRoleMasterById(String id) {
		
		return roleMasterDAO.getRoleMasterById(id);
	}

	@Override
	@Transactional
	public void removeRoleMaster(String id) {
		RoleMaster roleMaster= roleMasterDAO.getRoleMasterById(id);
		roleMaster.setStatus(Constant.STATUS_INACTIVE);
		roleMasterDAO.updateRoleMaster(roleMaster);
		
	}

	@Override
	public void removeExistingLink(RoleMaster roleMaster) {	
	roleMasterDAO.deleteRoleLink(roleMaster.getId().toString());		
	}
	
	void attachLinksToRole(RoleMaster roleMaster ){
		List<LinkConf> links= new ArrayList<>();
		if(roleMaster.getLinksId()!=null){
		for(Integer linkConfId: roleMaster.getLinksId()){
			if(linkConfId!=null )
			links.add(linkConfService.getLinkConfById(linkConfId.toString()));;
		}
		roleMaster.setLinks(links);
		
		}
		
	}

}
