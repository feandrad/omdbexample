package feandrad.ombdexample.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by feandrad on 11/02/2017.
 */
public class OMDbService {

	public static OmdbApi.Search getSearchApi() {
		return new Retrofit.Builder()
				.baseUrl(OmdbApi.OMDB_BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.build()
				.create(OmdbApi.Search.class);
	}

}
