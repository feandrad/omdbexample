package feandrad.ombdexample.api;

import com.google.gson.stream.MalformedJsonException;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by feandrad on 01/03/2017.
 */
public class ApiTask<Received> implements Callback<Received> {

	private Call<Received> call;
	private APIListener<Received> listener;

	public interface APIListener<Received> {
		void onSuccess(Received dataObject);

		void onError(ApiTask.APIError e);

		void onFailure(Exception e);
	}

	// Deve inicializar a call antes de rodar execute
	public ApiTask(APIListener<Received> listener) {
		this.listener = listener;
	}

	public ApiTask(Call<Received> call, APIListener<Received> listener) {
		this.call = call;
		this.listener = listener;
	}

	public void execute() {
		if (call == null) {
			throw new NullPointerException("Attempt to enqueque a null call in " +
					getClass().getSimpleName());
		}
		call.enqueue(this);
	}

	//<editor-fold desc="Getters and Setters">

	public Call<Received> getCall() {
		return call;
	}

	protected ApiTask setCall(Call<Received> call) {
		this.call = call;
		return this;
	}

	public APIListener<Received> getListener() {
		return listener;
	}

	protected ApiTask setListener(APIListener<Received> listener) {
		this.listener = listener;
		return this;
	}

	//</editor-fold>

	@Override
	public void onResponse(Call<Received> call, Response<Received> response) {
		if (!response.isSuccessful()) {
			final APIError error = parseError(response);
			listener.onError(error);

		} else {
			Received result = onSuccess(response.body());
			listener.onSuccess(result);
		}
	}

	@Override public void onFailure(Call<Received> call, Throwable t) {
		Exception e;

		if (t instanceof MalformedJsonException) {
			e = new Exception("API returned a invalid JSON response.", t);
		} else {
			e = new Exception("API request failed.", t);
		}

		e.printStackTrace();
		listener.onFailure(e);
	}

	protected Received onSuccess(Received result) {
		return result;
	}

	protected APIError parseError(Response<?> response) {
		Converter<ResponseBody, APIError> converter = Api
				.getRetrofit()
				.responseBodyConverter(APIError.class, new Annotation[0]);

		APIError error;

		try {
			error = converter.convert(response.errorBody());
		} catch (IOException e) {
			e.printStackTrace();
			return new APIError();
		}

		return error;
	}

	public class APIError {

		private String msg;

		public APIError() {
		}

		public String getMessage() {
			return this.msg;
		}
	}
}

