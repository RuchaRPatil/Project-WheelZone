package com.wheelzone.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wheelzone.model.Company;
import com.wheelzone.repository.CarRepository;
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
	
	@Override
	public Company getCompany(int id) {
		
		Optional<Company> optional = companyRepository.findById(id);
		
		if(optional.isPresent())
		{
			Company company = optional.get();
			
			return company;
		}
		
		return null;
	}
	
	@Override
	public Page<Company> getCompanys(Pageable pageable) {
	    return companyRepository.findAll(pageable);
	}


	@Override
	public Company updateCompany(Integer id, Company updateCompany) {
		if(companyRepository.existsById(id))
		{
			Company company = companyRepository.findById(id).get();
			
			company.setCompanyName(updateCompany.getCompanyName());
			
			Company updatecompany = companyRepository.save(company);
			return updatecompany;
		}
		return null;
	}

	@Override
	public String deleteCompanyRecorde(Integer id) {
		if(companyRepository.existsById(id))
		{
			companyRepository.deleteById(id);
			return "Company Deleted SuccessFully for Given Id : " + id;

		}
		return "Company Not Avaiable For given Id : " + id;

	}

}
