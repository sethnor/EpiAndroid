package eu.epitech.sami.epiandroid.Tasks;

import android.os.Looper;

import org.json.JSONException;

import eu.epitech.sami.epiandroid.EpiRestClientUsage;

/**
 * Created by tester on 27/01/2016.
 */
public class connectTask implements Runnable {
    public static String            login;
    public static String            password;

    public connectTask(String l, String p)
    {
        login = l;
        password = p;
    }

    @Override
    public void run() {
        Looper.prepare();
        EpiRestClientUsage usage = new EpiRestClientUsage();

        try {
            usage.connectAndReturnToken(login, password);
        }
        catch (JSONException e) { }
    }
}
