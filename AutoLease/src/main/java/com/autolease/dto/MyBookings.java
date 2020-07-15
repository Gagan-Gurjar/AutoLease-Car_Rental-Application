package com.autolease.dto;

import com.autolease.entity.Booking;
import com.autolease.entity.Car;

public class MyBookings {
	
	private Booking booking;
	
	private Car car;
	
	private String image;

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "MyBookings [booking=" + booking + ", car=" + car + ", image=" + image + "]";
	}

	public MyBookings() {
	}
	

}
