package com.autolease.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.autolease.entity.User;
import com.autolease.repos.UserRepository;
import com.autolease.services.RegistrationService;
import com.autolease.services.SecurityService;


@Controller
public class RegistrationController {
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, ste);
	}
	
	
	
	@Autowired
	SecurityService securityService;
	
	@Autowired
	RegistrationService registrationService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	
	@RequestMapping("/showRegister")
	public String showRegisterForm(Model model) {
		System.out.println("/show register chla");
		User user = new User(); 
		model.addAttribute("user", user);
		return "showRegister";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("user")
	 User user, BindingResult br, ModelMap modelMap) {
		if(br.hasErrors())
			return "showRegister";
		else {
			if(securityService.checkUser(user.getPhone())) {
				modelMap.addAttribute("userExists", "This phone no. is already in use.");
				return "showRegister";
			}
			int otp = registrationService.registerProcess(user);
			modelMap.addAttribute("otp", otp);
			modelMap.addAttribute("user", user);
			return "OTPConfirmation";
		}		
	}
	
	@RequestMapping(value="/confirmRegistration", method = RequestMethod.POST)
	public String confirmRegistration(@RequestParam("userOTP") String userOTP, 
			@RequestParam("adminOTP") String adminOTP, 
			ModelMap modelMap,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("email") String email,
			@RequestParam("phone") String phone,
			@RequestParam("age") int age,
			@RequestParam("password") String password,
			@RequestParam("gender") String gender) {
		
		
		
		if(adminOTP.equalsIgnoreCase(userOTP)) {
			System.out.println("under if userOTP");
			User user = new User();
			user.setAge(age);
			user.setEmail(email);
			user.setFirstName(firstName);
			user.setGender(gender);
			user.setLastName(lastName);
			user.setPassword(encoder.encode(password));
			user.setPhone(phone);
			System.out.println("=====> saving: " + user);
			userRepository.save(user);
			modelMap.addAttribute("successMsg", "Registration Successful!");
			return "showLogin";
		}
		else {
			modelMap.addAttribute("error", "Incorrect OTP");
			modelMap.addAttribute("otp", adminOTP);
			return "OTPConfirmation";
		}
			
		
	}
	
	
}











