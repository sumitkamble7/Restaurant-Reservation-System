package com.app.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.type.TrueFalseType;

import java.util.*;

@Entity
@Table(name = "hotel")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hotel_id;

	@NotBlank(message = "Hotel name is required")
	private String hotelName;

	@NotBlank(message = "Address is required")
	@Column(unique = true)
	private String address;

	@DecimalMin(value = "0.0", message = "Ratings cannot be negative")
	@DecimalMax(value = "5.0", message = "Ratings cannot exceed 5")
	private Double ratings;

	@Min(value = 0, message = "Capacity cannot be negative")
	private Integer capacity;

	private Boolean status;
	@Column(name ="imageName" )
	private String imageName;

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}


	// hotel
	@ManyToOne
	@JoinColumn(name = "hotel_owner_id", referencedColumnName = "owner_id")
	private HotelOwner hotelOwner;

	// category
	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "cat_id")
	private Category category;

	// VegMenu
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<VegMenu> vegMenu;

	// NonVegMenu
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<NonVegMenu> nonVegMenu;
	
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Booking> bookings;
	
	
	

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hotel(int hotel_id, @NotBlank(message = "Hotel name is required") String hotelName,
			@NotBlank(message = "Address is required") String address,
			@DecimalMin(value = "0.0", message = "Ratings cannot be negative") @DecimalMax(value = "5.0", message = "Ratings cannot exceed 5") Double ratings,
			@Min(value = 0, message = "Capacity cannot be negative") Integer capacity, Boolean status,String imageName) {
		super();
		this.hotel_id = hotel_id;
		this.hotelName = hotelName;
		this.address = address;
		this.ratings = ratings;
		this.capacity = capacity;
		this.status = status;
		this.imageName =imageName;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getRatings() {
		return ratings;
	}

	public void setRatings(Double ratings) {
		this.ratings = ratings;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	

	@Override
	public String toString() {
		return "Hotel [hotel_id=" + hotel_id + ", hotelName=" + hotelName + ", address=" + address + ", ratings="
				+ ratings + ", capacity=" + capacity + ", status=" + status + "]";
	}

}
