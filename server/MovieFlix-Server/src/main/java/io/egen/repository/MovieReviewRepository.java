package io.egen.repository;

import java.util.List;

import io.egen.entity.MovieReview;

public interface MovieReviewRepository {

	public MovieReview findOneReview(String id);

	public List<MovieReview> findAllReviews();
	
	public MovieReview createReview(MovieReview movieReview);
	
	public MovieReview updateReview(MovieReview movieReview);
	
	public MovieReview deleteReview(MovieReview movieReview);
	
}
