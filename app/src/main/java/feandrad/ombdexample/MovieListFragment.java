package feandrad.ombdexample;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by feandrad on 14/02/2017.
 */
public class MovieListFragment extends Fragment {
	
	@BindView(R.id.movie_list) RecyclerView movieGrid;
	
	@Nullable @Override
	public View onCreateView(final LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_home, container, false);
		ButterKnife.bind(this, rootView);

		StaggeredGridLayoutManager lm = new StaggeredGridLayoutManager(2,
				StaggeredGridLayoutManager.VERTICAL);
		movieGrid.setLayoutManager(lm);

		final int[] moviePosters = {
				R.drawable.side_nav_bar,
				R.drawable.side_nav_bar
		};

		final Activity activity = getActivity();

		RecyclerView.Adapter adapter = new RecyclerView.Adapter<MovieVH>() {

			@Override
			public MovieVH onCreateViewHolder(ViewGroup parent, int viewType) {
				View albumView = inflater.inflate(R.layout.movie_grid_item, parent,
						false);
				return new MovieVH(albumView, new OnVHClickedListener() {
					@Override public void onVHClicked(MovieVH vh) {

						// TODO: Call MovieDetailsFragment
					}
				});
			}

			@Override public void onBindViewHolder(MovieVH holder, int position) {
				holder.moviePoster.setImageResource(
						moviePosters[position % moviePosters.length]);
			}

			@Override public int getItemCount() {
				return moviePosters.length * 4;
			}

		};
		movieGrid.setAdapter(adapter);

		return rootView;
	}

	interface OnVHClickedListener {
		void onVHClicked(MovieVH vh);
	}

	static class MovieVH extends RecyclerView.ViewHolder implements
			View.OnClickListener {
		private final OnVHClickedListener mListener;
		@BindView(R.id.grid_item_image) ImageView moviePoster;

		public MovieVH(View itemView, OnVHClickedListener listener) {
			super(itemView);
			ButterKnife.bind(this, itemView);
			itemView.setOnClickListener(this);
			mListener = listener;
		}

		@Override
		public void onClick(View v) {
			mListener.onVHClicked(this);
		}
	}

}
