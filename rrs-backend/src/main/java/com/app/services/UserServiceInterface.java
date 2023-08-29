package com.app.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.entities.User;

public interface UserServiceInterface {
	
	//get all users
	public List<User> getAllUsers();
	
	//get specific user
	public User getUser(int id);
	
	//add new user
	public User addNewUser(User user);
	
	//update existing user
	public User updateUser(User user);
	
	//delete user
	public String deleteUser(int id);
	
	//login
	public User loginUser(User user);
}
