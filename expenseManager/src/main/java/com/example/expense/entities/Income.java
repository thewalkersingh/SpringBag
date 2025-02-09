package com.example.expense.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "income")
public class Income {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private double amount;
	@Column
	private LocalDate date;
	@Column
	private String description;
	@OneToOne()
	@JoinColumn(name = "expense_id")
	@JsonManagedReference
	private Expense expense;
	@ManyToMany(mappedBy = "incomes")
	@JsonBackReference
	@JsonIgnore
	private List<User> users;
	@OneToMany(mappedBy = "income", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JsonIgnore
	@JsonManagedReference
	private List<IncomeType> incomeTypes;
	
	public Income() {}
	
	public Income(
			double amount, LocalDate date, String description, Expense expense, List<User> users,
			List<IncomeType> incomeTypes) {
		this.amount = amount;
		this.date = date;
		this.description = description;
		this.expense = expense;
		this.users = users;
		this.incomeTypes = incomeTypes;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Expense getExpense() {
		return expense;
	}
	
	public void setExpense(Expense expense) {
		this.expense = expense;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public List<IncomeType> getIncomeTypes() {
		return incomeTypes;
	}
	
	public void setIncomeTypes(List<IncomeType> incomeTypes) {
		this.incomeTypes = incomeTypes;
	}
}