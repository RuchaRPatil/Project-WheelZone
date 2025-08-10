package com.wheelzone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wheelzone.model.Company;
import com.wheelzone.service.CompanyService;

@RestController
@RequestMapping(value = "/api")
public class CompanyController {

	@Autowired
	private CompanyService companyService; 
	
	//Post: http://localhost:9090/api/companies
	@PostMapping(value = "/companies")
	public ResponseEntity<Company> addCompany(@RequestBody Company company)
	{
		Company save =companyService.addCompany(company);
		return new ResponseEntity<Company>(save, HttpStatus.CREATED);
	}
	
	
	//Put: http://localhost:9090/api/companies/{id}
	@PutMapping(value = "/companies/{id}")
	public ResponseEntity<Company> updateCompanyRecorde(@PathVariable Integer id, @RequestBody Company updateCompany)
	{
		Company upadtecompany=companyService.updateCompany(id,updateCompany);
		return new ResponseEntity<Company>(upadtecompany, HttpStatus.OK);
	}
	
	//Delete: http://localhost:9090/api/companies/{id}
	//
	@DeleteMapping(value = "/companies/{id}")
	public String deleteCompanyRecorde(@PathVariable Integer id)
	{
	
		String message=companyService.deleteCompanyRecorde(id);
		return message;
	}
}
