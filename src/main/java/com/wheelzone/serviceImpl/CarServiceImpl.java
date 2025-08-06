package com.wheelzone.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wheelzone.model.Car;
import com.wheelzone.repository.CarRepository;
import com.wheelzone.service.CarService;

@Service
public class CarServiceImpl implements CarService{
	
	@Autowired
	private CarRepository carRepository;

	@Override
	public Car addCars(Car car) {
		Car save = carRepository.save(car);
		return save;
	}

}
