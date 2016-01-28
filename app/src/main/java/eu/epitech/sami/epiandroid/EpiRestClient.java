package eu.epitech.sami.epiandroid;

import com.loopj.android.http.*;

import org.json.JSONException;


/**
 * Created by Sami on 25/01/2016.
 */
public class EpiRestClient {
    public static Model             model = new Model();
    private static final String     BASE_URL = "https://epitech-api.herokuapp.com/";
    private static SyncHttpClient   syncClient = new SyncHttpClient();
    private static AsyncHttpClient  client = new AsyncHttpClient();

    public static void      connect(String url, RequestParams params, AsyncHttpResponseHandler responseHandler)
    {
        syncClient.post(getUrl(url), params, responseHandler);
    }

    public static void      get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        syncClient.get(getUrl(url), params, responseHandler);
    }

    public static void      post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        syncClient.post(getUrl(url), params, responseHandler);
    }

    private static String   getUrl(String url)
    {
        return BASE_URL + url;
    }
}
