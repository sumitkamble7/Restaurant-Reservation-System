package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.app.entities.HotelOwner;
import com.app.entities.User;
import com.app.services.HotelOwnerServiceInterface;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class HotelOwnerController {
	
	@Autowired
	private HotelOwnerServiceInterface hotelOwnerServiceInterface;
	
	@GetMapping("/owners")
	public List<HotelOwner> getAllOwners() {
		
		return hotelOwnerServiceInterface.getAllOwners();
	}

	@GetMapping("/owners/{id}")
	public HotelOwner getOwner(@PathVariable int id) {
		return hotelOwnerServiceInterface.getOwner(id);
	}

	@PostMapping("/owners/add")
	public HotelOwner addNewOwner(@RequestBody HotelOwner hotelOwner) {
		return hotelOwnerServiceInterface.addNewOwner(hotelOwner);
	}

	@PutMapping("/owners/update")
	public HotelOwner updateOwner(@RequestBody HotelOwner hotelOwner) {
		return hotelOwnerServiceInterface.updateOwner(hotelOwner);
	}

	@DeleteMapping("/owners/delete/{id}")
	public String deleteOwner(@PathVariable int id) {
		return hotelOwnerServiceInterface.deleteOwner(id);
	}
	 @PostMapping("/owners/login")
	    public ResponseEntity<?> loginHotelOwner(@RequestBody HotelOwner HotelOwner) {
	        // Find the HotelOwner by email in the database
		 HotelOwner obj = hotelOwnerServiceInterface.loginHotelOwner(HotelOwner);
	        
	        if (obj == null) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
	        }
	        
	        // Check if the provided password matches the stored password
	        if (obj.getPassword().equals(HotelOwner.getPassword())) {
	            // Return a success message or a token for authentication
	        	return ResponseEntity.ok(obj);
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
	        }
	    }

}
