package com.example.patient_management_1.controller;
import com.example.patient_management_1.entity.Patient;
import com.example.patient_management_1.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	PatientService patientService;
	
	@GetMapping("/{id}")
	public Patient getPatient(@PathVariable Long id) {
		return patientService.getPatientById(id);
	}
	
	@PostMapping("/add")
	public void addPatient(@RequestBody Patient patient) {
		patientService.savePatient(patient);
	}
	
	@PutMapping("/update")
	public void updatePatient(@RequestBody Patient patient) {
		patientService.updatePatient(patient);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletePatient(@RequestParam Long id) {
		patientService.deletePatient(id);
	}
}