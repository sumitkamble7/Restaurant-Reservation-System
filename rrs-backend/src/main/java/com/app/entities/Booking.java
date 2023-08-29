package com.app.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@Column(name = "booking_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int booking_id;

	@Column(name = "booking_time")
	private String booking_time;

	@Column(name = "booking_date")
	private String booking_date;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "hotel_id", referencedColumnName = "hotel_id")
	private Hotel hotel;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(int booking_id, String booking_time, String booking_date) {
		super();
		this.booking_id = booking_id;
		this.booking_time = booking_time;
		this.booking_date = booking_date;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public String getBooking_time() {
		return booking_time;
	}

	public void setBooking_time(String booking_time) {
		this.booking_time = booking_time;
	}

	public String getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}

	public User getUser() {
		return user;
	}

	public Hotel getHotel() {
		return hotel;
	}

	@Override
	public String toString() {
		return "Booking [booking_id=" + booking_id + ", booking_time=" + booking_time + ", booking_date=" + booking_date
				+ ", user=" + user + ", hotel=" + hotel + "]";
	}

}
