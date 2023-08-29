package com.app.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.NonVegMenu;
import com.app.repositories.NonVegMenuRepository;
import com.app.services.NonVegMenuServiceInterface;

@Service
public class NonVegMenuService implements NonVegMenuServiceInterface {

	@Autowired
	private NonVegMenuRepository nonVegMenuRepository;

	@Override
	public List<NonVegMenu> getAllNonVegMenus() {
		return nonVegMenuRepository.findAll();
	}

	@Override
	public NonVegMenu getNonVegMenu(int id) {
		Optional<NonVegMenu> optional = nonVegMenuRepository.findById(id);
		NonVegMenu nonVegMenu = optional.get();
		return nonVegMenu;
	}

	@Override
	public NonVegMenu addNewNonVegMenu(NonVegMenu nonVegMenu) {
		nonVegMenu.setm_id(0);
		return nonVegMenuRepository.save(nonVegMenu);
	}

	@Override
	public NonVegMenu updateNonVegMenu(NonVegMenu nonVegMenu) {
		return nonVegMenuRepository.save(nonVegMenu);
	}

	@Override
	public String deleteNonVegMenu(int id) {
		nonVegMenuRepository.deleteById(id);
		return "Non Veg Menu Deleted";
	}

	@Override
	public List<NonVegMenu> getHotelNonVegMenu(int id) {
		// TODO Auto-generated method stub
		return nonVegMenuRepository.getHotelNonVegMenu(id);
	}


}
