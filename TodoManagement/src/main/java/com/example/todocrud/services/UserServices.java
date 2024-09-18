package com.example.todocrud.services;
import com.example.todocrud.entity.Users;
import com.example.todocrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices {
	@Autowired
	UserRepository userRepository;
	
	public Users getUserById(Long userId) {
		//write code
		Optional<Users> user = userRepository.findById(userId);
		return user.orElse(null);
	}
	
	public Users addUser(Users user) {
		// write code
		return userRepository.save(user);
	}
	
	public void deleteUser(Long userId) {
		Users users = getUserById(userId);
		userRepository.delete(users);
	}
	
	public void updateUser(Users user) {
		userRepository.save(user);
	}
}