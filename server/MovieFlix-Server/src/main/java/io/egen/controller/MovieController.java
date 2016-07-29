package io.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.entity.Movie;
import io.egen.service.MovieService;

@RestController
@RequestMapping(path="/movies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@RequestMapping(method = RequestMethod.GET, path="/{id}")
	public Movie findMovie(@PathVariable("id") String id){
		return movieService.findMovie(id);		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Movie> findAllMovies(){
		return movieService.findAllMovies();
	}

	@RequestMapping(method = RequestMethod.GET, path="/top-movies")
	public List<Movie> findTopRatedMovies(){
		return movieService.findTopRatedMovies();
	}

	@RequestMapping(method = RequestMethod.GET, path="/top-series")
	public List<Movie> findTopRatedSeries(){
		return movieService.findTopRatedSeries();
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie createMovie(@RequestBody Movie movie){
		return movieService.createMovie(movie);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path="/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie updateMovie(@RequestBody Movie movie, @PathVariable("id") String id){
		return movieService.updateMovie(movie);		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path="/{id}")
	public Movie deleteMovie(@PathVariable("id") String id){
		return movieService.deleteMovie(id);
	}
}
