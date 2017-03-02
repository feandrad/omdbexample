package feandrad.ombdexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import feandrad.ombdexample.model.Movie;

/**
 * Created by feandrad on 02/03/2017.
 */
public class SearchResponseAdapter extends RecyclerView.Adapter {

	private ArrayList<Movie> suggestions;
	private final AdapterItemClickListener itemClickListener;

	interface AdapterItemClickListener {
		void onItemClicked(Movie movie, int position);
	}

	public SearchResponseAdapter(AdapterItemClickListener itemClickListener) {
		this.itemClickListener = itemClickListener;
	}

	@Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
			int viewType) {

		View rootView = LayoutInflater
				.from(parent.getContext())
				.inflate(android.R.layout.simple_list_item_1, parent, false);

		return new SearchResponseViewHolder(rootView);
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		((SearchResponseViewHolder) holder).bindView(position);

	}

	@Override public int getItemCount() {
		return suggestions.size();
	}

	public void setSuggestions(ArrayList<Movie> movies) {

		suggestions = new ArrayList<>();

		for (Movie movie : movies) {
			suggestions.add(movie);
			notifyItemInserted(getItemCount());
		}

	}

	private class SearchResponseViewHolder extends RecyclerView.ViewHolder {

		private TextView textView;
		private View itemView;

		public SearchResponseViewHolder(View itemView) {
			super(itemView);

			this.itemView = itemView;

			textView = (TextView) itemView.findViewById(android.R.id.text1);

		}

		public void bindView(final int position) {
			final Movie movie = suggestions.get(position);
			textView.setText(movie.getTitle());

			itemView.setOnClickListener(new View.OnClickListener() {
				@Override public void onClick(View v) {
					itemClickListener.onItemClicked(movie, position);
				}
			});
		}

	}

}
