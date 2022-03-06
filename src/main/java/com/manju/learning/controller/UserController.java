package com.manju.learning.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manju.learning.model.UserDetails;
import com.manju.learning.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello Manju";
	}
	
	@GetMapping("/listAllUsers")
	public List<UserDetails> listAllUsers() {
		return userRepository.findAll();
	}
	
	@PostMapping("/saveUsers")
	public List<UserDetails> saveUsers() {
		
		List<UserDetails> users = new ArrayList<>();
		for( int i=1;i<=5;i++) {
			UserDetails user = new UserDetails();
			user.setId(i);
			user.setName("User " + i);
			user.setGender("male");
			users.add(user);
		}
		return userRepository.saveAll(users);
	}
	
	
	@GetMapping("/findUser/{userId}")
	public Optional<UserDetails> findUser(@PathVariable Integer userId) {
		return userRepository.findById(userId);
	}
	
	@PutMapping("/deleteUser/{userId}")
	public void deleteUser(@PathVariable Integer userId) {
		 userRepository.deleteById(userId);
	}


}
