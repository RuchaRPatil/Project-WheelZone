package com.wheelzone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wheelzone.model.Car;
import com.wheelzone.model.Company;
import com.wheelzone.service.CompanyService;

@RestController
@RequestMapping(value = "/api")
public class CompanyController {

	@Autowired
	private CompanyService companyService; 
	
	// URL : http://localhost:9090/api/companies
	
	@PostMapping(value = "/companies")
	public ResponseEntity<Company> addCompany(@RequestBody Company company)
	{
		Company save =companyService.addCompany(company);
		return new ResponseEntity<Company>(save, HttpStatus.CREATED);
	}
	
	// URL : http://localhost:9090/api/companies/{id}
	
	@GetMapping(value = "/companies/{id}")
	public ResponseEntity<Company> getCompany(@PathVariable int id)
	{
		Company company = companyService.getCompany(id);
		
		if(company != null)
		{
			return new ResponseEntity<Company>(company, HttpStatus.OK);
		}
		
		return new ResponseEntity<Company>(company, HttpStatus.NO_CONTENT);
	}
	
	// URL : http://localhost:9090/api/companies
	
	@GetMapping(value = "/companies")
	public ResponseEntity<Page<Company>> getCompanys(
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "5") int size) {

	    Pageable pageable = PageRequest.of(page, size);
	    Page<Company> companyPage = companyService.getCompanys(pageable);

	    return new ResponseEntity<>(companyPage, HttpStatus.OK);
	}

}
