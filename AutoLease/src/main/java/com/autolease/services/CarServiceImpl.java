package com.autolease.services;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autolease.entity.Car;
import com.autolease.repos.CarRepository;

@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
	CarRepository carRepository;

	@Override
	public List<Car> getAllCars() {
		return carRepository.findAll();
	}
	
	@Override
	public Car saveCar(Car car) {
		return carRepository.save(car);
	}

	@Override
	public HashMap<Car, String> getAllCarsWithImage() {
		List<Car> list = carRepository.findAll();
		HashMap<Car, String> map = new HashMap<Car, String>();
		
		for(Car e: list) {
			byte[] encode = java.util.Base64.getEncoder().encode(e.getImage());
			try {
				String s = new String(encode, "UTF-8");
				map.put(e, s);
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return map;
	}

	@Override
	public List<Car> getCarsByCity(String city) {
		return carRepository.findCarsByCity(city);
	}

	@Override
	public HashMap<Car, String> getCityCarsWithImage(String city) {
		List<Car> list = carRepository.findCarsByCity(city);
		HashMap<Car, String> map = new HashMap<Car, String>();
		
		for(Car e: list) {
			byte[] encode = java.util.Base64.getEncoder().encode(e.getImage());
			try {
				String s = new String(encode, "UTF-8");
				map.put(e, s);
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return map;
	}

	@Override
	public Car getCarById(Long id) {
		return carRepository.getCarById(id);
	}

	@Override
	public Car updateCar(Car car) {
		return carRepository.save(car);
	}

	@Override
	public String getCarCityById(Long id) {
		return carRepository.getCityById(id);
	}
	
	

}
