package eu.epitech.sami.epiandroid;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by tester on 30/01/2016.
 */
public class Planning {
    public static String[]  scolaryear;
    public static String[]  codeacti;
    public static String[]  codeinstance;
    public static String[]  codeevent;
    public static String[]  codemodule;
    public static String[]  actititle;
    public static String[]  nbhours;
    public static String[]  starthours;
    public static String[]  endhours;
    public static JSONArray objects = new JSONArray();

    public static void      parsePlanning()
    {
        try {
            scolaryear = new String[objects.length()];
            codeacti = new String[objects.length()];
            codeinstance = new String[objects.length()];
            codeevent = new String[objects.length()];
            codemodule = new String[objects.length()];
            actititle = new String[objects.length()];
            nbhours = new String[objects.length()];
            starthours = new String[objects.length()];
            endhours = new String[objects.length()];

            for (int i = 0; i < objects.length(); i++)
            {
                JSONObject event = objects.getJSONObject(i);

                scolaryear[i] = event.getString("scolaryear");
                codeacti[i] = event.getString("codeacti");
                codeinstance[i] = event.getString("codeinstance");
                codemodule[i] = event.getString("codemodule");
                actititle[i] = event.getString("acti_title");
                nbhours[i] = event.getString("nb_hours");
                starthours[i] = event.getString("start");
                endhours[i] = event.getString("end");
            }
        } catch (JSONException e) { }
    }

    public static void      setObjects(JSONArray newarray)
    {
        try {
            objects = new JSONArray(newarray.toString());
        } catch (JSONException e) { }
    }
}
