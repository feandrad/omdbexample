package feandrad.ombdexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import feandrad.ombdexample.model.Movie;
import feandrad.ombdexample.model.Poster;

/**
 * Created by feandrad on 01/03/2017.
 */
public class MovieGridAdapter extends RecyclerView.Adapter {

	ArrayList<Movie> movieList;

	@Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
			int viewType) {

		View rootView = LayoutInflater
				.from(parent.getContext())
				.inflate(R.layout.movie_grid_item, parent, false);

		movieList = new ArrayList<>(UserData.getInstance().getMovies());

		return new MovieGridViewHolder(rootView);
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		((MovieGridViewHolder) holder).bindView(position);
	}

	@Override public int getItemCount() {
		if (movieList == null) {
			return 0;
		}

		return movieList.size();
	}

	private class MovieGridViewHolder extends RecyclerView.ViewHolder {

		private TextView textView;
		private ImageView imageView;

		public MovieGridViewHolder(View itemView) {
			super(itemView);

			textView = (TextView) itemView.findViewById(R.id.grid_item_text);
			imageView = (ImageView) itemView.findViewById(R.id.grid_item_image);

			itemView.setOnClickListener(new View.OnClickListener() {
				@Override public void onClick(View v) {
					// TODO: goToMovieDetails using cached data
				}
			});
		}

		public void bindView(int position) {

			Movie movie = movieList.get(position);
			Poster poster = UserData.getInstance().getPosterById(movie.getImdbID());

			textView.setText(movie.getTitle());
			imageView.setImageResource(poster.getImageResource());

		}

	}
}
