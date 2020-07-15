package com.autolease.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.autolease.entity.Booking;
import com.autolease.entity.Car;

@Component
public class EmailUtil {

	@Value("${register.email.body}")
	private String REGISTER_EMAIL_BODY;

	@Value("${register.email.subject}")
	private String REGISTER_EMAIL_SUBJECT;

	@Value("${booking.email.subject}")
	private String BOOKING_EMAIL_SUBJECT;

	@Value("${booking.email.body.hello}")
	private String BOOKING_EMAIL_BODY_HELLO;

	@Value("${booking.email.body.car}")
	private String BOOKING_EMAIL_BODY_CAR;

	@Value("${booking.email.body.id}")
	private String BOOKING_EMAIL_BODY_ID;

	@Value("${booking.email.body.price}")
	private String BOOKING_EMAIL_BODY_PRICE;

	@Value("${booking.email.body.date}")
	private String BOOKING_EMAIL_BODY_DATE;
	
	@Value("${booking.email.body.time}")
	private String BOOKING_EMAIL_BODY_TIME;

	@Value("${booking.email.body.greeting}")
	private String BOOKING_EMAIL_BODY_GREETING;
	
	@Value("${booking.email.body.hour}")
	private String BOOKING_EMAIL_BODY_Hour;
	
	

	@Autowired
	private JavaMailSender sender;

	public void sendRegisterEmail(String toAddress, int otp) {
		MimeMessage message = sender.createMimeMessage();

		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
			messageHelper.setTo(toAddress);
			messageHelper.setSubject(REGISTER_EMAIL_SUBJECT);
			messageHelper.setText(REGISTER_EMAIL_BODY + " " + otp);
			sender.send(message);

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendBookingEmail(Booking booking, Car car) {
		MimeMessage message = sender.createMimeMessage();
		
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
			messageHelper.setTo(booking.getEmail());
			messageHelper.setSubject(BOOKING_EMAIL_SUBJECT);
			
			String mail = BOOKING_EMAIL_BODY_HELLO + booking.getName() + BOOKING_EMAIL_BODY_CAR + car.getCompanyName() + 
					" " + car.getCarName() + " " + car.getCarNumber() + " " + BOOKING_EMAIL_BODY_ID + booking.getId() + 
					" " + BOOKING_EMAIL_BODY_PRICE + booking.getAmount() + " " + BOOKING_EMAIL_BODY_DATE + booking.getDate() + 
					BOOKING_EMAIL_BODY_TIME + booking.getTime() + BOOKING_EMAIL_BODY_Hour + booking.getHour() + " hour(s). " + 
					BOOKING_EMAIL_BODY_GREETING;
			
			messageHelper.setText(mail);
			sender.send(message);
			
		} catch (MessagingException e) {
			System.out.println("Exception =========> \n\n");
			e.printStackTrace();
		}
	}

}
