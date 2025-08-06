package com.wheelzone.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Car
{
	@Id
	
	private Integer carId;
	private String carName;
	private String color;
	private Double price;
	private Integer quantity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Company company;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(Integer carId, String carName, String color, Double price, Integer quantity, Company company) {
		super();
		this.carId = carId;
		this.carName = carName;
		this.color = color;
		this.price = price;
		this.quantity = quantity;
		this.company = company;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carName=" + carName + ", color=" + color + ", price=" + price + ", quantity="
				+ quantity + ", company=" + company + "]";
	}
	
	

}
