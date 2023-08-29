package com.app.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.entities.VegMenu;
import com.app.repositories.VegMenuRepository;
import com.app.services.VegMenuServiceInterface;

@Service
public class VegMenuService implements VegMenuServiceInterface {

	@Autowired
	private VegMenuRepository vegMenuRepository;

	@Override
	public List<VegMenu> getAllVegMenus() {
		return vegMenuRepository.findAll();
	}

	@Override
	public VegMenu getVegMenu(int id) {
		Optional<VegMenu> optional = vegMenuRepository.findById(id);
		VegMenu vegMenu = optional.get();
		return vegMenu;
	}

	@Override
	public VegMenu addNewVegMenu(VegMenu vegMenu) {
		vegMenu.setm_id(0);
		return vegMenuRepository.save(vegMenu);
	}

	@Override
	public VegMenu updateVegMenu(VegMenu vegMenu) {
		return vegMenuRepository.save(vegMenu);
	}

	@Override
	public String deleteVegMenu(int id) {
		vegMenuRepository.deleteById(id);
		return "Veg Menu Deleted";
	}

	@Override
	public List<VegMenu> getHotelVegMenu(int id) {
		// TODO Auto-generated method stub
		return vegMenuRepository.getHotelVegMenu(id);
	}

	
}
