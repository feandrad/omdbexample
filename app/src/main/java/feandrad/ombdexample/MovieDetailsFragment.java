package feandrad.ombdexample;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import feandrad.ombdexample.api.ApiTask;
import feandrad.ombdexample.api.MovieInfoUpdateTask;
import feandrad.ombdexample.model.Movie;

/**
 * Created by feandrad on 16/02/2017.
 */
public class MovieDetailsFragment extends Fragment {

	private static final String LOG_TAG =
			MovieDetailsFragment.class.getSimpleName();

	@BindView(R.id.movie_poster) ImageView posterView;
	@BindView(R.id.title) TextView title;
	@BindView(R.id.genre) TextView genre;
	@BindView(R.id.director) TextView director;
	@BindView(R.id.plot) TextView plot;

	private Movie movie;

	private MainActivity mainActivity;
	private ProgressDialog progressDialog;

	@Nullable @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_details, container,
				false);
		ButterKnife.bind(this, rootView);

		mainActivity = (MainActivity) getActivity();

		movie = (Movie) getArguments().getSerializable(OMDbExample.Tags.IMDB_ID);

		if (movie == null) {
			Log.e(LOG_TAG, "Null movie");

		} else if (UserData.getInstance().hasMovie(movie)) {
			movie = UserData.getInstance().getMovieById(movie.getImdbID());
			update();

		} else {
			Log.d(LOG_TAG, "Query started.");

			progressDialog = ProgressDialog.show(
					getActivity(),
					null,
					getString(R.string.search_movie_info),
					false
			);

			new MovieInfoUpdateTask(
					movie.getImdbID(),
					new ApiTask.APIListener<Movie>() {

						@Override public void onSuccess(Movie result) {
							Log.d(LOG_TAG, "Query succeed.");
							progressDialog.dismiss();

							movie = result;
							update();
						}

						@Override public void onError(ApiTask.APIError e) {
							Log.d(LOG_TAG, "Query returned a error.");
							progressDialog.dismiss();
						}

						@Override public void onFailure(Exception e) {
							Log.d(LOG_TAG, "Query failed.");
							progressDialog.dismiss();
						}
					}
			).execute();

		}

		return rootView;
	}

	private void update() {
		title.setText(movie.getTitle());
		genre.setText(movie.getGenre());
		director.setText(movie.getDirector());
		plot.setText(movie.getPlot());

		if (UserData.getInstance().hasPoster(movie.getImdbID())) {
			// TODO: Poster offline caso Picasso falhe

		} else {

			Picasso.with(getActivity())
				   .load(movie.getPosterUrl())
				   .placeholder(R.drawable.ic_picasso_placeholder)
				   .into(posterView);
		}

	}

}
