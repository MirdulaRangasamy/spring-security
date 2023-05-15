package com.exterro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exterro.model.Car;
import com.exterro.repository.CarRepository;


@RestController
public class CarController {

	@Autowired
	private CarRepository carRepo;
	
	
	@GetMapping("/home")
	public String getHome() {
		return "Hello Home";
	}
	
	@GetMapping("/admin")
	public String getAdmin() {
		return "Hello Admin";
	}
	
	
	
	@GetMapping("cars")
	public List<Car> getCars() {
		return carRepo.findAll();
	}
	
	@GetMapping("cars/{regNo}")
	public Car getCar(@PathVariable String regNo) {
		return carRepo.findByRegNo(regNo).orElse(null);
	}
	
	@PostMapping("/admin/addCar")
	public Car addCar(@RequestBody Car car) {
		return carRepo.save(car);
	}
	
	@PutMapping("/admin/updateCar")
	public Car updateCar(@RequestBody Car car) {
		Car car1 = carRepo.findByRegNo(car.getRegNo()).orElse(null);
		if(car1 != null) {
			carRepo.delete(car1);
		}
		return carRepo.save(car);
	}
	
	@DeleteMapping("admin/deleteCar/{regNo}")
	public String deleteCar(@PathVariable String regNo) {
		Car car1 = carRepo.findByRegNo(regNo).orElse(null);
		if(car1 != null) {
			carRepo.delete(car1);
			return "Car Deleted Successfully";
		}
		return "Car Unavailable";
	}
}