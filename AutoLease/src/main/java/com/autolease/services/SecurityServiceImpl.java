package com.autolease.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.autolease.entity.User;
import com.autolease.repos.UserRepository;

@Service
public class SecurityServiceImpl implements SecurityService {
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Override
	public boolean checkUser(String phone) {
		User user = userRepository.findByPhone(phone);
		if(user == null) 
			return false;
		else
			return true;
		
	}
	
	@Override
	public boolean login(String phone, String password) {
//		System.out.println("Security service boolean login");
//		UserDetails userDetails = userDetailsService.loadUserByUsername(phone);
//		System.out.println("return Security service boolean login");
		
//		User user = userRepository.findByPhoneAndPassword(phone, password);
//		System.out.println(user);
		
//		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, 
//				password, userDetails.getAuthorities());
//		
//		authenticationManager.authenticate(token);
//		boolean result = token.isAuthenticated();
//		
//		if(result) {
//			SecurityContextHolder.getContext().setAuthentication(token);
//		}
//		
//		return result;
//		if(user != null) {
//			return true;
//		}
//		else	
			return true;
	}

}
