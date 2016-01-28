package eu.epitech.sami.epiandroid.Tasks;

import android.os.Looper;

import org.json.JSONException;

import eu.epitech.sami.epiandroid.EpiRestClientUsage;

/**
 * Created by tester on 28/01/2016.
 */
public class subscribeModuleTask implements Runnable {
    public static String token;
    public static int   scolaryear;
    public static String codemodule;
    public static String codeinstance;

    public subscribeModuleTask(String t, int s, String cm, String ci)
    {
        token = t;
        scolaryear = s;
        codemodule = cm;
        codeinstance = ci;
    }

    @Override
    public void run()
    {
        Looper.prepare();
        try {
            EpiRestClientUsage usage = new EpiRestClientUsage();

            usage.SubscribeToModule(token, scolaryear, codemodule, codeinstance);
        } catch (JSONException e) { }
    }
}
