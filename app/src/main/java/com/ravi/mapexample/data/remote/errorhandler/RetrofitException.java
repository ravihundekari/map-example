package com.ravi.mapexample.data.remote.errorhandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.ravi.mapexample.util.Constants.JSON_OBJECT_KEY;
import static com.ravi.mapexample.util.Constants.NETWORK_ERROR_CONNECTION_TIMEOUT;
import static com.ravi.mapexample.util.Constants.NETWORK_ERROR_UNKNOWN;


public class RetrofitException extends RuntimeException {
    static RetrofitException httpError(String url, Response response, Retrofit retrofit) {
        return new RetrofitException(getErrorMessage(response.errorBody()), url, response, Kind.HTTP, null, retrofit);
    }

    static RetrofitException networkError(IOException exception) {
        return new RetrofitException(NETWORK_ERROR_UNKNOWN, null, null, Kind.NETWORK, exception, null);
    }

    static RetrofitException unexpectedError(Throwable exception) {
        return new RetrofitException(NETWORK_ERROR_CONNECTION_TIMEOUT, null, null, Kind.UNEXPECTED, exception, null);
    }

    /**
     * Identifies the event kind which triggered a {@link RetrofitException}.
     */
    public enum Kind {
        NETWORK,
        HTTP,
        UNEXPECTED,
    }

    private final String url;
    private final Response response;
    private final Kind kind;

    private RetrofitException(String message, String url, Response response, Kind kind, Throwable exception, Retrofit retrofit) {
        super(message, exception);
        this.url = url;
        this.response = response;
        this.kind = kind;
    }

    public String getUrl() {
        return url;
    }

    public Response getResponse() {
        return response;
    }

    public Kind getKind() {
        return kind;
    }

    private static String getErrorMessage(ResponseBody responseBody) {
        String errorMessage = "";
        try {
            if (responseBody != null) {
                JSONObject jsonObject = new JSONObject(responseBody.string());
                errorMessage = jsonObject.getString(JSON_OBJECT_KEY);
            }
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
        return errorMessage;
    }
}
