package com.wheelzone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	

	//Post: http://localhost:9090/api/companies

	// URL : http://localhost:9090/api/companies
	

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
	
	@GetMapping(value = "/companies-by-page")
	public List<Company> getCompanys(
	        @RequestParam(defaultValue = "0") Integer page,
	        @RequestParam(defaultValue = "5") Integer size) 
	{
		 List<Company> companies = companyService.getCompanys(page, size);


	    return companies;
	}
	
	//url: http://localhost:9090/api/companies-add-car
	@PostMapping(value = "/companies-add-car")
	public String addCarToCompany(@RequestParam Integer companyId, @RequestParam Integer carId) 
	{
		String message = companyService.addCompanyToCar(companyId,carId );
		
		return message;
	}
	
	
	
	


}
