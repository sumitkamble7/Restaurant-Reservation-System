package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Booking;
import com.app.services.BookingServiceInterface;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") 
public class BookingController {

	@Autowired
	private BookingServiceInterface bookingServiceInterface;
	
	@PostMapping("bookings")
	public String bookTable(@RequestBody Booking booking) {
		System.err.println(booking);
		return bookingServiceInterface.bookTable(booking);
	}
	
	@GetMapping("/bookings/{hotelId}")
    public ResponseEntity<List<Booking>> getBookingsByHotelId(@PathVariable int hotelId) {
        List<Booking> bookings = bookingServiceInterface.getBookingsByHotel_Id(hotelId);
        System.err.println(bookings);
        return ResponseEntity.ok(bookings);
    }
}
