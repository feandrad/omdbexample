package feandrad.ombdexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by feandrad on 09/02/2017.
 */
public class Movie implements Serializable {

	private final static long serialVersionUID = -2694916123125411453L;

	@Expose @SerializedName("Title") private String title;
	@Expose @SerializedName("Year") private String year;
	@Expose @SerializedName("Rated") private String rated;
	@Expose @SerializedName("Released") private String released;
	@Expose @SerializedName("Runtime") private String runtime;
	@Expose @SerializedName("Genre") private String genre;
	@Expose @SerializedName("Director") private String director;
	@Expose @SerializedName("Writer") private String writer;
	@Expose @SerializedName("Actors") private String actors;
	@Expose @SerializedName("Plot") private String plot;
	@Expose @SerializedName("Language") private String language;
	@Expose @SerializedName("Country") private String country;
	@Expose @SerializedName("Awards") private String awards;
	@Expose @SerializedName("Poster") private String posterUrl;
	@Expose @SerializedName("Metascore") private String metascore;
	@Expose @SerializedName("imdbRating") private String imdbRating;
	@Expose @SerializedName("imdbVotes") private String imdbVotes;
	@Expose @SerializedName("imdbID") private String imdbID;
	@Expose @SerializedName("Type") private String type;
	@Expose @SerializedName("totalSeasons") private String totalSeasons;
	@Expose @SerializedName("Response") private String response;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
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

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
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

	public String getPosterUrl() {
		return posterUrl;
	}

	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}

	public String getMetascore() {
		return metascore;
	}

	public void setMetascore(String metascore) {
		this.metascore = metascore;
	}

	public String getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}

	public String getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(String imdbVotes) {
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

	public String getTotalSeasons() {
		return totalSeasons;
	}

	public void setTotalSeasons(String totalSeasons) {
		this.totalSeasons = totalSeasons;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

}
