package com.example.MovieTicket.MovieBooking.controller;
import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@PostMapping("/movie")
	public void createMovie(@Valid @RequestBody Movie movie, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) throw new RuntimeException("Data provided is Invalid");
		movieService.addMovie(movie);
	}
	
	@GetMapping("/movie/{id}")
	public Movie getMovieById(@PathVariable String id) {
		return movieService.getMovieById(id);
	}
	
	@GetMapping("/movies")
	public List<Movie> getAllMovies() {
		return movieService.getMovieList();
	}
	
	@PutMapping("/update/{id}")
	public void updateMovie(@Valid @RequestBody Movie movie, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) throw new RuntimeException("Invalid Id");
		movieService.updateMovie(movie);
	}
	
	@DeleteMapping("/movie/{id}")
	public void deleteMovie(@PathVariable String id) {
		movieService.deleteMovie(id);
	}
}