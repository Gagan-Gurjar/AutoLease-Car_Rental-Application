package com.autolease.services;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autolease.dto.MyBookings;
import com.autolease.entity.Booking;
import com.autolease.entity.Car;
import com.autolease.repos.BookingRepository;
import com.autolease.repos.CarRepository;
import com.autolease.util.EmailUtil;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	CarRepository carRepository;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Override
	public String getPrice(Car car, int hour) {
		double result = Double.parseDouble(car.getPrice()) * hour;
		return String.valueOf(result);
	}

	@Override
	public Booking bookCar(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public void bookingMail(Booking booking) {
		Car car = carRepository.getCarById(booking.getCarId());
		emailUtil.sendBookingEmail(booking, car);
	}

	@Override
	public List<Booking> myBookings(Long userId) {
		System.out.println("List <Booking> myBookings");
		return bookingRepository.getBookingByUserId(userId);
	}
	
	

	@Override
	public List<MyBookings> myBookingWithCars(Long userId) {
		List<Booking> list = bookingRepository.getBookingByUserId(userId);
		List<MyBookings> result = new ArrayList<>();
		for(Booking b: list) {
			MyBookings myBookings = new MyBookings();
			Car car = carRepository.getCarById(b.getCarId());
			byte[] encode = java.util.Base64.getEncoder().encode(car.getImage());
			try {
				String s = new String(encode, "UTF-8");
				myBookings.setBooking(b);
				myBookings.setCar(car);
				myBookings.setImage(s);
				
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			result.add(myBookings);
		}
		
		return result;
	}

	@Override
	public Booking cancelBookingById(long id) {
		Booking booking = bookingRepository.getBookingById(id);
		booking.setCancel("yes");
		Booking save = bookingRepository.save(booking);
		return save;
	}

	

}
