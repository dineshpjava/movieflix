package io.egen.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m ORDER BY m.imdbRating ASC"),
	@NamedQuery(name = "Movie.findByName", query = "SELECT m FROM Movie m WHERE m.title=:pTitle"),
	@NamedQuery(name = "Movie.findTopMovies", query = "SELECT m FROM Movie m WHERE m.type=:pType ORDER BY m.imdbRating DESC "),
	@NamedQuery(name = "Movie.findByType", query = "SELECT m FROM Movie m WHERE m.type=:pType"),
	@NamedQuery(name = "Movie.findByYear", query = "SELECT m FROM Movie m ORDER BY m.year DESC"),
	@NamedQuery(name = "Movie.findByType", query = "SELECT m FROM Movie m ORDER BY m.imdbVotes DESC"),
	@NamedQuery(name = "Movie.findByGenre", query = "select m from Movie m join m.genre g where g.genreName =:pGenreName)")
	})
public class Movie implements Comparable<Movie> {
	 
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;
	
	private String title;
	private Integer year;
	private String rated;
	private String released;
	private Integer runtime;
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Genre> genre;
	
	private String director;
	private String writer;
	private String actors;
	private String plot;
	private String language;
	private String country;
	private String awards;
	private String poster;
	private Integer metascore;
	private Float imdbRating;
	private Long imdbVotes;
	private String imdbID;
	private String type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public Integer getRuntime() {
		return runtime;
	}

	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}

	public List<Genre> getGenre() {
		return genre;
	}

	public void setGenre(List<Genre> genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Integer getMetascore() {
		return metascore;
	}

	public void setMetascore(Integer metascore) {
		this.metascore = metascore;
	}

	public Float getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(Float imdbRating) {
		this.imdbRating = imdbRating;
	}

	public Long getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(Long imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int compareTo(Movie movie) {		
		return (movie.imdbRating).compareTo(this.imdbRating);
	}
}
