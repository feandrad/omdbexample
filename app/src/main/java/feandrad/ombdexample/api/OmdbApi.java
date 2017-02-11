package feandrad.ombdexample.api;

import java.util.ArrayList;

import feandrad.ombdexample.model.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by feandrad on 09/02/2017.
 */
public interface OmdbApi {

	String OMDB_BASE_URL = "http://www.omdbapi.com";

	String OMDB_SEARCH_BY_TITLE = "";

	interface Search {

		@GET("/type=movie&r=json")
		Call<APIResponse<ArrayList<Movie>>> moviesMatchName(
				@Query("s") String name
		);

		@GET("/type=movie&r=json")
		Call<APIResponse<ArrayList<Movie>>> movieMatchExactName(
				@Query("t") String name
		);

		@GET("/type=movie&r=json")
		Call<APIResponse<Movie>> movieById(
				@Query("i") String IMDbId
		);

	}

	// TESTONLY
	String DEBUG_MOVIE_NOT_FOUND =
			"{\"Response\":\"False\",\"Error\":\"Movie not found!\"}";

	// TESTONLY
	String DEBUG_MOVIE_RESPONSE_EXAMPLE = "{\"Title\":\"It\",\"Year\":\"1990\"," +
			"\"Rated\":\"TV-14\",\"Released\":\"18 Nov 1990\"," +
			"\"Runtime\":\"192 min\",\"Genre\":\"Drama, Fantasy, Horror\"," +
			"\"Director\":\"N/A\",\"Writer\":\"N/A\"," +
			"\"Actors\":\"Harry Anderson, Dennis Christopher, Richard Masur, Annette O'Toole\"," +
			"\"Plot\":\"In 1960, seven pre-teen outcasts fight an evil demon who poses as a child-killing clown. Thirty years later, they reunite to stop the demon once and for all when it returns to their hometown.\"," +
			"\"Language\":\"English\",\"Country\":\"USA, Canada\"," +
			"\"Awards\":\"Won 1 Primetime Emmy. Another 2 wins & 2 nominations.\"," +
			"\"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BY2I0ZGI0MzItN2RhZi00ZmQ3LWI5MmUtNWE2MTAxZmY5Njc1XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg\"," +
			"\"Metascore\":\"N/A\",\"imdbRating\":\"6.9\",\"imdbVotes\":\"70,110\"," +
			"\"imdbID\":\"tt0099864\",\"Type\":\"series\",\"totalSeasons\":\"N/A\"," +
			"\"Response\":\"True\"" +
			"}";

	// TESTONLY
	String DEBUG_MOVIE_RESPONSE_EXAMPLE2 = "{\n" +
			"  \"Title\": \"It\",\n" +
			"  \"Year\": \"1990\",\n" +
			"  \"Rated\": \"TV-14\",\n" +
			"  \"Released\": \"18 Nov 1990\",\n" +
			"  \"Runtime\": \"192 min\",\n" +
			"  \"Genre\": \"Drama, Fantasy, Horror\",\n" +
			"  \"Director\": \"N/A\",\n" +
			"  \"Writer\": \"N/A\",\n" +
			"  \"Actors\": \"Harry Anderson, Dennis Christopher, Richard Masur, Annette O'Toole\",\n" +
			"  \"Plot\": \"In 1960, seven pre-teen outcasts fight an evil demon who poses as a child-killing clown. Thirty years later, they reunite to stop the demon once and for all when it returns to their hometown.\",\n" +
			"  \"Language\": \"English\",\n" +
			"  \"Country\": \"USA, Canada\",\n" +
			"  \"Awards\": \"Won 1 Primetime Emmy. Another 2 wins & 2 nominations.\",\n" +
			"  \"Poster\": \"https://images-na.ssl-images-amazon.com/images/M/MV5BY2I0ZGI0MzItN2RhZi00ZmQ3LWI5MmUtNWE2MTAxZmY5Njc1XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg\",\n" +
			"  \"Metascore\": \"N/A\",\n" +
			"  \"imdbRating\": \"6.9\",\n" +
			"  \"imdbVotes\": \"70,110\",\n" +
			"  \"imdbID\": \"tt0099864\",\n" +
			"  \"Type\": \"series\",\n" +
			"  \"totalSeasons\": \"N/A\",\n" +
			"  \"Response\": \"True\"\n" +
			"}";

}
