package io.egen.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.entity.MovieReview;

@Repository
public class MovieReviewRepositoryImpl implements MovieReviewRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public MovieReview findOneReview(String id) {
		return entityManager.find(MovieReview.class, id);
	}

	@Override
	public List<MovieReview> findAllReviews(String movieId) {
		TypedQuery<MovieReview> query = entityManager.createNamedQuery("MovieReviews.findAll", MovieReview.class);
		query.setParameter("pId", movieId);
		List<MovieReview> movieReviews = query.getResultList();
		return movieReviews;
	}

	@Override
	public MovieReview createReview(MovieReview movieReview) {
		entityManager.persist(movieReview);
		return movieReview;
	}

	@Override
	public MovieReview updateReview(MovieReview movieReview) {
		entityManager.merge(movieReview);
		return movieReview;
	}

	@Override
	public MovieReview deleteReview(MovieReview movieReview) {
		entityManager.remove(movieReview);
		return movieReview;
	}
}
