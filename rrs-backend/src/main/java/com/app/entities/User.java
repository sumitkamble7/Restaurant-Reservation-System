package com.app.entities;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;

	@NotBlank(message = "First name is required")
	private String fname;

	@NotBlank(message = "Last name is required")
	private String lname;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	@Column(unique = true)
	private String email;

	@NotBlank(message = "Password is required")
	private String password;

	@NotBlank(message = "Phone number is required")
	@Column(unique = true)
	private String phoneNumber;
	
	@OneToMany(mappedBy = "user")
	private List<Booking> bookings;
	
	
	public User() {
		/*
		 * default constructor
		 * */
	}
	
	/*
	 * parameterized constructor
	 * */
	public User(@NotBlank(message = "First name is required") String fname,
			@NotBlank(message = "Last name is required") String lname,
			@NotBlank(message = "Email is required") @Email(message = "Invalid email format") String email,
			@NotBlank(message = "Password is required") String password,
			@NotBlank(message = "Phone number is required") String phoneNumber) {
		
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}
	
	
	/*
	 * Getters and Setters
	 * */
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	/*
	 * toString
	 * */
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", password="
				+ password + ", phoneNumber=" + phoneNumber + "]";
	}

}