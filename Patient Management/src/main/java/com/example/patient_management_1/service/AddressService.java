package com.example.patient_management_1.service;
import com.example.patient_management_1.entity.Address;
import com.example.patient_management_1.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;
	
	public Address getAddressById(Long id) {
		Optional<Address> addresses = addressRepository.findById(id);
		return addresses.orElse(null);
	}
	
	public void newAddress(Long patientId, Address address) {
	
	}
}