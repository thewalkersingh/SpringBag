package com.example.patient_management_1.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
	private Address address;
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	@JsonBackReference
	private Doctor doctor;
	
	public Patient() {
	}
	
	public Patient(Long id, String name, Address address, Doctor doctor) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.doctor = doctor;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}
	
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
}