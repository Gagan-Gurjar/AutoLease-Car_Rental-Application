package com.autolease.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.autolease.entity.Car;
import com.autolease.entity.Location;
import com.autolease.entity.User;
import com.autolease.repos.LocationRepository;
import com.autolease.repos.UserRepository;
import com.autolease.services.CarService;


@Controller
public class CarController {
	
	@Autowired
	CarService carService;
	
	@Autowired
	LocationRepository locationRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/")
	public String showHomePage(ModelMap modelMap) {
		HashMap<Car, String> allCars = carService.getAllCarsWithImage();
		modelMap.addAttribute("cars", allCars);
		return "index";
	}
	@RequestMapping("/backHome")
	public String showHome(ModelMap modelMap) {
		HashMap<Car, String> allCars = carService.getAllCarsWithImage();
		modelMap.addAttribute("cars", allCars);
		return "index";
	}
	
	@RequestMapping("/showAddCar")
	public String showAddCar(ModelMap modelMap) {
		
		List<Location> locations = locationRepository.findAll();	
//		model.addAttribute("car", new Car());
		modelMap.addAttribute("locations", locations);
		return "car/showAddCar";
	}
	
	@PostMapping("/saveCar")
	public String saveLocation(@RequestParam("image") MultipartFile file,
			@RequestParam("carName") String carName,
			@RequestParam("companyName") String companyName,
			@RequestParam("carNumber") String carNumber,
			@RequestParam("fuelType") String fuelType,
			@RequestParam("seat") String seat,
			@RequestParam("city") String city,
			@RequestParam("price") String price,
			ModelMap modelMap) {
				
		if (file.isEmpty() || carName.isEmpty() || companyName.isEmpty() || carNumber.isEmpty() || fuelType.isEmpty() || 
				seat.isEmpty() || price.isEmpty()) {
			String msg = "Please fill/select all fields";
			modelMap.addAttribute("msg", msg);
			return "car/showAddCar";
		  }
		byte[] photo;
		try {
			photo = file.getBytes();
			String disable = "false";
			Car car =new Car(companyName, carName, carNumber, seat, price, fuelType, city, disable, photo);
			
			Car saveCar = carService.saveCar(car);
			String msg = "Car saved with id: " + saveCar.getId();
			modelMap.addAttribute("msg", msg);
			List<Location> locations = locationRepository.findAll();	
			modelMap.addAttribute("locations", locations);
			
			return "car/showAddCar";
		} catch (IOException e) {			
			e.printStackTrace();
			return "car/showAddCar";
		}		
	}
	
	
	
	@RequestMapping("/showEditCarsByLocation")
	public String showEditCarsByLocation(ModelMap modelMap) {
		List<Location> locations = locationRepository.findAll();	
		modelMap.addAttribute("locations", locations);
		return "car/showEditCarsByLocation";
		
	}
	@RequestMapping("/showEditCarsPage")
	public String showEditCars(@RequestParam("city") String city,
			ModelMap modelMap) {
		HashMap<Car, String> map = carService.getCityCarsWithImage(city);
		modelMap.addAttribute("cars", map);
		return "car/showEditCarsPage";
		
	}
	
	@RequestMapping("/showUpdateCar")
	public String showUpdateCar(@RequestParam("carId") String carId,
			ModelMap modelMap) {
		long id = Long.parseLong(carId);
		Car car = carService.getCarById(id);
		byte[] encode = java.util.Base64.getEncoder().encode(car.getImage());
		try {
			String s = new String(encode, "UTF-8");
			modelMap.addAttribute("image", s);
		} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
		}	
		modelMap.addAttribute("car", car);
		return "car/showUpdateCarPage";
	}
	
	@RequestMapping("/updateCar")
	public String updateCar(@ModelAttribute("car") Car car,
			@RequestParam("photo") MultipartFile file, 
			ModelMap modelMap) {
		System.out.println("CAR =====> " + car);
		Car tempCar = carService.getCarById(car.getId());
		if(!file.isEmpty()) {
			try {
				byte[] photo = file.getBytes();
				car.setImage(photo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			car.setImage(tempCar.getImage());
		}
		car.setCity(tempCar.getCity());
		Car updateCar = carService.saveCar(car);
//		System.out.println("My CAr ======> " + car);
		modelMap.addAttribute("car", updateCar);
		modelMap.addAttribute("msg", "Car Successfully Updated!");
		return "car/showUpdateCarPage";
	}
	
	

}






