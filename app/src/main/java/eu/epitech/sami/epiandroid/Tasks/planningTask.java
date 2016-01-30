package eu.epitech.sami.epiandroid.Tasks;

import android.os.Looper;

import org.json.JSONException;

import eu.epitech.sami.epiandroid.EpiRestClientUsage;

/**
 * Created by tester on 30/01/2016.
 */
public class planningTask implements Runnable {
    public static String        token;
    public static String        start;
    public static String        end;

    public planningTask(String t, String s, String e)
    {
        token = t;
        start = s;
        end = e;
    }

    @Override
    public void run()
    {
        EpiRestClientUsage usage = new EpiRestClientUsage();

        Looper.prepare();
        try {
            usage.getPlanning(token, start, end);
        } catch (JSONException e) { }
    }
}
