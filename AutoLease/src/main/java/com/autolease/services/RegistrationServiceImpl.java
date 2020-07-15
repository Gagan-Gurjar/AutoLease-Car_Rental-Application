package com.autolease.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autolease.entity.User;
import com.autolease.util.EmailUtil;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	EmailUtil emailUtil;
	
	
	
	@Override
	public int registerProcess(User user) {
		String toAddress = user.getEmail();
		int n = 100000 + new Random().nextInt(900000);
		System.out.println("OTP=====> " + n);
		emailUtil.sendRegisterEmail(toAddress, n);
		
		return n;
	}

	

}
