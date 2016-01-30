package eu.epitech.sami.epiandroid.Tasks;

import android.os.Looper;

import org.json.JSONException;

import eu.epitech.sami.epiandroid.EpiRestClientUsage;

/**
 * Created by tester on 29/01/2016.
 */
public class validateTokenTask implements Runnable {
    public static String        token;
    public static int           scolaryear;
    public static String        codemodule;
    public static String        codeinstance;
    public static String        codeacti;
    public static String        codeevent;
    public static String        tokenvalidationcode;

    public validateTokenTask(String t, int s, String cm, String ci, String ca, String ce, String tvc)
    {
        token = t;
        scolaryear = s;
        codemodule = cm;
        codeinstance = ci;
        codeacti = ca;
        codeevent = ce;
        tokenvalidationcode = tvc;
    }

    @Override
    public void run()
    {
        Looper.prepare();
        EpiRestClientUsage usage = new EpiRestClientUsage();
        try {
            usage.validateToken(token, scolaryear, codemodule, codeinstance, codeacti, codeevent, tokenvalidationcode);
        } catch (JSONException e) { }
    }
}
