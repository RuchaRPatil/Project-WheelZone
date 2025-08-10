package com.wheelzone.service;

import com.wheelzone.model.Company;

public interface CompanyService {

	Company addCompany(Company company);

	Company updateCompany(Integer id, Company updateCompany);

	String deleteCompanyRecorde(Integer id);

	

}
