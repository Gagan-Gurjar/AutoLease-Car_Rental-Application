package com.autolease.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.autolease.dto.MyBookings;
import com.autolease.entity.Booking;
import com.autolease.entity.Car;
import com.autolease.entity.Location;
import com.autolease.entity.User;
import com.autolease.repos.LocationRepository;
import com.autolease.repos.UserRepository;
import com.autolease.services.BookingService;
import com.autolease.services.CarService;

@Controller
public class BookingController {
	
	@Autowired
	CarService carService;
	
	@Autowired
	BookingService bookingService;
		
	@Autowired
	LocationRepository locationRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/back")
	public String loginSuccess( 
			ModelMap modelMap) {
		List<Location> locations = locationRepository.findAll();
//		 User user = userRepository.findByPhone(mobile);
		modelMap.addAttribute("locations", locations);
//		modelMap.addAttribute("user", user);
		return "loginSuccess";
	}
	
	@RequestMapping("/user/showBookingPage")
	public String showBookingPage(@RequestParam("carId") String carId, 
			@RequestParam("userId") String userId,
			ModelMap modelMap,
			Model model) {
		System.out.println("CarId ===>" + carId + " UserId===>" + userId);
		modelMap.addAttribute("carId", carId);
		modelMap.addAttribute("userId", userId);
		model.addAttribute("booking", new Booking());
		
		return "car/showBookingPage";
		
	}
	
	@PostMapping("/finalBooking")
	public String finalBooking(@ModelAttribute("booking") Booking booking, 
			@RequestParam("userId") String userId,
			@RequestParam("carId") String carId,
			ModelMap modelMap,
			Model model) {
		booking.setCarId(Long.parseLong(carId));
		booking.setUserId(Long.parseLong(userId));
		System.out.println("MY BOOKING=====> " + booking.getDate());
		System.out.println("MY BOOKING=====> " + booking);
		
		Car car = carService.getCarById(Long.parseLong(carId));
		int hour = booking.getHour();
		String finalPrice = bookingService.getPrice(car, hour);
		System.out.println("Final price to be pay ====> " + finalPrice);
		modelMap.addAttribute("price", finalPrice);
		model.addAttribute("booking", booking);
		return "car/paymentPage";
	}
	
	@RequestMapping("/bookingDone")
	public String bookingDone(@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("driver") String driver,
			@RequestParam("hour") String hour,
			@RequestParam("date") String date,
			@RequestParam("time") String time,
			@RequestParam("carId") String carId,
			@RequestParam("userId") String userId,
			@RequestParam("licenceNumber") String licenceNumber,
			@RequestParam("paymentMethod") String paymentMethod,
			@RequestParam("amount") String amount,
			ModelMap modelMap) {
		
		String cancel = "no";
		Booking booking = new Booking(name, email, driver, Integer.parseInt(hour), date, time, Long.parseLong(carId),
				Long.parseLong(userId), licenceNumber, paymentMethod, amount, cancel);
		
		Booking bookCar = bookingService.bookCar(booking);
		
		System.out.println("Result ===> " + bookCar);
		bookingService.bookingMail(bookCar);
		System.out.println("MAIL SENT======>\n\n");
		modelMap.addAttribute("id", bookCar.getId());
		return "car/bookingConfirm";
	}
	
	@GetMapping("/user/bookNow")
	public String showCarsByCity(ModelMap modelMap,
			@RequestParam("city") String city, 
			@RequestParam("mobile") String mobile) {
		User user = userRepository.findByPhone(mobile);
		long userId = user.getId();
		System.out.println("INSIDE /bookNow=====> " + city + userId);
		HashMap<Car, String> allCars = carService.getCityCarsWithImage(city);
		modelMap.addAttribute("cars", allCars);
		modelMap.addAttribute("userId", userId);
		return "car/showBookNow";
	}
	
	
	@GetMapping("/user/showMyBooking")
	public String showMyBooking(@RequestParam("mobile") String mobile,
			ModelMap modelMap) {
		User user = userRepository.findByPhone(mobile);
		long id = user.getId();
		List<MyBookings> result = bookingService.myBookingWithCars(id);
		System.out.println("Result=====> ");
		for(MyBookings m : result) {
			System.out.println(m.getBooking());
//			System.out.println(m.getCar());
			System.out.println();
		}
		modelMap.addAttribute("bookings", result);
		return "car/myBookings";
	}
	
	@RequestMapping("/cancelBooking")
	public String cancelBooking(@RequestParam("bookingId") String bookingId,
			@RequestParam("userId") String userId,
			ModelMap modelMap) {
		long id = Long.parseLong(bookingId);
		long user = Long.parseLong(userId);
		Booking result = bookingService.cancelBookingById(id);
		List<MyBookings> bookings = bookingService.myBookingWithCars(user);
		modelMap.addAttribute("bookings", bookings);
		if(result != null) {
			modelMap.addAttribute("msg", "Booking Cancelled Successfully!");
			return "car/myBookings";
		}
		else {
			modelMap.addAttribute("msg", "Booking not Cancelled!");
			return "car/myBookings";
		}
		
		
	}
 	

}








