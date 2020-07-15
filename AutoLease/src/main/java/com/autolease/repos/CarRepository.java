package com.autolease.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autolease.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
	
	List<Car> findCarsByCity(String city);
	
	Car getCarById(Long id);
	
	String getCityById(Long id);

}
