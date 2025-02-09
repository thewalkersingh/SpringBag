package com.codingninjas.EVotingSystem.services;
import com.codingninjas.EVotingSystem.entities.User;
import com.codingninjas.EVotingSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User findUserByName(String name) {
		return userRepository.findByName(name).orElse(null);
	}
}