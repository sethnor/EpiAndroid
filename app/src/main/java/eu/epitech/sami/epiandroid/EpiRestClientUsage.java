package eu.epitech.sami.epiandroid;

/**
 * Created by Sami on 25/01/2016.
 */

import android.preference.PreferenceActivity;

import org.json.*;
import com.loopj.android.http.*;

public class EpiRestClientUsage {
    public void     connectAndReturnToken(String login, String password) throws JSONException {
        RequestParams params = new RequestParams();

        params.put("login", login);
        params.put("password", password);
        EpiRestClient.post("login", params, new JsonHttpResponseHandler());
    }

     public void    getInfos(String token) throws JSONException {
         RequestParams params = new RequestParams("token", token);

         EpiRestClient.post("infos", params, new JsonHttpResponseHandler());
     }

    public void     getPlanning(String token, String begin, String end) throws JSONException {
        RequestParams params = new RequestParams();

        params.put("token", token);
        params.put("start", begin);
        params.put("end", end);
        EpiRestClient.get("planning", params, new JsonHttpResponseHandler());
    }

    public void     getSusies(String token, String begin, String end) throws JSONException
    {
        RequestParams params = new RequestParams();

        params.put("token", token);
        params.put("start", begin);
        params.put("end", end);

        EpiRestClient.get("susies", params, new JsonHttpResponseHandler());
    }

    public void     getSpeicificSusie(String token, int id, int calendar_id) throws JSONException
    {
        RequestParams params = new RequestParams();

        params.put("token", token);
        params.put("id", id);
        params.put("calendar_id", calendar_id);

        EpiRestClient.get("susie", params, new JsonHttpResponseHandler());
    }

    public void     subscribeToSusie(String token, int id, int calendar_id) throws JSONException
    {
        RequestParams params = new RequestParams();

        params.put("token", token);
        params.put("id", id);
        params.put("calendar_id", calendar_id);

        EpiRestClient.post("susie", params, new JsonHttpResponseHandler());
    }

    public void     getProjects(String token) throws JSONException
    {
        RequestParams params = new RequestParams("token", token);

        EpiRestClient.get("projects", params, new JsonHttpResponseHandler());
    }

    public void     getSpecificProject(String token, int scolaryear, String codemodule, String codeinstance, String codeacti) throws JSONException
    {
        RequestParams params = new RequestParams();

        params.put("token", token);
        params.put("scolaryear", scolaryear);
        params.put("codemodule", codemodule);
        params.put("codeinstance", codeinstance);
        params.put("codeacti", codeacti);

        EpiRestClient.get("project", params, new JsonHttpResponseHandler());
    }

    public void     subscribeToProject(String token, int scolaryear, String codemodule, String codeinstance, String codeacti) throws JSONException
    {
        RequestParams params = new RequestParams();

        params.put("token", token);
        params.put("scolaryear", scolaryear);
        params.put("codemodule", codemodule);
        params.put("codeinstance", codeinstance);
        params.put("codeacti", codeacti);

        EpiRestClient.post("project", params, new JsonHttpResponseHandler());
    }

    public void     getUserModule(String token) throws JSONException
    {
        RequestParams params = new RequestParams("token", token);

        EpiRestClient.get("modules", params, new JsonHttpResponseHandler());
    }

    public void     getAllModules(String token, int scolaryear, String location, String course) throws JSONException
    {
        RequestParams params = new RequestParams();

        params.put("token", token);
        params.put("scolaryear", scolaryear);
        params.put("location", location);
        params.put("course", course);

        EpiRestClient.get("allmodules", params, new JsonHttpResponseHandler());
    }

    public void     getSpecificModule(String token, int scolaryear, String codemodule, String codeinstance) throws JSONException
    {
        RequestParams params = new RequestParams();

        params.put("token", token);
        params.put("scolaryear", scolaryear);
        params.put("codemodule", codemodule);
        params.put("codeinstance", codeinstance);

        EpiRestClient.get("module", params, new JsonHttpResponseHandler());
    }

    public void     SubscribeToModule(String token, int scolaryear, String codemodule, String codeinstance) throws JSONException
    {
        RequestParams params = new RequestParams();

        params.put("token", token);
        params.put("scolaryear", scolaryear);
        params.put("codemodule", codemodule);
        params.put("codeinstance", codeinstance);

        EpiRestClient.post("module", params, new JsonHttpResponseHandler());
    }
}
