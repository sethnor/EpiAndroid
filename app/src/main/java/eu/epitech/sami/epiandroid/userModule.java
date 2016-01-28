package eu.epitech.sami.epiandroid;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by tester on 28/01/2016.
 */
public class userModule {
    public static int[]       scolaryear;
    public static String[]    codemodule;
    public static String[]    title;
    public static String[]    grades;
    public static int[]       credits;
    public static JSONObject  object = new JSONObject();

    public static void      parseUserModule()
    {
        try {
            JSONArray modules = object.getJSONArray("modules");
            scolaryear = new int[modules.length()];
            codemodule = new String[modules.length()];
            title = new String[modules.length()];
            grades = new String[modules.length()];
            credits = new int[modules.length()];

            for (int i = 0; i < modules.length(); i++)
            {
                JSONObject module = modules.getJSONObject(i);

                scolaryear[i] = module.getInt("scolaryear");
                codemodule[i] = module.getString("codemodule");
                title[i] = module.getString("title");
                grades[i] = module.getString("grade");
                credits[i] = module.getInt("credits");
            }
        } catch (JSONException e) { }
    }

    public static void      setObject(JSONObject newobject)
    {
        try {
            object = new JSONObject(newobject.toString());
        } catch (JSONException e) { }
    }
}
