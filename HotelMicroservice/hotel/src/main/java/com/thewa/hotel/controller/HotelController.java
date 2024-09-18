package com.thewa.hotel.controller;
import com.thewa.hotel.exception.BadRequestException;
import com.thewa.hotel.model.Hotel;
import com.thewa.hotel.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	HotelService hotelService;
	
	@PostMapping("/create")
	public void createHotel(@Valid @RequestBody Hotel hotel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) throw new BadRequestException("Request Not Valid");
		hotelService.createHotel(hotel);
	}
	
	@GetMapping("/id/{id}")
	public Hotel getHotelById(@PathVariable String id) {
		// REST service to fetch the rating by id
		return hotelService.getHotelById(id);
	}
	
	@GetMapping("/getAll")
	public List<Hotel> getAllHotels() {
		return hotelService.getAllHotel();
	}
	
	@DeleteMapping("/remove/id/{id}")
	public void deleteHotelById(@PathVariable String id) {
		hotelService.deleteHotelById(id);
	}
	
	@PutMapping("/update")
	public void updateHotel(@RequestBody Hotel hotel) {
		hotelService.updateHotel(hotel);
	}
}