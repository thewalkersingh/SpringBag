package com.example.cnExpense.DAL;
import com.example.cnExpense.entities.User;

import java.util.List;

public interface UserDal {
	List<User> getAllUsers();
	
	User getUserById(Integer id);
	
	void saveUser(User user);
	
	boolean checkUserExist(User user);
	
	List<User> filterUserListByCalendar(String day, String month, String year);
	
	List<User> filterUserListByType(String incomeType, String expenseType);
}