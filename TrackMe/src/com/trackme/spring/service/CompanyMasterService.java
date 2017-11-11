package com.trackme.spring.service;

import java.util.List;

import com.trackme.spring.model.CompanyMaster;

public interface CompanyMasterService {

	public void addCompanyMaster(CompanyMaster p);
	public void updateCompanyMaster(CompanyMaster p);
	public List<CompanyMaster> listCompanyMasters();
	public CompanyMaster getCompanyMasterById(String companyId);
	public void removeCompanyMaster(String companyId);
	
}
