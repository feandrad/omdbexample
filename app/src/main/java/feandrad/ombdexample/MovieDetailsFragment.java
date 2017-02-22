package feandrad.ombdexample;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by feandrad on 16/02/2017.
 */
public class MovieDetailsFragment extends Fragment {

	@Nullable @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_details, container, false);
		ButterKnife.bind(this, rootView);

		return rootView;
	}
}
