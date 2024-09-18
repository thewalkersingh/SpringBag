package com.cn.cnEvent.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String name;
	@Column
	private long price;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "person_id")
	private Person person;
	@ManyToOne
	@JoinColumn(name = "event_id")
	@JsonBackReference
	private Event events;
	
	public Ticket() {}
	
	public Ticket(String name, long price, Person person, Event events) {
		this.name = name;
		this.price = price;
		this.person = person;
		this.events = events;
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
	
	public long getPrice() {
		return price;
	}
	
	public void setPrice(long price) {
		this.price = price;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Event getEvents() {
		return events;
	}
	
	public void setEvents(Event events) {
		this.events = events;
	}
}