package com.trackme.spring.service;

import java.util.List;

import com.trackme.spring.model.LinkConf;

public interface LinkConfService {

	public void addLinkConf(LinkConf p);
	public void updateLinkConf(LinkConf p);
	public List<LinkConf> listLinkConfs();
	public LinkConf getLinkConfById(String id);
	public void removeLinkConf(String id);
	
}
