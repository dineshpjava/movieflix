package io.egen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.DTO.MovieDTO;
import io.egen.entity.Movie;
import io.egen.exception.MovieAlreadyExistsException;
import io.egen.exception.MovieNotFoundException;
import io.egen.repository.MovieRepository;
import io.egen.utility.MovieMapper;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private MovieMapper mapper;
	
	@Override
	public MovieDTO findMovie(String id) {
		
		return mapper.MovieEntityToDTO(movieRepository.findMovie(id));
	}

	@Override
	public List<MovieDTO> findAllMovies() {
		return mapper.MovieEntityToDTO(movieRepository.findAllMovies());
	}

	@Override
	public List<MovieDTO> findMovieByGenre(String genreName) {
		return  mapper.MovieEntityToDTO(movieRepository.findMovieByGenre(genreName));
	}

	@Override
	public List<MovieDTO> findByType(String type) {
		return  mapper.MovieEntityToDTO(movieRepository.findByType(type));
	}

	@Override
	public List<MovieDTO> findTopMovies(String type) {
		return  mapper.MovieEntityToDTO(movieRepository.findTopMovies(type));
	}

	@Override
	@Transactional
	public MovieDTO createMovie(MovieDTO movieDTO) {
		Movie existing = movieRepository.findMovieByName(movieDTO.getTitle());
		if(existing==null){
			Movie movie = mapper.MovieDTOtoEntity(movieDTO);
			return mapper.MovieEntityToDTO(movieRepository.createMovie(movie));
		}
		throw new MovieAlreadyExistsException("Movie with name:" + existing.getTitle() + " already exists");
	}

	@Override
	@Transactional
	public MovieDTO updateMovie(MovieDTO movieDTO) {
		Movie existing = movieRepository.findMovieByName(movieDTO.getTitle());
		if(existing!=null){
			Movie movie = mapper.MovieDTOtoEntity(movieDTO);
			return mapper.MovieEntityToDTO(movieRepository.updateMovie(movie));			
		}
		throw new MovieNotFoundException("Movie with name:" + movieDTO.getTitle() + " is not found");
	}

	@Override
	@Transactional
	public MovieDTO deleteMovie(String id) {
		Movie existing = movieRepository.findMovie(id);
		if(existing!=null){
			return mapper.MovieEntityToDTO(movieRepository.deleteMovie(existing));
		}
		throw new MovieNotFoundException("Movie with id:" + id + " is not found");
	}
}
