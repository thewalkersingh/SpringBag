package com.codingninjas.EVotingSystem.controllers;
import com.codingninjas.EVotingSystem.entities.User;
import com.codingninjas.EVotingSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/add/user")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@GetMapping("/get/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
}