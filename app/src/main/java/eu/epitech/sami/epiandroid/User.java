package eu.epitech.sami.epiandroid;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by tester on 27/01/2016.
 */
public class User {
    public static String     login = "null";
    public static String     fullName = "null";
    public static String     email = "null";
    public static String     picturePath = "null";
    public static int        promo = 0;
    public static int        semester = 0;
    public static int        credits = 0;
    public static int        nsStat = 0;
    public static int        year = 0;
    public static String     location = "null";
    public static String     course = "null";
    public static JSONObject object = new JSONObject();

    public static void          parseUser() {
        try {
            JSONObject          nsstat = object.getJSONObject("nsstat");

            login = object.getString("login");
            fullName = object.getString("title");
            email = object.getString("internal_email");
            picturePath = object.getString("picture");
            promo = object.getInt("promo");
            semester = object.getInt("semester");
            credits = object.getInt("credits");
            nsStat = nsstat.getInt("active");
            location = object.getString("location");
            course = object.getString("course_code");
            year = object.getInt("studentyear");
        } catch (JSONException e) {
            System.out.println("Failed parseUser");
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
