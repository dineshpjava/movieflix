package io.egen.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.egen.DTO.ReviewDTO;
import io.egen.entity.MovieReview;
import io.egen.repository.CustomerRespository;
import io.egen.repository.MovieRepository;

@Component
public class ReviewMapper {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private CustomerRespository customerRespository;

	
	public MovieReview ReviewDTOtoEntity(ReviewDTO review){
		MovieReview movieReview = new MovieReview();
		movieReview.setReviewId(review.getReviewId());
		movieReview.setComment(review.getComment());
		movieReview.setRate(review.getRate());
		movieReview.setCustomerName(review.getCustomerName());
		movieReview.setMovie(movieRepository.findMovie(review.getMovieId()));
		movieReview.setCustomer(customerRespository.findCustomer(review.getCustomerId()));
		return movieReview;
	}

	public ReviewDTO ReviewEntityToDTO(MovieReview movieReview){
		ReviewDTO review = new ReviewDTO();
		review.setReviewId(movieReview.getReviewId());
		review.setRate(movieReview.getRate());
		review.setComment(movieReview.getComment());
		review.setCustomerName(movieReview.getCustomerName());
		review.setMovieId(movieReview.getMovie().getId());
		review.setCustomerId(movieReview.getCustomer().getId());
		return review;
	}
	
	public List<ReviewDTO> ReviewEntityToDTO(List<MovieReview> movieReviewList){
		List<ReviewDTO> reviewList = new ArrayList<ReviewDTO>();
		for (MovieReview movieReview : movieReviewList) {
			ReviewDTO review = ReviewEntityToDTO(movieReview);
			reviewList.add(review);
		}
		return reviewList;
	}
}
