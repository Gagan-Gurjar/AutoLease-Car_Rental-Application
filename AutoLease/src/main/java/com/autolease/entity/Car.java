package com.autolease.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car extends AbstractEntity {

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "car_name")
	private String carName;

	@Column(name = "car_number")
	private String carNumber;

	@Column(name = "seat")
	private String seat;

	@Column(name = "price")
	private String price;

	@Column(name = "fuel_type")
	private String fuelType;

	@Column(name = "city")
	private String city;

	@Lob
	@Column(name = "image")
	private byte[] image;
	
	@Column(name = "disable")
	private String disable;

	public Car() {

	}

	public Car(String companyName, String carName, String carNumber, String seat, String price, String fuelType,
			String city, String disable, byte[] image) {
		this.companyName = companyName;
		this.carName = carName;
		this.carNumber = carNumber;
		this.seat = seat;
		this.price = price;
		this.fuelType = fuelType;
		this.city = city;
		this.image = image;
		this.disable = disable;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getDisable() {
		return disable;
	}

	public void setDisable(String disable) {
		this.disable = disable;
	}

	@Override
	public String toString() {
		return "Car [companyName=" + companyName + ", carName=" + carName + ", carNumber=" + carNumber + ", seat="
				+ seat + ", price=" + price + ", fuelType=" + fuelType + ", city=" + city + ", image="
				+ Arrays.toString(image) + ", disable=" + disable + "]";
	}

}
