package com.example.patient_management_1.repository;

import com.example.patient_management_1.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}