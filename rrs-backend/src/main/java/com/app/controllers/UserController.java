package com.app.controllers;

import java.util.ArrayList;
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

import com.app.entities.User;
import com.app.services.UserServiceInterface;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class UserController {

	@Autowired(required = true)
	private UserServiceInterface userServiceInterface;

	private List<User> userList = new ArrayList<>();


	@GetMapping("/users")
	public List<User> getAllUsers() {
		userList = userServiceInterface.getAllUsers();
		return userList;
	}

	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		User user = userServiceInterface.getUser(id);
		return user;
	}

	@PostMapping("/users/register")
	public User addNewUser(@RequestBody User user) {
		User newUser = userServiceInterface.addNewUser(user);
		return newUser;
	}

	@PutMapping("/users/update")
	public User updateUser(@RequestBody User user) {
		User newUser = userServiceInterface.updateUser(user);
		return newUser;
	}

	@DeleteMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		return userServiceInterface.deleteUser(id);
	}
	
	
	 
	 @PostMapping("/users/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        // Find the user by email in the database
        User obj = userServiceInterface.loginUser(user);
        
        if (obj == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
        }
        
        // Check if the provided password matches the stored password
        if (obj.getPassword().equals(user.getPassword())) {
            // Return a success message or a token for authentication
        	return ResponseEntity.ok(obj);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
        }
    }
	 
	

}
