package com.wheelzone.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wheelzone.model.Company;

public interface CompanyService {

	Company addCompany(Company company);

	Company getCompany(int id);

	Page<Company> getCompanys(Pageable pageable);

	
	

}
