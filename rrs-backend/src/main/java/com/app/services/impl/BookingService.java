package com.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Booking;
import com.app.repositories.BookingRepository;
import com.app.services.BookingServiceInterface;

@Service
public class BookingService implements BookingServiceInterface {
	
	@Autowired
	private BookingRepository bookingRepository;
	@Override
	public String bookTable(Booking booking) {
		booking.setBooking_id(0);
		bookingRepository.save(booking);
		return "Booking Successful!";
	}
	@Override
	public List<Booking> getBookingsByHotel_Id(int hotelId) {
		
		return bookingRepository.findByHotel_Id(hotelId);
	}

}
