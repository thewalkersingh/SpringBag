package com.example.expense.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "income_type")
public class IncomeType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String name;
	@ManyToOne
	@JoinColumn(name = "income_id")
	@JsonBackReference
	private Income income;
	
	public IncomeType() {}
	
	public IncomeType(String name, Income income) {
		this.name = name;
		this.income = income;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Income getIncome() {
		return income;
	}
	
	public void setIncome(Income income) {
		this.income = income;
	}
}