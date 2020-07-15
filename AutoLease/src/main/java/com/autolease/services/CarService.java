package com.autolease.services;

import java.util.HashMap;
import java.util.List;

import com.autolease.entity.Car;


public interface CarService {
	
	List<Car> getAllCars();
	
	List<Car> getCarsByCity(String city);
	
	Car saveCar(Car car);
	
	HashMap<Car, String> getAllCarsWithImage();
	
	HashMap<Car, String> getCityCarsWithImage(String city);
	
	Car getCarById(Long id);
	
	Car updateCar(Car car);
	
	String getCarCityById(Long id);

}
