package io.egen.repository;

import java.util.List;

import io.egen.entity.Movie;

public interface MovieRepository {

	public Movie findMovie(String id);
	
	public Movie findMovieByName(String title);
	
	public List<Movie> findAllMovies();
	
	public Movie createMovie(Movie movie);
	
	public Movie updateMovie(Movie movie);
	
	public Movie deleteMovie(Movie movie);

}
