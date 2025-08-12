package com.wheelzone.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wheelzone.model.Car;

public interface CarService {

	Car addCars(Car car);


	Car updateCarRecorde(Integer id, Car updateCar);

	String deleteCarRecorde(Integer id);

	

	Car getCar(int id);

	Page<Car> getAllCars(Pageable pageable);


}
