package eu.epitech.sami.epiandroid;

import com.loopj.android.http.*;
/**
 * Created by Sami on 25/01/2016.
 */
public class EpiRestClient {
    public static String      TOKEN = "42";
    private static final String     BASE_URL = "https://epitech-api.herokuapp.com/";
    private static AsyncHttpClient  client = new AsyncHttpClient();

    public static void      get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getUrl(url), params, responseHandler);
    }

    public static void      post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getUrl(url), params, responseHandler);
    }

    private static String   getUrl(String url)
    {
        return BASE_URL + url;
    }

    public static String      getToken()
    {
        System.out.println(TOKEN);
        return TOKEN;
    }
}
