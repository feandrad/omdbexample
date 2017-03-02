package feandrad.ombdexample;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SearchView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import feandrad.ombdexample.model.Movie;

public class MainActivity extends AppCompatActivity
		implements NavigationView.OnNavigationItemSelectedListener {
	
	private static final String LOG_TAG = MainActivity.class.getSimpleName();

	@BindView(R.id.coordinator_layout) CoordinatorLayout coordinatorLayout;
	@BindView(R.id.fab) FloatingActionButton fab;
	@BindView(R.id.drawer_layout) DrawerLayout drawer;
	@BindView(R.id.nav_view) NavigationView navigationView;
	@BindView(R.id.main_container) FrameLayout fragmentContainer;

	@BindView(R.id.toolbar) Toolbar toolbar;
	@BindView(R.id.searchbar) Toolbar searchbar;

	@BindView(R.id.search_view) SearchView searchView;

	private ActionBarDrawerToggle toggle;

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		setSupportActionBar(toolbar);

		toggle = new ActionBarDrawerToggle(
				this, drawer, toolbar, R.string.navigation_drawer_open,
				R.string.navigation_drawer_close);
		drawer.addDrawerListener(toggle);
		toggle.syncState();

		navigationView.setNavigationItemSelectedListener(this);

		fab.show();

		getFragmentManager().beginTransaction()
							.replace(R.id.main_container, new MovieGridFragment())
							.commit();

	}

	@Override public void onBackPressed() {
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);

		} else if (getFragmentManager().getBackStackEntryCount() > 0) {
			getFragmentManager().popBackStackImmediate();

			if (getFragmentManager().getBackStackEntryCount() == 0) {
				searchbar.setVisibility(View.GONE);
				fab.show();
			}

		} else {
			super.onBackPressed();
		}

	}

	@Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {

		switch (item.getItemId()) {
			case R.id.nav_movies:
				goToHomeFragment();
				break;

			case R.id.nav_github:
				Intent browserIntent = new Intent(
						Intent.ACTION_VIEW,
						Uri.parse("https://github.com/feandrad/omdbexample")
				);

				startActivity(browserIntent);
				break;

			default:
				break;
		}

		drawer.closeDrawer(GravityCompat.START);
		return true;
	}

	public void goToMovieDetailsFragment(Movie movie) {
		MovieDetailsFragment movieDetailsFragment = new MovieDetailsFragment();

		Bundle bundle = new Bundle();
		bundle.putSerializable(OMDbExample.Tags.IMDB_ID, movie);
		movieDetailsFragment.setArguments(bundle);

		getFragmentManager().beginTransaction()
							.replace(R.id.main_container, movieDetailsFragment)
							.addToBackStack(null)
							.commit();

		searchbar.setVisibility(View.GONE);
		fab.hide();
	}

	@OnClick(R.id.fab) void goToSearchByNameFragment() {

		if (!isNetworkAvailable()) {
			Snackbar.make(
					coordinatorLayout,
					"Sem internet",
					Snackbar.LENGTH_LONG
			).show();
			return;
		}

		SearchByNameFragment searchByNameFragment = new SearchByNameFragment();

		getFragmentManager().beginTransaction()
							.replace(R.id.main_container, searchByNameFragment)
							.addToBackStack(null)
							.commit();

		searchbar.setVisibility(View.VISIBLE);
		searchView.setOnQueryTextListener(searchByNameFragment);
		fab.hide();
	}

	public void goToHomeFragment() {
		FragmentManager manager = getFragmentManager();
		if (manager.getBackStackEntryCount() > 0) {
			FragmentManager.BackStackEntry first = manager.getBackStackEntryAt(0);
			manager.popBackStack(first.getId(),
					FragmentManager.POP_BACK_STACK_INCLUSIVE);
		}

		searchbar.setVisibility(View.GONE);
		fab.show();
	}

	private boolean isNetworkAvailable() {
		ConnectivityManager connectivityManager
				= (ConnectivityManager) getSystemService(
				Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
		return activeNetworkInfo != null;
	}

}
