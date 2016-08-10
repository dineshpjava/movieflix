package io.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.egen.DTO.MovieDTO;
import io.egen.service.MovieService;

@RestController
@RequestMapping(path="/movies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@RequestMapping(method = RequestMethod.GET, path="/{id}")
	public MovieDTO findMovie(@PathVariable("id") String id){
		return movieService.findMovie(id);		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<MovieDTO> findAllMovies(){
		return movieService.findAllMovies();
	}

	@RequestMapping(method = RequestMethod.GET, path="/genre")
	public List<MovieDTO> findMoviesByGenre(@RequestParam(value="genreName",required=true) String genreName){
		return movieService.findMovieByGenre(genreName);
	}
	

	@RequestMapping(method = RequestMethod.GET, path="/top")
	public List<MovieDTO> findAllMovies(@RequestParam(value="type",required=true) String type) {
		return movieService.findTopMovies(type);
	}

	@RequestMapping(method = RequestMethod.GET, path="/type")
	public List<MovieDTO> findByType(@RequestParam(value="type",required=true) String type) {
		return movieService.findTopMovies(type);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieDTO createMovie(@RequestBody MovieDTO movie){
		return movieService.createMovie(movie);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path="/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieDTO updateMovie(@RequestBody MovieDTO movie, @PathVariable("id") String id){
		return movieService.updateMovie(movie);		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path="/{id}")
	public MovieDTO deleteMovie(@PathVariable("id") String id){
		return movieService.deleteMovie(id);
	}
}
