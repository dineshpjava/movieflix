package io.egen.service;

import java.util.List;

import io.egen.DTO.ReviewDTO;

public interface MovieReviewService {

	public ReviewDTO findOneReview(String id);

	public ReviewDTO createReview(ReviewDTO review);
	
	public ReviewDTO updateReview(ReviewDTO review);
	
	public ReviewDTO deleteReview(String id);
	
	public List<ReviewDTO> findAllReviews();
}
