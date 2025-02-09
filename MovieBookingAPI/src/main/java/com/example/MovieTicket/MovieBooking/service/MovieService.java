package com.example.MovieTicket.MovieBooking.service;
import com.example.MovieTicket.MovieBooking.Exceptions.IdAlreadyExist;
import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFound;
import com.example.MovieTicket.MovieBooking.Model.Movie;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieService implements MovieServiceInterface {
	
	private final List<Movie> movieList = new ArrayList<>();
	private final Map<String, Movie> movieMap = new HashMap<>();
	
	public void addMovie(Movie movie) {
		if (!ObjectUtils.isEmpty(movieMap.get(movie.getId())))
			throw new IdAlreadyExist("Movie with the id " + movie.getId() + " exist");
		movieList.add(movie);
		movieMap.put(movie.getId(), movie);
	}
	
	public Movie getMovieById(String id) {
		if (ObjectUtils.isEmpty(movieMap.get(id))) throw new IdNotFound("No Movie found with Id: " + id);
		return movieMap.get(id);
	}
	
	public List<Movie> getMovieList() {
		return movieList;
	}
	
	public void updateMovie(Movie movie) {
		Movie existingMovie = this.getMovieById(movie.getId());
		movieList.remove(existingMovie);
		movieMap.remove(existingMovie.getId());
		movieList.add(movie);
		movieMap.put(movie.getId(), movie);
	}
	
	public void deleteMovie(String id) {
		Movie movie = this.getMovieById(id);
		movieList.remove(movie);
		movieMap.remove(movie.getId());
	}
}