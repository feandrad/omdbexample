package feandrad.ombdexample;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import feandrad.ombdexample.api.OMDbService;

/**
 * Created by feandrad on 22/02/2017.
 */
public class SearchByNameFragment extends Fragment {


	MainActivity mainActivity;

	@Nullable @Override
	public View onCreateView(final LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater
				.inflate(R.layout.fragment_search, container, false);
		ButterKnife.bind(this, rootView);

		mainActivity = (MainActivity) getActivity();


		return rootView;
	}

	private void search(String query) {
		OMDbService.getSearchApi().moviesMatchName(query);
	}
}
