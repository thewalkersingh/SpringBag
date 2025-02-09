package com.example.expense.DAL;
import com.example.expense.entities.Expense;
import com.example.expense.entities.Income;

public interface ExpenseDal {
	Income saveExpense(Income income, Expense expense);
}