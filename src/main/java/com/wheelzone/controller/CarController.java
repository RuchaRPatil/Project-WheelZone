package com.wheelzone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wheelzone.model.Car;
import com.wheelzone.service.CarService;

@RestController
@RequestMapping(value = "/api")
public class CarController {
	
	@Autowired
	private CarService carService;

	// http://localhost:9090/api/cars
	@PostMapping(value = "/cars")
	public ResponseEntity<Car> addCar(@RequestBody Car car)
	{
		Car save=carService.addCars(car);
		return new ResponseEntity<Car>(save, HttpStatus.CREATED);
	}
}
