package feandrad.ombdexample.api;

/**
 * Created by feandrad on 02/03/2017.
 */
public class SearchByNameTask extends ApiTask<SearchResponse> {

	public SearchByNameTask(String query, APIListener<SearchResponse> listener) {
		super(OMDbService.getSearchApi().moviesMatchName(query), listener);

	}

}
