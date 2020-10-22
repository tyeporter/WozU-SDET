package com.tyeporter.car.controller;

import java.util.Optional;

import com.tyeporter.car.model.Car;
import com.tyeporter.car.service.CarServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CarController {

	@Autowired
	CarServiceImpl service;

	// =========================================================
    // GET
    // =========================================================

	@GetMapping("/get/car/{id}")
    public Optional<Car> getCarById(@PathVariable Long id) {
    	return this.service.getCarById(id);
    }

    @GetMapping("/get/car/all")
    public Iterable<Car> getAllCar() {
    	return this.service.getAllCar();
    }

    // =========================================================
    // POST
    // =========================================================

    @PostMapping("/post/car")
    public String saveCar(@RequestBody Car car) {
    	this.service.saveCar(car);
    	return "Car (" + car.getMake() + ") saved.";
    }

    // =========================================================
    // PUT
    // =========================================================

    @PutMapping("/put/car/{id}")
    public Optional<Car> updateCar(@RequestBody Car newCar, @PathVariable Long id) {
    	return this.service.updateCar(newCar, id);
    }

    // =========================================================
    // DELETE
    // =========================================================

    @DeleteMapping("/delete/car/{id}")
    public String removeCarWithId(@PathVariable Long id) {
    	this.service.removeCarById(id);
    	return "Car with id (" + id + ") removed.";
    }

}