package eu.epitech.sami.epiandroid;

import android.text.Html;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by tester on 28/01/2016.
 */
public class Messages {
    public static String[] title;
    public static String[] expeditorName;
    public static String[] content;
    public static String[] date;
    public static JSONArray arrayObject = new JSONArray();

    public static void parseMessages()
    {
        try {
            title = new String[arrayObject.length()];
            expeditorName = new String[arrayObject.length()];
            content = new String[arrayObject.length()];
            date = new String[arrayObject.length()];
            for (int i = 0; i < arrayObject.length(); i++)
            {
                JSONObject object = arrayObject.getJSONObject(i);
                JSONObject expeditorObject = object.getJSONObject("user");

                title[i] = object.getString("title");
                title[i] = Html.fromHtml(title[i]).toString();
                expeditorName[i] = expeditorObject.getString("title");
                content[i] = object.getString("content");
                date[i] = object.getString("date");
            }
        } catch (JSONException e) { System.out.println("parseMessages failed"); }
    }

    public static void setArray(JSONArray newarray)
    {
        try {
            arrayObject = new JSONArray(newarray.toString());
        } catch (JSONException e) { System.out.println("Copying JSONArray failed"); }
    }
}
