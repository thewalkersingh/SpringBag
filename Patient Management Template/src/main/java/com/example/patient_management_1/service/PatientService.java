package com.example.patient_management_1.service;
import com.example.patient_management_1.entity.Patient;
import com.example.patient_management_1.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {
	@Autowired
	private PatientRepository patientRepository;
	
	public Patient getPatientById(Long id) {
		Optional<Patient> patient = patientRepository.findById(id);
		return patient.orElse(null);
	}
	
	public void savePatient(Patient patient) {
		patientRepository.save(patient);
	}
	
	public void updatePatient(Patient patient) {
		patientRepository.save(patient);
	}
	
	public void deletePatient(Long id) {
		Patient patient = getPatientById(id);
		patientRepository.delete(patient);
	}
}