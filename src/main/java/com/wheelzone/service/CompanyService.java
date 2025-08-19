package com.wheelzone.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wheelzone.model.Company;

public interface CompanyService {

	Company addCompany(Company company);


	Company updateCompany(Integer id, Company updateCompany);

	String deleteCompanyRecorde(Integer id);


	Company getCompany(int id);

	


	List<Company> getCompanys(Integer page, Integer size);


	String addCompanyToCar(Integer companyId, Integer carId);

	
	

	

}
