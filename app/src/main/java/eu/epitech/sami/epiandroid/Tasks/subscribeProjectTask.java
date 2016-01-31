package eu.epitech.sami.epiandroid.Tasks;

import android.os.Looper;

import org.json.JSONException;

import eu.epitech.sami.epiandroid.EpiRestClientUsage;

/**
 * Created by tester on 31/01/2016.
 */
public class subscribeProjectTask implements Runnable {
    public static String        token;
    public static int           scolaryear;
    public static String        codemodule;
    public static String        codeinstance;
    public static String        codeacti;

    public subscribeProjectTask(String t, int s, String cm, String ci, String ca)
    {
        token = t;
        scolaryear = s;
        codemodule = cm;
        codeinstance = ci;
        codeacti = ca;
    }

    @Override
    public void run()
    {
        Looper.prepare();
        EpiRestClientUsage usage = new EpiRestClientUsage();
        try {
            usage.subscribeToProject(token, scolaryear, codemodule, codeinstance, codeacti);
        } catch (JSONException e) { }
    }
}
