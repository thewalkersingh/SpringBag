package com.example.patient_management_1.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String speciality;
	@OneToMany(mappedBy = "doctor_id")
	@JsonManagedReference
	private List<Patient> patient;
	
	public Doctor() {
	}
	
	public Doctor(Long id, String name, String speciality, List<Patient> patient) {
		this.id = id;
		this.name = name;
		this.speciality = speciality;
		this.patient = patient;
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
	
	public String getSpeciality() {
		return speciality;
	}
	
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	public List<Patient> getPatient() {
		return patient;
	}
	
	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}
}