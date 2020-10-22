package com.tyeporter.car.service;

import com.tyeporter.car.repo.CarRepo;
import com.tyeporter.car.model.Car;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	CarRepo repo;

	// =========================================================
    // GET
    // =========================================================

    @Override
    public Optional<Car> getCarById(Long id) {
    	return this.repo.findById(id);
    }

    @Override
    public Iterable<Car> getAllCar() {
    	return this.repo.findAll();
    }

    // =========================================================
    // PUT
    // =========================================================

    @Override
    public Optional<Car> updateCar(Car newCar, Long id) {
    	this.repo.findById(id).map(car -> {
    		car.setMake(newCar.getMake());
    		car.setModel(newCar.getModel());
    		car.setYear(newCar.getYear());
    		car.setColor(newCar.getColor());
    		return repo.save(car);
    	});

    	return this.repo.findById(id);
    }

    // =========================================================
    // POST
    // =========================================================

    @Override
    public void saveCar(Car car) {
    	this.repo.save(car);
    }

    // =========================================================
    // DELETE
    // =========================================================

    @Override
    public void removeCarById(Long id) {
    	this.repo.deleteById(id);
    }

}