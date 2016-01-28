package eu.epitech.sami.epiandroid;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by tester on 27/01/2016.
 */
public class User {
    public static JSONObject object = new JSONObject();

    public static void          parseUser() {
    }

    public static void         setObject(JSONObject newobject)
    {
        System.out.println("Copying jsonobject");
        try {
            object = new JSONObject(newobject.toString());
        } catch (JSONException e) { System.out.println("Copying jsonobject failed"); }
    }
}
