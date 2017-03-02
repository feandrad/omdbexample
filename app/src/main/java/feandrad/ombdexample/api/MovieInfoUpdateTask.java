package feandrad.ombdexample.api;

import feandrad.ombdexample.UserData;
import feandrad.ombdexample.model.Movie;

/**
 * Created by feandrad on 02/03/2017.
 */
public class MovieInfoUpdateTask extends ApiTask<Movie> {

	public MovieInfoUpdateTask(String imdbId, APIListener<Movie> listener) {
		super(OMDbService.getSearchApi().movieById(imdbId), listener);
	}

	@Override protected Movie onSuccess(Movie result) {

		if (result != null) {
			UserData.getInstance().sync(result);
			UserData.getInstance().save();
		}

		return super.onSuccess(result);
	}
}
