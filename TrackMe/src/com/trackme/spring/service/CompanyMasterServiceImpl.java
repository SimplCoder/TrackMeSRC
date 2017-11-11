package com.trackme.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trackme.constants.Constant;
import com.trackme.spring.dao.CompanyMasterDAO;
import com.trackme.spring.dao.UserMasterDAO;
import com.trackme.spring.model.CompanyMaster;
import com.trackme.spring.model.UserMaster;

@Service("companyMasterService")

public class CompanyMasterServiceImpl implements CompanyMasterService {
	
	@Autowired
	private CompanyMasterDAO companyMasterDAO;

	

	public CompanyMasterDAO getCompanyMasterDAO() {
		return companyMasterDAO;
	}

	public void setCompanyMasterDAO(CompanyMasterDAO companyMasterDAO) {
		this.companyMasterDAO = companyMasterDAO;
	}


	@Override
	@Transactional
	public void addCompanyMaster(CompanyMaster p) {
		companyMasterDAO.addCompanyMaster(p);
	}

	@Override
	@Transactional
	public void updateCompanyMaster(CompanyMaster p) {
		companyMasterDAO.updateCompanyMaster(p);
	}

	@Override
	@Transactional
	public List<CompanyMaster> listCompanyMasters() {
		return companyMasterDAO.listCompanyMaster();
	}

	@Override
	@Transactional
	public CompanyMaster getCompanyMasterById(String companyId) {
		
		return companyMasterDAO.getCompanyMasterByCompanyId(companyId);
	}

	@Override
	@Transactional
	public void removeCompanyMaster(String companyId) {
		CompanyMaster companyMaster= companyMasterDAO.getCompanyMasterByCompanyId(companyId);
		companyMaster.setStatus(Constant.STATUS_INACTIVE);
		companyMasterDAO.updateCompanyMaster(companyMaster);
		
	}

}
