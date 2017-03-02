package feandrad.ombdexample;

import java.util.Collection;
import java.util.HashMap;

import feandrad.ombdexample.model.Movie;
import feandrad.ombdexample.model.Poster;

/**
 * Created by feandrad on 01/03/2017.
 */
public class UserData {
	private static UserData instance = new UserData();

	// Key: imdbID
	private HashMap<String, Movie> movies;
	private HashMap<String, Poster> posters;
	
	private UserData() {
	}
	
	public static UserData getInstance() {
		if (instance == null) {
			// Thread Safe. Might be costly operation in some case
			synchronized (UserData.class) {
				if (instance == null) {
					instance = new UserData();
				}
			}
		}
		return instance;
	}

	public Movie getMovieById(String imdbID) {
		if (movies == null || !movies.containsKey(imdbID)) {
			return null;
		}

		return movies.get(imdbID);
	}

	public Poster getPosterById(String imdbID) {
		if (posters == null || !posters.containsKey(imdbID)) {
			return null;
		}

		return posters.get(imdbID);
	}

	public Collection<Movie> getMovies() {
		return movies.values();
	}
}
