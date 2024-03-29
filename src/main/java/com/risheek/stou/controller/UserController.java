package com.risheek.stou.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.risheek.stou.model.User;
import com.risheek.stou.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController { 

	private final UserService userService;
	
    public UserController(UserService userService) {
        this.userService = userService;
    }
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		System.out.println("Register User: " + user);
		return userService.createUser(user);
	}
	
	@PostMapping("/authenticate")
	public boolean authenticateUser(@RequestBody User user) {
		System.out.println("User: " + user);
		return userService.authenticateUser(user);
	}
	
	@GetMapping("/{email}/{role}")
	public User getUserByEmailAndRole(@PathVariable String email, @PathVariable Integer role) {
		System.out.println("Get by email and role: Email: " + email + "Role: " + role);
		return userService.getUser(email, role);
	}
}
