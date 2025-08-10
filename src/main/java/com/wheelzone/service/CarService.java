package com.wheelzone.service;

import com.wheelzone.model.Car;

public interface CarService {

	Car addCars(Car car);

	Car updateCarRecorde(Integer id, Car updateCar);

	String deleteCarRecorde(Integer id);

	
}
