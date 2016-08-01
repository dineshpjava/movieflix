package io.egen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.DTO.ReviewDTO;
import io.egen.entity.MovieReview;
import io.egen.exception.MovieReviewNotFound;
import io.egen.repository.MovieReviewRepository;
import io.egen.utility.ReviewMapper;

@Service
public class MovieReviewServiceImpl implements MovieReviewService{

	@Autowired
	private MovieReviewRepository movieReviewRepository;
	
	@Autowired
	private ReviewMapper mapper; 
	
	@Override
	public ReviewDTO findOneReview(String id) {
		movieReviewRepository.findOneReview(id);
		return null;
	}

	@Override
	public List<ReviewDTO> findAllReviews() {
		return mapper.ReviewEntityToDTO(movieReviewRepository.findAllReviews());
	}

	@Override
	@Transactional
	public ReviewDTO createReview(ReviewDTO review) {
		MovieReview movieReview = mapper.ReviewDTOtoEntity(review);
		return mapper.ReviewEntityToDTO(movieReviewRepository.createReview(movieReview));
	}

	@Override
	@Transactional
	public ReviewDTO updateReview(ReviewDTO review) {
		MovieReview existing = movieReviewRepository.findOneReview(review.getReviewId());
		if(existing!=null){
			MovieReview movieReview = mapper.ReviewDTOtoEntity(review);
			return mapper.ReviewEntityToDTO(movieReviewRepository.updateReview(movieReview));
		}
		throw new MovieReviewNotFound("Movie review with id:" + review.getReviewId() + " isn't found");
	}

	@Override
	@Transactional
	public ReviewDTO deleteReview(String id) {
		MovieReview existing = movieReviewRepository.findOneReview(id);
		if(existing!=null){
			return mapper.ReviewEntityToDTO(movieReviewRepository.deleteReview(existing));
		}
		throw new MovieReviewNotFound("Movie review with id:" + id + " isn't found");
}
}