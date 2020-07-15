package com.autolease.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autolease.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

	List<Booking> getBookingByUserId(Long userId);
	
	Booking getBookingById(Long bookingId);
}
