package com.app.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Hotel;
import com.app.repositories.HotelRepository;
import com.app.services.HotelServiceInterface;

@Service
public class HotelService implements HotelServiceInterface {

	@Autowired
	private HotelRepository hotelRepository;

	private List<Hotel> hotelList = new ArrayList<>();

	@Override
	public List<Hotel> getAllHotels() {
		hotelList = hotelRepository.findAll();
		return hotelList;

	}

	@Override
	public Hotel getHotel(int id) {
		Optional<Hotel> optional = hotelRepository.findById(id);
		return optional.get();
	}

	@Override
	public Hotel addNewHotel(Hotel hotel) {
		hotel.setHotel_id(0);
		return hotelRepository.save(hotel);
	}

	@Override
	public Hotel updateHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	@Override
	public String deleteHotel(int id) {
		hotelRepository.deleteById(id);
		return "Hotel Deleted";
	}
}
