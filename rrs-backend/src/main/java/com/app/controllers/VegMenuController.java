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
import com.app.entities.VegMenu;
import com.app.services.VegMenuServiceInterface;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class VegMenuController {

	@Autowired
	private VegMenuServiceInterface vegMenuServiceInterface;

	@GetMapping("/vegmenu")
	public List<VegMenu> getAllVegMenus() {
		return vegMenuServiceInterface.getAllVegMenus();
	}

	@GetMapping("/vegmenu/{id}")
	public VegMenu getVegMenu(@PathVariable int id) {
		return vegMenuServiceInterface.getVegMenu(id);
	}

	@PostMapping("/vegmenu/add")
	public VegMenu addNewVegMenu(@RequestBody VegMenu vegMenu) {
		return vegMenuServiceInterface.addNewVegMenu(vegMenu);
	}

	@PutMapping("/vegmenu/update")
	public VegMenu updateVegMenu(@RequestBody VegMenu vegMenu) {
		return vegMenuServiceInterface.updateVegMenu(vegMenu);
	}

	@DeleteMapping("/vegmenu/delete/{id}")
	public String deleteVegMenu(@PathVariable int id) {
		return vegMenuServiceInterface.deleteVegMenu(id);
	}

	// menu on hotel
	
	
	 @PostMapping("/veg-menu")
    public ResponseEntity<List<VegMenu>> getVegMenuForHotel(@RequestBody Hotel hotel) {
		 System.err.println(hotel);
		 System.err.println(hotel.getHotel_id());
        List<VegMenu> vegMenu = vegMenuServiceInterface.getHotelVegMenu(hotel.getHotel_id());
        return ResponseEntity.ok(vegMenu);
    }
	 
}
