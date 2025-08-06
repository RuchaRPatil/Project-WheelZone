package com.wheelzone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	// URL : http://localhost:9090/api/cars
	
	@PostMapping(value = "/cars")
	public ResponseEntity<Car> addCar(@RequestBody Car car)
	{
		Car save=carService.addCars(car);
		return new ResponseEntity<Car>(save, HttpStatus.CREATED);
	}
	
	// URL : http://localhost:9090/api/cars/{id}
	
	@GetMapping(value = "/cars/{id}")
	public ResponseEntity<Car> getCar(@PathVariable int id)
	{
		Car car = carService.getCar(id);
		
		if(car != null)
		{
			return new ResponseEntity<Car>(car, HttpStatus.OK);
		}
		
		return new ResponseEntity<Car>(car, HttpStatus.NO_CONTENT);
	}
	
	// URL : http://localhost:9090/api/cars
	
	@GetMapping(value = "/cars")
	public ResponseEntity<List<Car>> getAllCars()
	{
		List<Car> carlist = carService.getAllCars();
		
		return new ResponseEntity<List<Car>>(carlist,HttpStatus.OK);
	}
}
