package com.example.expense.service;
import com.example.expense.DAL.IncomeDal;
import com.example.expense.entities.Income;
import com.example.expense.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class IncomeService {
	@Autowired
	private IncomeDal incomeDal;
	
	@Transactional
	public Income getIncomeById(Integer incomeid) {
		return incomeDal.getIncomeById(incomeid);
	}
	
	@Transactional
	public Income saveIncome(User user, Income income) {
		return incomeDal.saveIncome(user, income);
	}
}