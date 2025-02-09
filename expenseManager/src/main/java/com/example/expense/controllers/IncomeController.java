package com.example.expense.controllers;
import com.example.expense.entities.Income;
import com.example.expense.entities.User;
import com.example.expense.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/incomes")
public class IncomeController {
	@Autowired
	private IncomeService incomeService;
	
	@GetMapping("/{incomeid}")
	public Income getIncomeById(@PathVariable Integer incomeid) {
		return incomeService.getIncomeById(incomeid);
	}
	
	@PostMapping("/save/{userId}")
	public Income saveIncome(@PathVariable Integer userId, @RequestBody Income income) {
		User user = new User();
		user.setId(userId);
		return incomeService.saveIncome(user, income);
	}
}