package com.autolease.services;

import java.util.List;

import com.autolease.dto.MyBookings;
import com.autolease.entity.Booking;
import com.autolease.entity.Car;

public interface BookingService {
	
	String getPrice(Car car, int hour);
	
	Booking bookCar(Booking booking);
	
	void bookingMail(Booking booking);
	
	List<Booking> myBookings(Long id);
		
	List<MyBookings> myBookingWithCars(Long userId);

	Booking cancelBookingById(long id);

}
