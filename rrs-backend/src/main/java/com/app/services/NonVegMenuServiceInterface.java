package com.app.services;

import java.util.List;


import com.app.entities.NonVegMenu;

public interface NonVegMenuServiceInterface {

	// get all NonVegMenu
	public List<NonVegMenu> getAllNonVegMenus();

	// get specific NonVegMenu
	public NonVegMenu getNonVegMenu(int id);

	// add new NonVegMenu
	public NonVegMenu addNewNonVegMenu(NonVegMenu nonVegMenu);

	// update existing NonVegMenu
	public NonVegMenu updateNonVegMenu(NonVegMenu nonVegMenu);

	// delete NonVegMenu
	public String deleteNonVegMenu(int id);
	
	//non veg menu on hotel id
	public List<NonVegMenu> getHotelNonVegMenu(int id);
}
