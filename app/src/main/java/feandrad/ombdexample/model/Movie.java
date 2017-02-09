package feandrad.ombdexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by feandrad on 09/02/2017.
 */
public class Movie implements Serializable {

	private final static long serialVersionUID = -2694916123125411453L;

	@Expose @SerializedName("Title") public String title;
	@Expose @SerializedName("Year") public String year;
	@Expose @SerializedName("Rated") public String rated;
	@Expose @SerializedName("Released") public String released;
	@Expose @SerializedName("Runtime") public String runtime;
	@Expose @SerializedName("Genre") public String genre;
	@Expose @SerializedName("Director") public String director;
	@Expose @SerializedName("Writer") public String writer;
	@Expose @SerializedName("Actors") public String actors;
	@Expose @SerializedName("Plot") public String plot;
	@Expose @SerializedName("Language") public String language;
	@Expose @SerializedName("Country") public String country;
	@Expose @SerializedName("Awards") public String awards;
	@Expose @SerializedName("Poster") public String poster;
	@Expose @SerializedName("Metascore") public String metascore;
	@Expose @SerializedName("imdbRating") public String imdbRating;
	@Expose @SerializedName("imdbVotes") public String imdbVotes;
	@Expose @SerializedName("imdbID") public String imdbID;
	@Expose @SerializedName("Type") public String type;
	@Expose @SerializedName("totalSeasons") public String totalSeasons;
	@Expose @SerializedName("Response") public String response;

	public Movie withTitle(String title) {
		this.title = title;
		return this;
	}

	public Movie withYear(String year) {
		this.year = year;
		return this;
	}

	public Movie withRated(String rated) {
		this.rated = rated;
		return this;
	}

	public Movie withReleased(String released) {
		this.released = released;
		return this;
	}

	public Movie withRuntime(String runtime) {
		this.runtime = runtime;
		return this;
	}

	public Movie withGenre(String genre) {
		this.genre = genre;
		return this;
	}

	public Movie withDirector(String director) {
		this.director = director;
		return this;
	}

	public Movie withWriter(String writer) {
		this.writer = writer;
		return this;
	}

	public Movie withActors(String actors) {
		this.actors = actors;
		return this;
	}

	public Movie withPlot(String plot) {
		this.plot = plot;
		return this;
	}

	public Movie withLanguage(String language) {
		this.language = language;
		return this;
	}

	public Movie withCountry(String country) {
		this.country = country;
		return this;
	}

	public Movie withAwards(String awards) {
		this.awards = awards;
		return this;
	}

	public Movie withPoster(String poster) {
		this.poster = poster;
		return this;
	}

	public Movie withMetascore(String metascore) {
		this.metascore = metascore;
		return this;
	}

	public Movie withImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
		return this;
	}

	public Movie withImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
		return this;
	}

	public Movie withImdbID(String imdbID) {
		this.imdbID = imdbID;
		return this;
	}

	public Movie withType(String type) {
		this.type = type;
		return this;
	}

	public Movie withTotalSeasons(String totalSeasons) {
		this.totalSeasons = totalSeasons;
		return this;
	}

	public Movie withResponse(String response) {
		this.response = response;
		return this;
	}

}
