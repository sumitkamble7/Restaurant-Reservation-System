package com.app.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Hotel;
import com.app.services.HotelServiceInterface;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class HotelController {

	@Autowired
	private HotelServiceInterface hotelServiceInterface;

	private List<Hotel> hotelList = new ArrayList<>();

	@GetMapping("/hotels")
	public List<Hotel> getAllHotels() {
		hotelList = hotelServiceInterface.getAllHotels();
		return hotelList;
	}

	@GetMapping("/hotels/{id}")
	public Hotel getHotel(@PathVariable int id) {
		System.err.println(id);
		Hotel hotel = hotelServiceInterface.getHotel(id);
		System.out.println(hotel);
		return hotel;
	}

	@PostMapping("/hotels/add")
	public Hotel addNewHotel(@RequestBody Hotel hotel) {
		return hotelServiceInterface.addNewHotel(hotel);
	}

	@PutMapping("/hotels/update")
	public Hotel updateHotel(@RequestBody Hotel hotel) {
		return hotelServiceInterface.updateHotel(hotel);
	}

	@DeleteMapping("/hotels/delete/{id}")
	public String deleteHotel(@PathVariable int id) {
		return hotelServiceInterface.deleteHotel(id);
	}
}
