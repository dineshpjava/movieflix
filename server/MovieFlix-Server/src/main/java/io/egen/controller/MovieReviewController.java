package io.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.DTO.ReviewDTO;
import io.egen.service.MovieReviewService;

@RestController
@RequestMapping(path="/reviews", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MovieReviewController {

		@Autowired
		private MovieReviewService movieReviewService;
		
/*		@RequestMapping(method = RequestMethod.GET, path="/{id}")
		public ReviewDTO findMovieReview(@PathVariable("id") String id){
			return movieReviewService.findOneReview(id);		
		}
*/		
		@RequestMapping(method = RequestMethod.GET, path="/{id}")
		public List<ReviewDTO> findAllMovieReviews(@PathVariable("id") String movieId){
			return movieReviewService.findAllReviews(movieId);
		}

/*		@RequestMapping(method = RequestMethod.GET, path="/top-movies")
		public List<Movie> findTopRatedMovies(){
			return movieReviewService.findTopRatedMovies();
		}

		@RequestMapping(method = RequestMethod.GET, path="/top-series")
		public List<Movie> findTopRatedSeries(){
			return movieReviewService.findTopRatedSeries();
		}
*/
		
		@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public ReviewDTO createMovieReview(@RequestBody ReviewDTO review){
			return movieReviewService.createReview(review);
		}
		
		@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public ReviewDTO updateMovieReview(@RequestBody ReviewDTO review){
			return movieReviewService.updateReview(review);		
		}
		
		@RequestMapping(method = RequestMethod.DELETE, path="/{id}")
		public ReviewDTO deleteMovieReview(@PathVariable("id") String id){
			return movieReviewService.deleteReview(id);
		}
}
