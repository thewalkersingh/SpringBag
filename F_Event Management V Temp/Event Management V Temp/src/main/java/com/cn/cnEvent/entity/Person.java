package com.cn.cnEvent.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String name;
	@Column
	private long age;
	//	@ManyToOne
//	@JoinColumn(name = "event_id", nullable = true)
//	@JsonBackReference
//	private Event event;
	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Ticket ticket;
	
	public Person() {
	}
	
	public Person(Ticket ticket, String name, long age) {
		this.ticket = ticket;
		this.name = name;
		this.age = age;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getAge() {
		return age;
	}
	
	public void setAge(long age) {
		this.age = age;
	}
	
	public Ticket getTicket() {
		return ticket;
	}
	
	public void setTicket(Ticket tickets) {
		this.ticket = tickets;
	}
}