package com.app.services;

import java.util.List;

import com.app.entities.HotelOwner;
import com.app.entities.User;


public interface HotelOwnerServiceInterface {
	
	//get all Owners
	public List<HotelOwner> getAllOwners();
	
	//get specific Owners
	public HotelOwner getOwner(int id);
	
	//add new Owners
	public HotelOwner addNewOwner(HotelOwner hotelOwner);
	
	//update existing Owners
	public HotelOwner updateOwner(HotelOwner hotelOwner);
	
	//delete Owners
	public String deleteOwner(int id);
	//login
	public HotelOwner loginHotelOwner(HotelOwner hotelOwner);
}
