package io.egen.service;

import java.util.List;

import io.egen.DTO.MovieDTO;

public interface MovieService {

	public MovieDTO findMovie(String id);
	
	public List<MovieDTO> findAllMovies();
	
	public List<MovieDTO> findMovieByGenre(String genreName);
	
	public List<MovieDTO> findTopMovies(String type);
	
	public List<MovieDTO> findByType(String type);
	
	public MovieDTO createMovie(MovieDTO movie);
	
	public MovieDTO updateMovie(MovieDTO movie);
	
	public MovieDTO deleteMovie(String id);

}
