package com.einvoice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.einvoice.model.User;
import com.einvoice.repository.UserRepository;
import com.einvoice.repository.customerRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@PreAuthorize("hasRole('ADMIN')")
public class customerController {
	@Autowired
	customerRepository repository;
	
	@Autowired
	UserRepository userRepository;

	// Get all the list of the customer
	@GetMapping("/users")
	public List<User> getAllCustomer() {
		System.out.println("get all users...");

		List<User> _user = new ArrayList<>();

		userRepository.findAll().forEach(_user::add);

		return _user;
	}

	// create new Customer

	@PostMapping(value = "/users/create")
	public User postCustomer(@RequestBody User user) {

		User _user = userRepository.save(new User(user.getUsername(), user.getPassword(), user.getName(), user.getEmail(), user.getPhone(), user.getAddress()));
		return _user;
	}

	// detele a customer
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
		System.out.println("delete user with ID : " + id + "...");
		userRepository.deleteById(id);
		
		return new ResponseEntity<String>("User has been delete...", HttpStatus.OK);
	}
	
	@DeleteMapping("/users/delete")
	public ResponseEntity<String> deleteAllUser(){
		System.out.println("delete all user....");
		
		userRepository.deleteAll();
		
		return new ResponseEntity<String>("all the users has been deleted....", HttpStatus.OK);
	}
	
	@GetMapping("/users/username/{username}")
	public Optional<User> findByUsername(@PathVariable("username") String username){
		Optional<User> _user = userRepository.findByUsername(username);
		
		return _user;
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		System.out.println("Update user with ID = " + id + "...");

		Optional<User> userData = userRepository.findById(id);

		if (userData.isPresent()) {
			User _user = userData.get();
			_user.setUsername(user.getUsername());
			_user.setPassword(user.getPassword());
			_user.setName(user.getName());
			_user.setEmail(user.getEmail());
			_user.setPhone(user.getPhone());
			_user.setAddress(user.getAddress());
			_user.setActive(user.isActive());
			return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
