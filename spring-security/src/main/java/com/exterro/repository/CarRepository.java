package com.exterro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exterro.model.Car;

public interface CarRepository extends JpaRepository<Car,Long>{
	Optional<Car> findByRegNo(String regNo);
}
