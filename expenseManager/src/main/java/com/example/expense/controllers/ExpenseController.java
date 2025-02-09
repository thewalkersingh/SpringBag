package com.example.expense.controllers;
import com.example.expense.entities.Expense;
import com.example.expense.entities.Income;
import com.example.expense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
  @Autowired
  private ExpenseService expenseService;
  
  @PostMapping("/save/{incomeId}")
  @ResponseBody
  public Income saveExpense(@PathVariable Integer incomeId, @RequestBody Expense expense) {
	Income income = new Income();
	income.setId(incomeId);
	return expenseService.saveExpense(income, expense);
  }
}