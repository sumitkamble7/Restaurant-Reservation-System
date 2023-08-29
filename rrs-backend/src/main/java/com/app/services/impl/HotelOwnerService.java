package com.app.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.HotelOwner;
import com.app.entities.User;
import com.app.repositories.HotelOwnerRepository;
import com.app.services.HotelOwnerServiceInterface;

@Service
public class HotelOwnerService implements HotelOwnerServiceInterface {

	@Autowired
	private HotelOwnerRepository hotelOwnerRepository;

	private List<HotelOwner> ownerList = new ArrayList<>();

	@Override
	public List<HotelOwner> getAllOwners() {
		ownerList = hotelOwnerRepository.findAll();
		return ownerList;
	}

	@Override
	public HotelOwner getOwner(int id) {
		Optional<HotelOwner> optional = hotelOwnerRepository.findById(id);
		HotelOwner newOwner = optional.get();
		return newOwner;
	}

	@Override
	public HotelOwner addNewOwner(HotelOwner hotelOwner) {
		hotelOwner.setOwner_id(0);
		return hotelOwnerRepository.save(hotelOwner);
	}

	@Override
	public HotelOwner updateOwner(HotelOwner hotelOwner) {
		return hotelOwnerRepository.save(hotelOwner);
	}

	@Override
	public String deleteOwner(int id) {
		hotelOwnerRepository.deleteById(id);
		return "Hotel Owner Deleted";
	}
	
	@Override
	public HotelOwner loginHotelOwner(HotelOwner hotelOwner) {
		HotelOwner obj = hotelOwnerRepository.findByEmail(hotelOwner.getEmail());
		return obj;
	}

}
