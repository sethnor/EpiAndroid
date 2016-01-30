package eu.epitech.sami.epiandroid;

/**
 * Created by Sami on 25/01/2016.
 */

import org.json.*;
import com.loopj.android.http.*;

public class EpiRestClientUsage {
    public void     connectAndReturnToken(String login, String password) throws JSONException {
        RequestParams params = new RequestParams();

        params.put("login", login);
        params.put("password", password);
        EpiRestClient.connect("login", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject response) {
                try {
                    String token = response.getString("token");

                    EpiRestClient.model.token.token = token;
                } catch (JSONException e) {
                }
            }

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONArray response) {
                try {
                    JSONObject objectResponse = response.getJSONObject(0);
                    String token = objectResponse.getString("token");

                    EpiRestClient.model.token.token = token;
                } catch (JSONException e) {
                }
            }
        });
    }

     public void    getInfos(String token) throws JSONException {
         RequestParams params = new RequestParams("token", token);

         EpiRestClient.post("infos", params, new JsonHttpResponseHandler() {
             @Override
             public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject response) {
                 EpiRestClient.model.infos.setObject(response);
             }

             @Override
             public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONArray response) {
                 try {
                     JSONObject objectResponse = response.getJSONObject(0);

                     EpiRestClient.model.infos.setObject(objectResponse);
                 } catch (JSONException e) {
                 }
             }

             @Override
             public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, java.lang.Throwable throwable, JSONObject errorResponse) {
                 System.out.println("Failure");
             }
         });
     }

    public void     getPlanning(String token, String begin, String end) throws JSONException {
        RequestParams params = new RequestParams();

        params.put("token", token);
        params.put("start", begin);
        params.put("end", end);
        EpiRestClient.get("planning", params, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject response)
            {
                //returns a jsonarray
            }

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONArray response)
            {
                EpiRestClient.model.planning.setObjects(response);
            }
        });
    }

    public static void     getSusies(String token, String begin, String end) throws JSONException
    {
        RequestParams params = new RequestParams();

        params.put("token", token);
        params.put("start", begin);
        params.put("end", end);

        EpiRestClient.get("susies", params, new JsonHttpResponseHandler());
    }

    public static void     getSpeicificSusie(String token, int id, int calendar_id) throws JSONException
    {
        RequestParams params = new RequestParams();

        params.put("token", token);
        params.put("id", id);
        params.put("calendar_id", calendar_id);

        EpiRestClient.get("susie", params, new JsonHttpResponseHandler());
    }

    public static void     subscribeToSusie(String token, int id, int calendar_id) throws JSONException
    {
        RequestParams params = new RequestParams();

        params.put("token", token);
        params.put("id", id);
        params.put("calendar_id", calendar_id);

        EpiRestClient.post("susie", params, new JsonHttpResponseHandler());
    }

    public static void     getProjects(String token) throws JSONException
    {
        RequestParams params = new RequestParams("token", token);

        EpiRestClient.get("projects", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject response) {
                //return jsonarray
            }

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONArray response) {
                EpiRestClient.model.projects.setArray(response);
            }
        });
    }

    public static void     getSpecificProject(String token, int scolaryear, String codemodule, String codeinstance, String codeacti) throws JSONException
    {
        RequestParams params = new RequestParams();

        params.put("token", token);
        params.put("scolaryear", scolaryear);
        params.put("codemodule", codemodule);
        params.put("codeinstance", codeinstance);
        params.put("codeacti", codeacti);

        EpiRestClient.get("project", params, new JsonHttpResponseHandler());
    }

    public static void     subscribeToProject(String token, int scolaryear, String codemodule, String codeinstance, String codeacti) throws JSONException
    {
        RequestParams params = new RequestParams();

        params.put("token", token);
        params.put("scolaryear", scolaryear);
        params.put("codemodule", codemodule);
        params.put("codeinstance", codeinstance);
        params.put("codeacti", codeacti);

        EpiRestClient.post("project", params, new JsonHttpResponseHandler());
    }

    public static void     getUserModule(String token) throws JSONException
    {
        RequestParams params = new RequestParams("token", token);

        EpiRestClient.get("modules", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject response) {
                EpiRestClient.model.usermodules.setObject(response);
            }

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONArray response) {
                //return jsonobject
            }
        });
    }

    public static void     getAllModules(String token, int scolaryear, String location, String course) throws JSONException
    {
        RequestParams params = new RequestParams();

        params.put("token", token);
        params.put("scolaryear", scolaryear);
        params.put("location", location);
        params.put("course", course);

        EpiRestClient.get("allmodules", params, new JsonHttpResponseHandler()
        {
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject response)
            {
                EpiRestClient.model.allmodules.setObject(response);
            }

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONArray response)
            {
                // return jsonbject
            }
        });
    }

    public static void     getSpecificModule(String token, int scolaryear, String codemodule, String codeinstance) throws JSONException
    {
        RequestParams params = new RequestParams();

        params.put("token", token);
        params.put("scolaryear", scolaryear);
        params.put("codemodule", codemodule);
        params.put("codeinstance", codeinstance);

        EpiRestClient.get("module", params, new JsonHttpResponseHandler());
    }

    public static void     SubscribeToModule(String token, int scolaryear, String codemodule, String codeinstance) throws JSONException
    {
        RequestParams params = new RequestParams();

        params.put("token", token);
        params.put("scolaryear", scolaryear);
        params.put("codemodule", codemodule);
        params.put("codeinstance", codeinstance);

        EpiRestClient.post("module", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject response) {
                //ne fait rien
            }

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONArray response) {
                //ne fait rien
            }
        });
    }

    public void            getMessage(String token) throws JSONException
    {
        RequestParams      params = new RequestParams("token", token);

        EpiRestClient.get("messages", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject response) {
                //return an array
            }

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONArray response) {
                System.out.println("Messages returns array");
                EpiRestClient.model.messages.setArray(response);
            }
        });
    }

    public void            getUserInfo(String token, String login) throws JSONException
    {
        RequestParams params = new RequestParams();

        params.put("token", token);
        params.put("user", login);

        EpiRestClient.get("user", params, new JsonHttpResponseHandler()
        {
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject response)
            {
                EpiRestClient.model.user.setObject(response);
            }

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONArray response)
            {
                try {
                    JSONObject objectResponse = response.getJSONObject(0);

                    EpiRestClient.model.user.setObject(objectResponse);
                }
                catch (JSONException e) { }
            }
        });
    }

    public void         validateToken(String token, int scolaryear, String codemodule, String codeinstance, String codeacti, String codeevent, String tokenvalidationcode) throws JSONException
    {
        RequestParams   params = new RequestParams();

        params.put("token", token);
        params.put("scolaryear", scolaryear);
        params.put("codemodule", codemodule);
        params.put("codeinstance", codeinstance);
        params.put("codeacti", codeacti);
        params.put("codeeevent", codeevent);
        params.put("tokenvalidationcode", tokenvalidationcode);

        EpiRestClient.post("token", params, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject response)
            {
                //returns nothing
                System.out.println("Token validated");
            }

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONArray response)
            {
                //returns nothing
                System.out.println("Token validated");
            }
        });
    }
}
