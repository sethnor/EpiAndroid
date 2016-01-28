package eu.epitech.sami.epiandroid;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by tester on 28/01/2016.
 */
public class allModules {
    public static int[]       scolaryear;
    public static String[]    codemodule;
    public static String[]    title;
    public static String[]    credits;
    public static String[]    status;
    public static JSONObject  object = new JSONObject();

    public static void        parseAllModules()
    {
        try {
            JSONArray         items = object.getJSONArray("items");
            scolaryear = new int[items.length()];
            codemodule = new String[items.length()];
            title = new String[items.length()];
            credits = new String[items.length()];
            status = new String[items.length()];

            for (int i = 0; i < items.length(); i++)
            {
                JSONObject module = items.getJSONObject(i);

                scolaryear[i] = module.getInt("scolaryear");
                codemodule[i] = module.getString("code");
                title[i] = module.getString("title");
                credits[i] = module.getString("credits");
                status[i] = module.getString("status");
            }
        } catch (JSONException e) { System.out.println("parseAllModules failed"); }
    }

    public static void        setObject(JSONObject newobject)
    {
        try {
            object = new JSONObject(newobject.toString());
        } catch (JSONException e) { }
    }
}
