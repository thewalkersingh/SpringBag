package com.example.MovieTicket.MovieBooking.Model;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@EntityScan
public class Movie {

	@Size(min = 1)
	private String id;
	@Size(min = 3, max = 20)
	private String movieName;
	@NotNull
	private String movieDirector;
	@Min(1)
	@Max(10)
	private long movieRating;
	private String movieLanguage;
	private List<String> writers;
	private List<String> actors;
	private List<String> genre;

	public Movie() {
	}

	public Movie(
			String id, String movieName, String movieDirector, long movieRating, String movieLanguage,
			List<String> writers, List<String> actors, List<String> genre) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.movieDirector = movieDirector;
		this.movieRating = movieRating;
		this.movieLanguage = movieLanguage;
		this.writers = writers;
		this.actors = actors;
		this.genre = genre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public long getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(long movieRating) {
		this.movieRating = movieRating;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public List<String> getWriters() {
		return writers;
	}

	public void setWriters(List<String> writers) {
		this.writers = writers;
	}

	public List<String> getActors() {
		return actors;
	}

	public void setActors(List<String> actors) {
		this.actors = actors;
	}

	public List<String> getGenre() {
		return genre;
	}

	public void setGenre(List<String> genre) {
		this.genre = genre;
	}
}