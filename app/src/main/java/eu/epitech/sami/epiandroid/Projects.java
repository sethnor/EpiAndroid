package eu.epitech.sami.epiandroid;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by tester on 28/01/2016.
 */
public class Projects {
    // tous les projets disponibles
    public static String[]    codemodule_all;
    public static String[]    project_all;
    public static String[]    title_all;
    public static String[]    scolaryear_all;
    public static int[]       registred_all;
    public static String[]    codeacti_all;
    public static String[]    codeinstance_all;
    public static String[]    begin_all;

    // tous les projets inscrits
    public static String[]    codemodule_rg;
    public static String[]    project_rg;
    public static String[]    title_rg;
    public static String[]    scolaryear_rg;
    public static int[]       registred_rg;
    public static String[]    codeacti_rg;
    public static String[]    codeinstance_rg;
    public static String[]    begin_rg;

    public static JSONArray   objects;

    public static void        parseAllprojects()
    {
        try {
            codemodule_all = new String[objects.length()];
            project_all = new String[objects.length()];
            title_all = new String[objects.length()];
            scolaryear_all = new String[objects.length()];
            registred_all = new int[objects.length()];
            codeacti_all = new String[objects.length()];
            codeinstance_all = new String[objects.length()];
            begin_all = new String[objects.length()];

            for (int i = 0; i < objects.length(); i++)
            {
                JSONObject  project = objects.getJSONObject(i);

                codemodule_all[i] = project.getString("codemodule");
                project_all[i] = project.getString("project");
                title_all[i] = project.getString("acti_title");
                scolaryear_all[i] = project.getString("scolaryear");
                registred_all[i] = project.getInt("registered");
                codeacti_all[i] = project.getString("codeacti");
                codeinstance_all[i] = project.getString("codeinstance");
                begin_all[i] = project.getString("begin_acti");
            }
        } catch (JSONException e) { System.out.println("parseAllProjects failed"); }
    }

    public static void        parseRegistredProjects()
    {
        int y = 0;

        for (int i = 0; i < objects.length(); i++)
        {
            if (registred_all[i] == 1)
                y++;
        }
        codemodule_rg = new String[y];
        project_rg = new String[y];
        title_rg = new String[y];
        scolaryear_rg = new String[y];
        registred_rg = new int[y];
        codeacti_rg = new String[y];
        codeinstance_rg = new String[y];
        begin_rg = new String[y];
        y = 0;
        for (int i = 0; i < objects.length(); i++)
        {
            if (registred_all[i] == 1)
            {
                codemodule_rg[y] = codemodule_all[i];
                project_rg[y] = project_all[i];
                title_rg[y] = title_all[i];
                scolaryear_rg[y] = scolaryear_all[i];
                registred_rg[y] = registred_all[i];
                codeacti_rg[y] = codeacti_all[i];
                codeinstance_rg[y] = codeinstance_all[i];
                begin_rg[y] = begin_all[i];
                y++;
            }
        }
    }

    public static void        setArray(JSONArray newarray)
    {
        try {
            objects = new JSONArray(newarray.toString());
        } catch (JSONException e) { }
    }
}
