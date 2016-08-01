package io.egen.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.entity.Genre;
import io.egen.entity.Movie;

@Repository
public class MovieRepositoryImpl implements MovieRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Movie findMovie(String id) {
		return entityManager.find(Movie.class, id);
	}

	@Override
	public Movie findMovieByName(String title) {
		TypedQuery<Movie> query = entityManager.createNamedQuery("Movie.findByName", Movie.class);
		query.setParameter("pTitle", title);
		List<Movie> movies = query.getResultList();
		if (movies != null && movies.size() == 1) {
			return movies.get(0);
		}
		return null;
	}

	@Override
	public List<Movie> findAllMovies() {
		TypedQuery<Movie> query = entityManager.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}

	@Override
	public List<Movie> findTopMovies(String type) {
		TypedQuery<Movie> query = entityManager.createNamedQuery("Movie.findTopMovies", Movie.class);
		query.setParameter("pType", type);
		List<Movie> topMovies = query.getResultList();
		return topMovies;
	}

	@Override
	public List<Movie> findMovieByGenre(String genreName) {
		TypedQuery<Movie> query = entityManager.createNamedQuery("Movie.findByGenre", Movie.class);
		query.setParameter("pGenreName", genreName);
		return query.getResultList();
	}

	@Override
	public List<Movie> findByType(String type) {
		TypedQuery<Movie> query = entityManager.createNamedQuery("Movie.findByType", Movie.class);
		query.setParameter("pType", type);
		return query.getResultList();
	}
	
	@Override
	public Movie createMovie(Movie movie) {
		entityManager.persist(movie);
		return movie;
	}

	@Override
	public Movie updateMovie(Movie movie) {
		entityManager.merge(movie);
		return movie;
	}

	@Override
	public Movie deleteMovie(Movie movie) {
		entityManager.remove(movie);
		return movie;
	}

	@Override
	public Genre findGenre(String genreName) {
		Genre genre = entityManager.find(Genre.class, genreName);
		if(genre==null){
			genre = createGenre(genreName);
		}
		return genre;
	}
	
	private Genre createGenre(String genreName){
		Genre genre = new Genre(genreName);
		entityManager.persist(genre);
		return genre;
	}
}
