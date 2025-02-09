package com.example.expense.controllers;
import com.example.expense.entities.User;
import com.example.expense.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/allUsers")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Integer id) {
		return userService.getUserById(id);
	}
	
	@PostMapping("/save")
	public void saveUser(@RequestBody User user) {
		userService.saveUser(user);
	}
	
	@PostMapping("/checkUserExist")
	public Boolean checkUserExist(@RequestBody User user) {
		return userService.checkUserExist(user);
	}
	
	@PostMapping("/find")
	@ResponseBody
	public User findUser(@RequestBody User newUser) {
		return userService.findUser(newUser);
	}
	
	@GetMapping("/filteredUserListByCalendar")
	public List<User> fetchUserListByCalendar(
			@RequestParam(value = "day", required = false) String day,
			@RequestParam(value = "month", required = false) String month,
			@RequestParam(value = "year", required = false) String year) {
		return userService.filterUserListByCalendar(day, month, year);
	}
	
	@GetMapping("filteredUserListByType")
	public List<User> filterUserListByType(
			@RequestParam(value = "incomeType", required = false) String incomeType,
			@RequestParam(value = "expenseType", required = false) String expenseType) {
		return userService.filterUserListByType(incomeType, expenseType);
	}
}