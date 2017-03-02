package feandrad.ombdexample;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import butterknife.BindView;
import butterknife.ButterKnife;
import feandrad.ombdexample.api.ApiTask;
import feandrad.ombdexample.api.SearchByNameTask;
import feandrad.ombdexample.api.SearchResponse;
import feandrad.ombdexample.model.Movie;

/**
 * Created by feandrad on 22/02/2017.
 */
public class SearchByNameFragment extends Fragment implements
		SearchView.OnQueryTextListener,
		SearchResponseAdapter.AdapterItemClickListener {

	private static final String LOG_TAG =
			SearchByNameFragment.class.getSimpleName();

	@BindView(R.id.search_result_list) RecyclerView searchResultList;

	MainActivity mainActivity;
	private SearchResponseAdapter adapter;

	@Nullable @Override
	public View onCreateView(final LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater
				.inflate(R.layout.fragment_search, container, false);
		ButterKnife.bind(this, rootView);

		mainActivity = (MainActivity) getActivity();

		searchResultList.setLayoutManager(
				new LinearLayoutManager(container.getContext()));

		return rootView;
	}

	@Override public boolean onQueryTextSubmit(String query) {

		// TODO: Show progress dialog
		final ProgressDialog progressDialog = ProgressDialog.show(
				getActivity(),
				null,
				getString(R.string.dialog_searching_movies),
				true
		);


		Log.d(LOG_TAG, "Query started.");

		new SearchByNameTask(query, new ApiTask.APIListener<SearchResponse>() {

			@Override public void onSuccess(SearchResponse searchResponse) {
				Log.d(LOG_TAG, "Query succeed.");
				progressDialog.dismiss();

				adapter = new SearchResponseAdapter(SearchByNameFragment.this);
				adapter.setSuggestions(searchResponse.getSuggestedMovies());

				searchResultList.setAdapter(adapter);
			}

			@Override public void onError(ApiTask.APIError e) {
				Log.d(LOG_TAG, "Query returned a error.");
				progressDialog.dismiss();
			}

			@Override public void onFailure(Exception e) {
				Log.d(LOG_TAG, "Query failed.");
				progressDialog.dismiss();
			}

		}).execute();

		return false;
	}

	@Override public boolean onQueryTextChange(String newText) {
		return false;
	}

	@Override public void onItemClicked(Movie movie, int position) {
		mainActivity.goToMovieDetailsFragment(movie);
	}

}
