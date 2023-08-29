package com.app.services;

import java.util.List;


import com.app.entities.VegMenu;


public interface VegMenuServiceInterface {

	// get all VegMenu
	public List<VegMenu> getAllVegMenus();

	// get specific VegMenu
	public VegMenu getVegMenu(int id);

	// add new VegMenu
	public VegMenu addNewVegMenu(VegMenu vegMenu);

	// update existing VegMenu
	public VegMenu updateVegMenu(VegMenu vegMenu);

	// delete VegMenu
	public String deleteVegMenu(int id);
	
	//veg menu on hotel id 
	public List<VegMenu> getHotelVegMenu(int id);
}
