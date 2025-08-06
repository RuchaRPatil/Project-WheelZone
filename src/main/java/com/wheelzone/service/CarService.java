package com.wheelzone.service;

import java.util.List;

import com.wheelzone.model.Car;

public interface CarService {

	Car addCars(Car car);

	Car getCar(int id);

	List<Car> getAllCars();

}
