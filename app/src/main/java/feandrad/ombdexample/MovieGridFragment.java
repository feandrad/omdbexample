package feandrad.ombdexample;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by feandrad on 14/02/2017.
 */
public class MovieGridFragment extends Fragment {
	
	@BindView(R.id.movie_list) RecyclerView movieGrid;

	MovieGridAdapter gridAdapter;

	MainActivity mainActivity;
	
	@Nullable @Override
	public View onCreateView(final LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_home, container, false);
		ButterKnife.bind(this, rootView);

		mainActivity = (MainActivity) getActivity();

		gridAdapter = new MovieGridAdapter();
		movieGrid.setAdapter(gridAdapter);

		StaggeredGridLayoutManager lm = new StaggeredGridLayoutManager(2,
				StaggeredGridLayoutManager.VERTICAL);
		movieGrid.setLayoutManager(lm);

		update();

		return rootView;
	}

	public void update(){

	}

}
