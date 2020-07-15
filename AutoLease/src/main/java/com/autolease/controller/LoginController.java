package com.autolease.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.autolease.entity.Car;
import com.autolease.entity.Location;
import com.autolease.entity.User;
import com.autolease.repos.LocationRepository;
import com.autolease.repos.UserRepository;
import com.autolease.services.CarService;
import com.autolease.services.SecurityService;

@Controller
public class LoginController {
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private CarService carService;
	
	@Autowired
	LocationRepository locationRepository;
	
	@Autowired
	UserRepository userRepository;
	
//	@Autowired
//	private BCryptPasswordEncoder encoder;

	@RequestMapping("/showLogin")
	public String showLogin() {
		return "showLogin";
	}
	@RequestMapping("/loginSuccess")
	public String loginSuccess(ModelMap modelMap) {
		List<Location> locations = locationRepository.findAll();
//		User user = userRepository.findByPhone(phone);
		
		System.out.println(locations);
		modelMap.addAttribute("locations", locations);
//		modelMap.addAttribute("user", user);
		return "loginSuccess";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("username") String phone, 
			@RequestParam("password") String password, 
			ModelMap modelMap) {
		System.out.println("under /login");
		boolean loginResponse = securityService.login(phone, password);
		
		if(loginResponse) {
			List<Location> locations = locationRepository.findAll();
			User user = userRepository.findByPhone(phone);
			
			System.out.println(locations);
			modelMap.addAttribute("locations", locations);
			modelMap.addAttribute("user", user);
			return "loginSuccess";
		}
		else {
			System.out.println("else =====>");
			modelMap.addAttribute("msg", "Invalid email or password. Please try again...");
			return "showLogin";
		}
		
	}
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response, 
			ModelMap modelMap) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    HashMap<Car, String> allCars = carService.getAllCarsWithImage();
		modelMap.addAttribute("cars", allCars);
	    return "index";
	}
	

}
