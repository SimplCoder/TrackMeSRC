package com.trackme.spring.dao;

import java.util.List;

import com.trackme.spring.model.CompanyMaster;

public interface CompanyMasterDAO {

	public void addCompanyMaster(CompanyMaster companyMaster);
	public void updateCompanyMaster(CompanyMaster companyMaster);
	public List<CompanyMaster> listCompanyMaster();
	public CompanyMaster getCompanyMasterByCompanyId(String companyId);
	public void removeCompanyMaster(String companyId);
}
