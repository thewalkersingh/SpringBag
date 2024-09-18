package com.example.patient_management_1.controller;
import com.example.patient_management_1.entity.Address;
import com.example.patient_management_1.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/{id}")
	public Address getAddressById(@PathVariable Long id) {
		return addressService.getAddressById(id);
	}
	
	@PostMapping("/add/{patientId}")
	public void newAddress(@PathVariable Long patientId, @RequestBody Address address) {
		addressService.newAddress(patientId, address);
	}
	
	@PutMapping("/update")
	public void updateAddress(@RequestBody Address address) {
		addressService.updateAddressBy(address);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteAddress(@PathVariable Long id) {
		addressService.deleteAddress(id);
	}
}