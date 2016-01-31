package eu.epitech.sami.epiandroid.Tasks;

import android.os.Looper;

import org.json.JSONException;

import eu.epitech.sami.epiandroid.EpiRestClientUsage;

/**
 * Created by tester on 31/01/2016.
 */
public class subscribeEventTask implements Runnable {
    public static String        token;
    public static int           scolaryear;
    public static String        codemodule;
    public static String        codeinstance;
    public static String        codeacti;
    public static String        codeevent;

    public subscribeEventTask(String t, int s, String cm, String ci, String ca, String ce)
    {
        token = t;
        scolaryear = s;
        codemodule = cm;
        codeinstance = ci;
        codeacti = ca;
        codeevent = ce;
    }

    @Override
    public void run()
    {
        Looper.prepare();
        EpiRestClientUsage usage = new EpiRestClientUsage();
        try {
            usage.subscribeToEvent(token, scolaryear, codemodule, codeinstance, codeacti,codeevent);
        } catch (JSONException e) { }
    }
}
