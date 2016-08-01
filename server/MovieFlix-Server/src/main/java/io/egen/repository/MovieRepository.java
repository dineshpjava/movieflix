package io.egen.repository;

import java.util.List;

import io.egen.entity.Genre;
import io.egen.entity.Movie;

public interface MovieRepository {

	public Movie findMovie(String id);
	
	public Movie findMovieByName(String title);
	
	public List<Movie> findMovieByGenre(String genreName);

	public List<Movie> findByType(String type);
	
	public List<Movie> findAllMovies();
	
	public List<Movie> findTopMovies(String type);

	public Movie createMovie(Movie movie);
	
	public Movie updateMovie(Movie movie);
	
	public Movie deleteMovie(Movie movie);
	
	public Genre findGenre(String genreName);

}
