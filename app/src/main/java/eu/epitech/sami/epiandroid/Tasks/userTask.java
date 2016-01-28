package eu.epitech.sami.epiandroid.Tasks;

import android.os.Looper;

import org.json.JSONException;

import eu.epitech.sami.epiandroid.EpiRestClientUsage;

/**
 * Created by tester on 27/01/2016.
 */
public class userTask implements Runnable {
    public static String            token;
    public static String            user;

    public userTask(String t, String u)
    {
        token = t;
        user = u;
    }

    @Override
    public void run() {
        Looper.prepare();
        EpiRestClientUsage usage = new EpiRestClientUsage();

        try {
            usage.getUserInfo(token, user);
        }
        catch (JSONException e) { }
    }
}