package com.trackme.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trackme.constants.Constant;
import com.trackme.spring.dao.LinkConfDAO;
import com.trackme.spring.dao.UserMasterDAO;
import com.trackme.spring.model.LinkConf;
import com.trackme.spring.model.UserMaster;

@Service("linkConfService")

public class LinkConfServiceImpl implements LinkConfService {
	
	@Autowired
	private LinkConfDAO linkConfDAO;

	

	public LinkConfDAO getLinkConfDAO() {
		return linkConfDAO;
	}

	public void setLinkConfDAO(LinkConfDAO linkConfDAO) {
		this.linkConfDAO = linkConfDAO;
	}


	@Override
	@Transactional
	public void addLinkConf(LinkConf p) {
		linkConfDAO.addLinkConf(p);
	}

	@Override
	@Transactional
	public void updateLinkConf(LinkConf p) {
		linkConfDAO.updateLinkConf(p);
	}

	@Override
	@Transactional
	public List<LinkConf> listLinkConfs() {
		return linkConfDAO.listLinkConf();
	}

	@Override
	@Transactional
	public LinkConf getLinkConfById(String id) {
		
		return linkConfDAO.getLinkConfById(id);
	}

	@Override
	@Transactional
	public void removeLinkConf(String id) {
		LinkConf linkConf= linkConfDAO.getLinkConfById(id);
		linkConf.setStatus(Constant.STATUS_INACTIVE);
		linkConfDAO.updateLinkConf(linkConf);
		
	}

}
