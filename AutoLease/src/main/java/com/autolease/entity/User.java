package com.autolease.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "user")
public class User extends AbstractEntity {

	@NotBlank(message = "Invalid")
	@Column(name = "first_name")
	private String firstName;

	@NotBlank(message = "Invalid")
	@Column(name = "last_name")
	private String lastName;

	@NotNull(message = "Should not be blank")
	@Email
	@Column(name = "email")
	private String email;

	@Size(max = 10, min = 10, message = "Only contains 10 digit")
	@Column(name = "phone")
	private String phone;

	@NotNull(message = "Should not be blank")
	@Min(value = 18, message = "Minimum age must be 18")
	@Column(name = "age")
	private int age;

	@NotNull(message = "Please choose your Gender")
	@Column(name = "gender")
	private String gender;

	@NotNull(message = "Please enter a password")
	@Column(name = "password")
	private String password;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public User() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(String firstName, String lastName, String email, String phone, int age, String gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.age = age;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone
				+ ", age=" + age + ", gender=" + gender + ", password=" + password + "]";
	}

}
