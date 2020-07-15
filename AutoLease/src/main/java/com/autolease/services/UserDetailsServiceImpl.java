package com.autolease.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.autolease.entity.Role;
import com.autolease.entity.User;
import com.autolease.repos.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
		System.out.println("under UserDetailsServiceImpl");
		
		
		User user = userRepository.findByPhone(phone);
		
		
		System.out.println("My User======> " + user);
//		System.out.println(user.getPassword());
		if(user == null) {
			System.out.println("UNder If=======....");
			throw new UsernameNotFoundException("User not found for phone: " + phone);
		}
		
//		return new org.springframework.security.core.userdetails.User(user.getPhone(), user.getPassword(), user.getRoles());
	
		
//		Set<Role> roles = user.getRoles();
//		for(Role r: roles) {
//			System.out.println("ROLE==============>" + r);
//		}
		return new UserDetailsImpl(user);
	

}}
