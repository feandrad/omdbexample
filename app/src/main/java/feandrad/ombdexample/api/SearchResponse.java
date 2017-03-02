package feandrad.ombdexample.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import feandrad.ombdexample.model.Movie;

/**
 * Created by feandrad on 02/03/2017.
 */
public class SearchResponse {

	@Expose @SerializedName("Search") private ArrayList<Movie> response;

}
