package com.wheelzone.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wheelzone.model.Company;
import com.wheelzone.repository.CompanyRepository;
import com.wheelzone.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Company addCompany(Company company) {
		Company save = companyRepository.save(company);
		return save;
	}

}
