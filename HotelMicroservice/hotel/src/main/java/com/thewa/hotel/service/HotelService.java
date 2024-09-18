package com.thewa.hotel.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import com.thewa.hotel.communicator.RatingServiceCommunicator;
import com.thewa.hotel.exception.HotelNotFoundException;
import com.thewa.hotel.model.Hotel;

@Service
public class HotelService {
	
	List<Hotel> hotelList = new ArrayList<>();
	Map<String, Hotel> hotelMap = new HashMap<>();
	@Autowired
	RatingServiceCommunicator ratingServiceCommunicator;
	
	public void createHotel(Hotel hotel) {
		// add a condition to check if an id is already present or not
		Map<String, Long> ratingsMap = new HashMap<>();
		hotelList.add(hotel);
		hotelMap.put(hotel.getId(), hotel);
		ratingsMap.put(hotel.getId(), hotel.getRating());
		ratingServiceCommunicator.addRating(ratingsMap);
		System.out.println("Hotel is added");
	}
	
	public Hotel getHotelById(String id) {
		if (ObjectUtils.isEmpty(hotelMap.get(id))) {
			throw new HotelNotFoundException("Hotel not Found for id: " + id);
		}
		Hotel hotel = hotelMap.get(id);
		long updateRating = ratingServiceCommunicator.getRating(id);
		hotel.setRating(updateRating);
		return hotel;
	}
	
	public List<Hotel> getAllHotel() {return hotelList;}
	
	public void deleteHotelById(String id) {
		Hotel removeHotel = getHotelById(id);
		hotelList.remove(removeHotel);
		hotelMap.remove(id);
		ratingServiceCommunicator.deleteRating(id);
	}
	
	public void updateHotel(Hotel updatedHotel) {
		String previousId = updatedHotel.getId();
		Hotel existingHotel = getHotelById(previousId);
		hotelList.remove(existingHotel);
		hotelList.add(updatedHotel);
		// update the map
		hotelMap.put(previousId, updatedHotel);
		Map<String, Long> updatedRating = new HashMap<>();
		updatedRating.put(updatedHotel.getId(), updatedHotel.getRating());
		ratingServiceCommunicator.updateRating(updatedRating);
	}
}