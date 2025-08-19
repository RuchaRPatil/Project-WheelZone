package com.wheelzone.model;

public class CarResponse
{
	private Integer carId;
	private String carName;
	private String color;
	private Double price;
	private Integer quantity;
	
	private Integer companyId;
	private String companyName;
	
	public CarResponse() {
		// TODO Auto-generated constructor stub
	}

	public CarResponse(Integer carId, String carName, String color, Double price, Integer quantity, Integer companyId,
			String companyName) {
		super();
		this.carId = carId;
		this.carName = carName;
		this.color = color;
		this.price = price;
		this.quantity = quantity;
		this.companyId = companyId;
		this.companyName = companyName;
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
	
	
	
	

}
