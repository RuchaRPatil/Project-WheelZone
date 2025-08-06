package com.wheelzone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wheelzone.model.Company;
import com.wheelzone.service.CompanyService;

@RestController
@RequestMapping(value = "/api")
public class CompanyController {

	@Autowired
	private CompanyService companyService; 
	
	// http://localhost:9090/api/companies
	@PostMapping(value = "/companies")
	public ResponseEntity<Company> addCompany(@RequestBody Company company)
	{
		Company save =companyService.addCompany(company);
		return new ResponseEntity<Company>(save, HttpStatus.CREATED);
	}
}
