package com.example.expense.DAL;
import com.example.expense.entities.Income;
import com.example.expense.entities.User;

public interface IncomeDal {
	Income getIncomeById(Integer incomeid);
	
	Income saveIncome(User user, Income income);
}