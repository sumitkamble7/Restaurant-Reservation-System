package com.app.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.entities.User;
import com.app.repositories.UserRepository;
import com.app.services.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface {

	@Autowired
	private UserRepository userRepository;

	private List<User> userList = new ArrayList<>();

	@Override
	public List<User> getAllUsers() {
		userList = userRepository.findAll();
		return userList;
	}

	@Override
	public User getUser(int id) {
		Optional<User> optional = userRepository.findById(id);
		User user = optional.get();
		return user;
	}

	@Override
	public User addNewUser(User user) {
		user.setUser_id(0);
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		User newUser = userRepository.saveAndFlush(user);

		return newUser;
	}

	@Override
	public String deleteUser(int id) {
		userRepository.deleteById(id);
		return "user deleted";
	}

	@Override
	public User loginUser(User user) {
		User obj = userRepository.findByEmail(user.getEmail());
		return obj;
	}
}
