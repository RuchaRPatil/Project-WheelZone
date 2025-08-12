package com.wheelzone.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<Car> getAllCars(Pageable pageable) {
	    return carRepository.findAll(pageable);
	}


	@Override
	public Car updateCarRecorde(Integer id, Car updateCar) {
		if(carRepository.existsById(id))
		{
			Car car = carRepository.findById(id).get();
			car.setCarName(updateCar.getCarName());
			car.setColor(updateCar.getColor());
			car.setCompany(updateCar.getCompany());
			car.setPrice(updateCar.getPrice());
			car.setQuantity(updateCar.getQuantity());
			
			Car updatecar = carRepository.save(car);
			return updatecar;
		}
		
		return null;
	}

	@Override
	public String deleteCarRecorde(Integer id) {
		if( carRepository.existsById(id))
		{
			carRepository.deleteById(id);
			return "Car Deleted SuccessFully for Given Id : " + id;
		}
		return "Car Not Avaiable For given Id : " + id;

	}

}
