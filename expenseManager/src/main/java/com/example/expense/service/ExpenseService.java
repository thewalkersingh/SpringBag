package com.example.expense.service;
import com.example.expense.DAL.ExpenseDal;
import com.example.expense.entities.Expense;
import com.example.expense.entities.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ExpenseService {
	@Autowired
	private ExpenseDal expenseDal;
	
	@Transactional
	public Income saveExpense(Income income, Expense expense) {
		return expenseDal.saveExpense(income, expense);
	}
}