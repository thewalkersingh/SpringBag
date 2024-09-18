package com.thewa.hotel.communicator;
import com.thewa.hotel.exception.HttpRatingServiceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class RatingServiceCommunicator {
	private final RestTemplate restTemplate;
	private final String ratingUrl = "http://localhost:8081/rating/";
	
	@Autowired
	public RatingServiceCommunicator(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	public long getRating(String id) {
		String url = ratingUrl + "id/";
//		ResponseEntity<Long> response = restTemplate.getForEntity(url + id, Long.class);
		Long ratingResponse = restTemplate.getForObject(url + id, Long.class);
		return ratingResponse;
	}
	
	public void addRating(Map<String, Long> ratingsMap) {
		String url = ratingUrl + "add";
//		restTemplate.postForObject(url, ratingsMap, Object.class);  //or the below exchange method
		HttpEntity<Map<String, Long>> requestEntity = new HttpEntity<>(ratingsMap);
		restTemplate.exchange(url, HttpMethod.POST, requestEntity, Object.class);
	}
	
	public void updateRating(Map<String, Long> ratingsMap) {
		String url = "http://localhost:8081/rating/update";
		HttpEntity<Map<String, Long>> requestEntity = new HttpEntity<>(ratingsMap);
		restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Object.class);
	}
	
	public void deleteRating(String id) {
		String url = ratingUrl + "id/";
		try {
			restTemplate.exchange(url + id, HttpMethod.DELETE, null, Object.class);
		} catch (HttpClientErrorException exception) {
			throw new HttpRatingServiceNotFound(HttpStatusCode.valueOf(HttpStatus.NOT_FOUND.value()));
		}
	}
}