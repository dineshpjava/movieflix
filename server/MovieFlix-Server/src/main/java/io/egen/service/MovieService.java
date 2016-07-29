package io.egen.service;

import java.util.List;

import io.egen.entity.Movie;

public interface MovieService {

	public Movie findMovie(String id);
	
	public List<Movie> findAllMovies();
	
	public List<Movie> findTopRatedMovies();	
	
	public List<Movie> findTopRatedSeries();	
	
	public Movie createMovie(Movie movie);
	
	public Movie updateMovie(Movie movie);
	
	public Movie deleteMovie(String id);

}
