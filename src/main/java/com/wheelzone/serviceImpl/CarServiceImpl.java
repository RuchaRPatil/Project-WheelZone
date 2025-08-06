package com.wheelzone.serviceImpl;

import java.util.List;
import java.util.Optional;

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
	
	@Override
	public Car getCar(int id) {
		
		Optional<Car> optional = carRepository.findById(id);
		
		if(optional.isPresent())
		{
			Car car = optional.get();
			
			return car;
		}
		
		return null;
	}
	
	@Override
	public List<Car> getAllCars() {
		
		List<Car> carlist = carRepository.findAll();
		
		return carlist;
	}

}
