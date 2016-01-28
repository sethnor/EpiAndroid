package eu.epitech.sami.epiandroid.Tasks;

import android.os.Looper;

import org.json.JSONException;

import eu.epitech.sami.epiandroid.EpiRestClientUsage;

/**
 * Created by tester on 28/01/2016.
 */
public class messagesTask implements Runnable {
    public static String    token;

    public messagesTask(String t)
    {
        token = t;
    }

    @Override
    public void run()
    {
        Looper.prepare();
        EpiRestClientUsage usage = new EpiRestClientUsage();
        try {
            usage.getMessage(token);
        } catch (JSONException e) { }
    }
}
