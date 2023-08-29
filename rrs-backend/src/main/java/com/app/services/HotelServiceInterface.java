package com.app.services;

import java.util.List;

import com.app.entities.Hotel;

public interface HotelServiceInterface {

	// get all hotels
	public List<Hotel> getAllHotels();

	// get specific hotels
	public Hotel getHotel(int id);

	// add new hotels
	public Hotel addNewHotel(Hotel hotel);

	// update existing hotels
	public Hotel updateHotel(Hotel hotel);

	// delete hotels
	public String deleteHotel(int id);
}
