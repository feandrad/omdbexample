package feandrad.ombdexample;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SearchView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import feandrad.ombdexample.api.ApiTask;
import feandrad.ombdexample.api.SearchByNameTask;
import feandrad.ombdexample.api.SearchResponse;

public class MainActivity extends AppCompatActivity
		implements NavigationView.OnNavigationItemSelectedListener,
		SearchView.OnQueryTextListener {
	
	private static final String LOG_TAG = MainActivity.class.getSimpleName();

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

		setActiveFragment(new MovieGridFragment());

		searchView.setOnQueryTextListener(this);

	}

	@Override public void onBackPressed() {
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);

		} else if (searchbar.getVisibility() == View.VISIBLE) {
			goToMovieGridFragment();

		} else {
			super.onBackPressed();
		}
	}

	@Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {

		switch (item.getItemId()) {
			case R.id.nav_movies:
				goToMovieGridFragment();
				break;

			default:
				break;
		}

		drawer.closeDrawer(GravityCompat.START);
		return true;
	}

	@Override public boolean onQueryTextSubmit(String query) {

		// TODO: Show progress dialog
		
		Log.d(LOG_TAG, "Query started.");

		new SearchByNameTask(query, new ApiTask.APIListener<SearchResponse>() {

			@Override public void onSuccess(SearchResponse dataObject) {

				Log.d(LOG_TAG, "Query succeed.");
			}

			@Override public void onError(ApiTask.APIError e) {

				Log.d(LOG_TAG, "Query returned a error.");
			}

			@Override public void onFailure(Exception e) {

				Log.d(LOG_TAG, "Query failed.");
			}

		}).execute();

		return false;
	}

	@Override public boolean onQueryTextChange(String newText) {
		return false;
	}

	private void goToMovieGridFragment() {
		setActiveFragment(new MovieGridFragment());
		searchbar.setVisibility(View.GONE);
		fab.show();
	}

	@OnClick(R.id.fab) void goToSearchByNameFragment() {
		setActiveFragment(new SearchByNameFragment());
		searchbar.setVisibility(View.VISIBLE);
		fab.hide();
	}

	public void setActiveFragment(Fragment fragment) {
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.replace(R.id.main_container, fragment);
		transaction.commit();
	}
}
