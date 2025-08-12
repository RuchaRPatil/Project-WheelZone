package com.wheelzone.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wheelzone.model.Car;
import com.wheelzone.model.Company;
import com.wheelzone.repository.CarRepository;
import com.wheelzone.repository.CompanyRepository;
import com.wheelzone.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private CarRepository carRepository;

	@Override
	public Company addCompany(Company company) {
		Company save = companyRepository.save(company);
		return save;
	}

	@Override
	public Company getCompany(int id) {

		Optional<Company> optional = companyRepository.findById(id);

		if (optional.isPresent()) {
			Company company = optional.get();

			return company;
		}

		return null;
	}

	@Override
	public Company updateCompany(Integer id, Company updateCompany) {
		if (companyRepository.existsById(id)) {
			Company company = companyRepository.findById(id).get();

			company.setCompanyName(updateCompany.getCompanyName());

			Company updatecompany = companyRepository.save(company);
			return updatecompany;
		}
		return null;
	}

	@Override
	public String deleteCompanyRecorde(Integer id) {
		if (companyRepository.existsById(id)) {
			companyRepository.deleteById(id);
			return "Company Deleted SuccessFully for Given Id : " + id;

		}
		return "Company Not Avaiable For given Id : " + id;

	}

	@Override
	public List<Company> getCompanys(Integer page, Integer size) {
		PageRequest request = PageRequest.of(page, size);
		List<Company> categories = (List<Company>) companyRepository.findAll(request).get();
		return categories;
	}

	@Override
	public String addCompanyToCar(Integer companyId, Integer carId) 
	{
		if (companyRepository.existsById(companyId) && carRepository.existsById(carId))
		{
			Company company = companyRepository.findById(companyId).get();
			Car car = carRepository.findById(carId).get();

			company.getCarList().add(car);
			companyRepository.save(company);
			return "Car added to Company Successfully";
		}
		return "Records not present for given Ids";
	}

}
