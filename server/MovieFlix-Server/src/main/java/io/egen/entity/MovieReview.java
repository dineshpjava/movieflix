package io.egen.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "MovieReviews.findAll", query = "SELECT r FROM MovieReview r join r.movie m where m.id=:pId")
//	,@NamedQuery(name = "Movie.findByName", query = "SELECT m FROM Movie m WHERE m.title=:pTitle")
	})
public class MovieReview {

	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String reviewId;
	
	private String comment;
	
	private Integer rate;
	
	@ManyToOne
	private Movie movie;
	
	private String customerName;
	
	public String getReviewId() {
		return reviewId;
	}

	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

}
