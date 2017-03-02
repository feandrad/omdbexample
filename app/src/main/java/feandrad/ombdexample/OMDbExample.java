package feandrad.ombdexample;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import java.util.Locale;

import io.paperdb.Paper;

public class OMDbExample extends Application {

	public static final boolean DEBUG = false;

	@Override public void onCreate() {
		super.onCreate();
		Locale.setDefault(new Locale("pt", "BR"));
		Paper.init(this);
	}

	public static String getVersion() {
		return BuildConfig.VERSION_CODE + "";
	}

	public static void runOnUiThread(Runnable runnable) {
		new Handler(Looper.getMainLooper()).post(runnable);
	}

	public class Tags {
		public static final String DB_MOVIES = "DB_MOVIES";
		public static final String DB_POSTERS = "DB_POSTERS";

		public static final String IMDB_ID = "IMDB_ID";
	}
}

