package com.example.cnExpense.service;
import com.example.cnExpense.DAL.UserDal;
import com.example.cnExpense.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
	@Autowired
	private UserDal userDal;
	
	@Transactional
	public List<User> getAllUsers() {
		return userDal.getAllUsers();
	}
	
	@Transactional
	public User getUserById(Integer id) {
		return userDal.getUserById(id);
	}
	
	@Transactional
	public void saveUser(User user) {
		userDal.saveUser(user);
	}
	
	@Transactional
	public Boolean checkUserExist(User user) {
		return userDal.checkUserExist(user);
	}
	
	@Transactional
	public User findUser(User newUser) {
		return getUserById(newUser.getId());
	}
	
	@Transactional
	public List<User> filterUserListByCalendar(String day, String month, String year) {
		return userDal.filterUserListByCalendar(day, month, year);
	}
	
	@Transactional
	public List<User> filterUserListByType(String incomeType, String expenseType) {
		return userDal.filterUserListByType(incomeType, expenseType);
	}
}