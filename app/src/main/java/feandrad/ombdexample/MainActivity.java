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
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
		implements NavigationView.OnNavigationItemSelectedListener {

	@BindView(R.id.fab) FloatingActionButton fab;
	@BindView(R.id.toolbar) Toolbar toolbar;
	@BindView(R.id.drawer_layout) DrawerLayout drawer;
	@BindView(R.id.nav_view) NavigationView navigationView;
	@BindView(R.id.main_container) FrameLayout fragmentContainer;

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

		setActiveFragment(new MovieListFragment());
	}

	@Override public void onBackPressed() {
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}

	@Override public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.

		switch (item.getItemId()) {
			case R.id.action_settings:
				break;

			default:
				break;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {

		switch (item.getItemId()) {
			case R.id.nav_movies:
				break;

			default:
				break;
		}

		drawer.closeDrawer(GravityCompat.START);
		return true;
	}

	@OnClick(R.id.fab) void addMovie() {
		// TODO Change active fragment to searchMovieFragment
		setActiveFragment(new MovieDetailsFragment());

		fab.hide();
	}

	public void setActiveFragment(Fragment fragment) {
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.add(R.id.main_container, fragment);
		transaction.commit();
	}

}
