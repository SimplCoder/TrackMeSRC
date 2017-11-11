package com.trackme.spring.dao;

import java.util.List;

import com.trackme.spring.model.LinkConf;

public interface LinkConfDAO {

	public void addLinkConf(LinkConf linkConf);
	public void updateLinkConf(LinkConf linkConf);
	public List<LinkConf> listLinkConf();
	public LinkConf getLinkConfById(String id);
	public void removeLinkConf(String id);
}
