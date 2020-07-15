package com.autolease.services;

public interface SecurityService {

	boolean checkUser(String phone);
	
	boolean login(String phone, String password);
}
