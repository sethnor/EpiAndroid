package eu.epitech.sami.epiandroid.Tasks;

import android.os.Looper;

import org.json.JSONException;

import eu.epitech.sami.epiandroid.EpiRestClientUsage;

/**
 * Created by tester on 28/01/2016.
 */
public class allModulesTask implements Runnable {
    public static String        token;
    public static int           scolaryear;
    public static String        location;
    public static String        course;

    public allModulesTask(String t, int s, String l, String c)
    {
        token = t;
        scolaryear = s;
        location = l;
        course = c;
    }

    @Override
    public void run()
    {
        Looper.prepare();
        EpiRestClientUsage usage = new EpiRestClientUsage();
        try {
            usage.getAllModules(token, scolaryear, location, course);
        } catch (JSONException e) { }
    }
}
