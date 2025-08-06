package com.wheelzone.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer companyId;
	private String companyName;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Car> carList;
	
	public Company() {
		// TODO Auto-generated constructor stub
	}

	public Company(Integer companyId, String companyName, List<Car> carList) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.carList = carList;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<Car> getCarList() {
		return carList;
	}

	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", carList=" + carList + "]";
	}
	
	

}
