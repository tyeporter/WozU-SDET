package com.tyeporter.car.service;

import com.tyeporter.car.model.Car;
import java.util.Optional;

public interface CarService {

	Optional<Car> getCarById(Long id);
	Iterable<Car> getAllCar();
	Optional<Car> updateCar(Car newCar, Long id);
	void saveCar(Car car);
	void removeCarById(Long id);

}