package com.example.cnExpense.DAL;
import com.example.cnExpense.entities.Income;
import com.example.cnExpense.entities.User;

public interface IncomeDal {
	Income getIncomeById(Integer incomeid);
	
	Income saveIncome(User user, Income income);
}