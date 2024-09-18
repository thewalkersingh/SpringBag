package com.example.patient_management_1.repository;

import com.example.patient_management_1.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}