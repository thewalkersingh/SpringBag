package com.cn.rating.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

	private final Map<String, Long> ratingMap = new HashMap<>();

	public Long getRatingById(String id) { return ratingMap.get(id); }

	public void addRating(Map<String, Long> hotelRatingMap) { ratingMap.putAll(hotelRatingMap); }

	public Map<String, Long> getAllRating() { return ratingMap; }

	public void updateRating(Map<String, Long> hotelRatingMap) { ratingMap.putAll(hotelRatingMap); }

	public void deleteRating(String id) { ratingMap.remove(id); }
}
