package com.autolease.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class Booking extends AbstractEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "driver")
	private String driver;

	@Column(name = "hour")
	private int hour;

	@Column(name = "date")
	private String date;

	@Column(name = "time")
	private String time;

	@Column(name = "car_id")
	private Long carId;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "licence_number")
	private String licenceNumber;

	@Column(name = "payment_method")
	private String paymentMethod;
	
	@Column(name = "amount")
	private String amount;
	
	@Column(name = "cancel")
	private String cancel;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCancel() {
		return cancel;
	}

	public void setCancel(String cancel) {
		this.cancel = cancel;
	}

	@Override
	public String toString() {
		return "Booking [name=" + name + ", email=" + email + ", driver=" + driver + ", hour=" + hour + ", date=" + date
				+ ", time=" + time + ", carId=" + carId + ", userId=" + userId + ", licenceNumber=" + licenceNumber
				+ ", paymentMethod=" + paymentMethod + ", amount=" + amount + ", cancel=" + cancel + "]";
	}

	public Booking() {
	}

	public Booking(String name, String email, String driver, int hour, String date, String time, Long carId,
			Long userId, String licenceNumber, String paymentMethod, String amount, String cancel) {
		this.name = name;
		this.email = email;
		this.driver = driver;
		this.hour = hour;
		this.date = date;
		this.time = time;
		this.carId = carId;
		this.userId = userId;
		this.licenceNumber = licenceNumber;
		this.paymentMethod = paymentMethod;
		this.amount = amount;
		this.cancel = cancel;
	}

	

}
