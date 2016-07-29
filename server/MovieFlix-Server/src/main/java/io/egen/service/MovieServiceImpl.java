package io.egen.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.entity.Movie;
import io.egen.exception.MovieAlreadyExistsException;
import io.egen.exception.MovieNotFoundException;
import io.egen.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public Movie findMovie(String id) {
		return movieRepository.findMovie(id);
	}

	@Override
	public List<Movie> findAllMovies() {
		return movieRepository.findAllMovies();
	}

	@Override
	@Transactional
	public Movie createMovie(Movie movie) {
		Movie existing = movieRepository.findMovieByName(movie.getTitle());
		if(existing==null)
			return movieRepository.createMovie(movie);
		throw new MovieAlreadyExistsException("Movie with name:" + movie.getTitle() + " already exists");
	}

	@Override
	@Transactional
	public Movie updateMovie(Movie movie) {
		Movie existing = movieRepository.findMovieByName(movie.getTitle());
		if(existing!=null)
			return movieRepository.updateMovie(movie);
		throw new MovieNotFoundException("Movie with name:" + movie.getTitle() + " is not found");
	}

	@Override
	@Transactional
	public Movie deleteMovie(String id) {
		Movie existing = movieRepository.findMovie(id);
		if(existing!=null)
			return movieRepository.deleteMovie(existing);
		throw new MovieNotFoundException("Movie with id:" + id + " is not found");
	}

	@Override
	public List<Movie> findTopRatedMovies() {
		List<Movie> movieList = findAllMovies();
		List<Movie> topMovies = new ArrayList<Movie>();
		Collections.sort(movieList);
		int index=0,count=10;
		while((count!=0)&&(index < movieList.size())){
			Movie curMovie = movieList.get(index);
			if((curMovie.getType()).equals("movie")){
				topMovies.add(curMovie);
				count--;
			}
			index++;
		}
		return topMovies;
	}

	@Override
	public List<Movie> findTopRatedSeries() {
		List<Movie> movieList = findAllMovies();
		List<Movie> topSeries = new ArrayList<Movie>();
		Collections.sort(movieList);
		int index=0,count=10;
		while((count!=0)&&(index < movieList.size())){
			Movie curSeries = movieList.get(index);
			if((curSeries.getType()).equals("series")){
				topSeries.add(curSeries);
				count--;
			}
			index++;
		}
		return topSeries;
	}
}
