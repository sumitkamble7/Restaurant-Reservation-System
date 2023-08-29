package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.app.entities.NonVegMenu;
import com.app.entities.VegMenu;
import com.app.services.NonVegMenuServiceInterface;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class NonVegMenuController {
	
	@Autowired
	private NonVegMenuServiceInterface nonVegMenuServiceInterface;
	
	@GetMapping("/nonveg")
	public List<NonVegMenu> getAllNonVegMenus() {
		
		return nonVegMenuServiceInterface.getAllNonVegMenus();
	}

	@GetMapping("/nonveg/{id}")
	public NonVegMenu getNonVegMenu(@PathVariable int id) {
		
		return nonVegMenuServiceInterface.getNonVegMenu(id);
	}

	@PostMapping("/nonveg/add")
	public NonVegMenu addNewNonVegMenu(@RequestBody NonVegMenu nonVegMenu) {
		return nonVegMenuServiceInterface.addNewNonVegMenu(nonVegMenu);
	}

	@PutMapping("/nonveg/update")
	public NonVegMenu updateNonVegMenu(@RequestBody NonVegMenu nonVegMenu) {
		return nonVegMenuServiceInterface.updateNonVegMenu(nonVegMenu);
	}

	@DeleteMapping("/nonveg/delete/{id}")
	public String deleteNonVegMenu(@PathVariable int id) {
		return nonVegMenuServiceInterface.deleteNonVegMenu(id);
	}
	
	//nonveg hotel menu

	@PostMapping("/non-veg-menu")
    public ResponseEntity<List<NonVegMenu>> getNonVegMenuForHotel(@RequestBody Hotel hotel) {
		 System.err.println(hotel);
		 System.err.println(hotel.getHotel_id());
        List<NonVegMenu> nonVegMenu = nonVegMenuServiceInterface.getHotelNonVegMenu(hotel.getHotel_id());
        return ResponseEntity.ok(nonVegMenu);
    }
	 
}
