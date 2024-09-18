package com.example.cnExpense.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String username;
	@Column
	String nickname;
	@Column
	private String email;
	@Column
	private String address;
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Expense> expenses;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_income", joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "income_id"))
	private List<Income> incomes;
	
	public User(
			String username, String nickname, String email, String address, List<Expense> expenses,
			List<Income> incomes) {
		this.username = username;
		this.nickname = nickname;
		this.email = email;
		this.address = address;
		this.expenses = expenses;
		this.incomes = incomes;
	}
	
	public User() {}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<Expense> getExpenses() {
		return expenses;
	}
	
	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}
	
	public List<Income> getIncomes() {
		return incomes;
	}
	
	public void setIncomes(List<Income> incomes) {
		this.incomes = incomes;
	}
}