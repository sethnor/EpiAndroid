package eu.epitech.sami.epiandroid;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by tester on 28/01/2016.
 */
public class Infos {
    public static String login = "null";
    public static int currentCredits = 0;
    public static int progressCredits = 60;
    public static int failedCredits = 0;
    public static int semester = 0;
    public static int promo = 2018;
    public static String log = "0";
    public static JSONObject object = new JSONObject();

    public static void      parseInfos()
    {
        try {
            JSONObject infos = object.getJSONObject("infos");

            login = infos.getString("login");
            semester = infos.getInt("semester");
            promo = infos.getInt("promo");
/*            currentCredits = object.getInt("achieved");
            progressCredits = object.getInt("inprogress");
            failedCredits = object.getInt("failed");
            log = object.getString("active_log");*/
        } catch (JSONException e) {
            System.out.println("Parsing user failed");
        }
    }

    public static void         setObject(JSONObject newobject)
    {
        System.out.println("Copying jsonobject");
        try {
            object = new JSONObject(newobject.toString());
        } catch (JSONException e) { System.out.println("Copying jsonobject failed"); }
    }
}
