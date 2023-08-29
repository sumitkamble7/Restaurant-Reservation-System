package com.app.entities;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

@Entity
@Table(name = "hotel_owner")
public class HotelOwner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int owner_id;

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

	/*
	 * hotelOwner
	 */
	@OneToMany(mappedBy = "hotelOwner", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Hotel> hotels;

	public HotelOwner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HotelOwner(int owner_id, @NotBlank(message = "First name is required") String fname,
			@NotBlank(message = "Last name is required") String lname,
			@NotBlank(message = "Email is required") @Email(message = "Invalid email format") String email,
			@NotBlank(message = "Password is required") String password,
			@NotBlank(message = "Phone number is required") String phoneNumber) {
		super();
		this.owner_id = owner_id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	public int getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
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

	@Override
	public String toString() {
		return "HotelOwner [owner_id=" + owner_id + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", password=" + password + ", phoneNumber=" + phoneNumber + "]";
	}

}
