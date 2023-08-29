package com.app.services;

import java.util.List;

import com.app.entities.Booking;

public interface BookingServiceInterface {
	
	//booking table
	public String bookTable(Booking booking);
	
	//getting hotel using hotel id
	public List<Booking> getBookingsByHotel_Id(int hotelId);
}
