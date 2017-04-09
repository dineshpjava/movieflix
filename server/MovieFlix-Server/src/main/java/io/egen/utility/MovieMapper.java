package io.egen.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.egen.DTO.MovieDTO;
import io.egen.entity.Genre;
import io.egen.entity.Movie;
import io.egen.repository.MovieRepository;

@Component
public class MovieMapper {
	@Autowired
	private MovieRepository movieRepository;
	
	public Movie MovieDTOtoEntity(MovieDTO movieDTO){
		
		Movie movie = new Movie();
		
		movie.setId(movieDTO.getId());
		movie.setTitle(movieDTO.getTitle());
		movie.setYear(movieDTO.getYear());
		movie.setRated(movieDTO.getRated());
		movie.setReleased(movieDTO.getReleased());
		movie.setRuntime(movieDTO.getRuntime());
		
		List<Genre> genreList = new ArrayList<Genre>();
		for (String genreName : movieDTO.getGenre()) {
			genreList.add(movieRepository.findGenre(genreName));
		}
		movie.setGenre(genreList);
		
		movie.setDirector(movieDTO.getDirector());
		movie.setWriter(movieDTO.getWriter());
		movie.setActors(movieDTO.getActors());
		movie.setPlot(movieDTO.getPlot());
		movie.setLanguage(movieDTO.getLanguage());
		movie.setCountry(movieDTO.getCountry());
		movie.setMetascore(movieDTO.getMetascore());
		movie.setImdbRating(movieDTO.getImdbRating());
		movie.setImdbVotes(movieDTO.getImdbVotes());
		movie.setImdbID(movieDTO.getImdbID());
		movie.setType(movieDTO.getType());
		movie.setAwards(movieDTO.getAwards());
		movie.setPoster(movieDTO.getPoster());
		
		return movie;
	}
	
	public MovieDTO MovieEntityToDTO(Movie movie){
		MovieDTO movieDTO = new MovieDTO();
		movieDTO.setId(movie.getId());
		movieDTO.setTitle(movie.getTitle());
		movieDTO.setYear(movie.getYear());
		movieDTO.setRated(movie.getRated());
		movieDTO.setReleased(movie.getReleased());
		movieDTO.setRuntime(movie.getRuntime());

		List<Genre> genreList = movie.getGenre();
		List<String> genreNamesList = new ArrayList<String>();
		for (Genre genre : genreList) {
			genreNamesList.add(genre.getGenreName());
		}
		movieDTO.setGenre(genreNamesList);
		
		movieDTO.setDirector(movie.getDirector());
		movieDTO.setWriter(movie.getWriter());
		movieDTO.setActors(movie.getActors());
		movieDTO.setPlot(movie.getPlot());
		movieDTO.setLanguage(movie.getLanguage());
		movieDTO.setCountry(movie.getCountry());
		movieDTO.setMetascore(movie.getMetascore());
		movieDTO.setImdbRating(movie.getImdbRating());
		movieDTO.setImdbVotes(movie.getImdbVotes());
		movieDTO.setImdbID(movie.getImdbID());
		movieDTO.setType(movie.getType());
		movieDTO.setAwards(movie.getAwards());
		movieDTO.setPoster(movie.getPoster());
		return movieDTO;
	}	

	public List<Movie> MovieDTOtoEntity(List<MovieDTO> movieDTOList){
		List<Movie> movieList = new ArrayList<Movie>();
		for (MovieDTO movieDTO : movieDTOList) {
			movieList.add(MovieDTOtoEntity(movieDTO));
		}
		return movieList;
	}

	public List<MovieDTO> MovieEntityToDTO(List<Movie> movieReviewList){
		List<MovieDTO> movieDTOList = new ArrayList<MovieDTO>();
		for (Movie movie : movieReviewList) {
			movieDTOList.add(MovieEntityToDTO(movie));
		}
		return movieDTOList;
	}
}
