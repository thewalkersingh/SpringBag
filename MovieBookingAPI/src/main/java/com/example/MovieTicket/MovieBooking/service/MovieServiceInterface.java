package com.example.MovieTicket.MovieBooking.service;
import com.example.MovieTicket.MovieBooking.Model.Movie;

import java.util.List;

public interface MovieServiceInterface {
	
	public void addMovie(Movie movie);
	
	public Movie getMovieById(String id);
	
	public List<Movie> getMovieList();
	
	public void updateMovie(Movie movie);
	
	public void deleteMovie(String id);
}