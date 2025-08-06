package com.wheelzone.service;

import java.util.List;

import com.wheelzone.model.Company;

public interface CompanyService {

	Company addCompany(Company company);

	Company getCompany(int id);

	List<Company> getCompanys();

	

}
