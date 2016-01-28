package eu.epitech.sami.epiandroid;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import eu.epitech.sami.epiandroid.Tasks.projectsUserTask;

public class ProjectsActivity extends AppCompatActivity {
    public static boolean       userProjects = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final Button userProjectsButton = (Button) findViewById(R.id.button_user_projects);
        final Button allProjectsButton = (Button) findViewById(R.id.button_all_projects);

        Thread t1 = new Thread(new projectsUserTask(EpiRestClient.model.token.token));
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) { }

        EpiRestClient.model.projects.parseAllprojects();
        EpiRestClient.model.projects.parseRegistredProjects();
        setListData();

        userProjectsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!userProjects) {
                    userProjects = true;
                    setListData();
                }
            }
        });
        allProjectsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userProjects) {
                    userProjects = false;
                    setListData();
                }
            }
        });
    }
    public void setListData()
    {
        final ListView ViewProjects = (ListView) findViewById(R.id.profil_list);

        if (userProjects) {
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, EpiRestClient.model.projects.title_rg);
            ViewProjects.setAdapter(adapter);
        }
        else
        {
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, EpiRestClient.model.projects.title_all);
            ViewProjects.setAdapter(adapter);
        }
        ViewProjects.setClickable(true);
        ViewProjects.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                createModuleAlertDialog(position);
            }
        });
    }

    public void createModuleAlertDialog(int position)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.project_alert_layout, null);

        final TextView ViewInfo = (TextView) alertLayout.findViewById(R.id.project_info_text);
        final TextView ViewTitle = (TextView) alertLayout.findViewById(R.id.project_title_text);
        final TextView ViewCodemodule = (TextView) alertLayout.findViewById(R.id.project_codemodule_text);
        final TextView ViewRegistred = (TextView) alertLayout.findViewById(R.id.project_registred_text);
        final TextView ViewScolaryear = (TextView) alertLayout.findViewById(R.id.project_scolaryear_text);
        final TextView ViewBegin = (TextView) alertLayout.findViewById(R.id.project_begin_text);
        String info;
        String title;
        String codemodule;
        String registred;
        String scolaryear;
        String begin;

        if (userProjects) {
            scolaryear = EpiRestClient.model.projects.scolaryear_rg[position];
            codemodule = EpiRestClient.model.projects.codemodule_rg[position];
            title = EpiRestClient.model.projects.title_rg[position];
            info = EpiRestClient.model.projects.project_rg[position];
            registred = String.valueOf(EpiRestClient.model.projects.registred_rg[position]);
            begin = EpiRestClient.model.projects.begin_rg[position];
            ViewInfo.setText(info);
            ViewTitle.setText("Titre : " + title);
            ViewCodemodule.setText("Codemodule : " + codemodule);
            ViewRegistred.setText("Inscrit : " + registred);
            ViewScolaryear.setText("Année : " + scolaryear);
            ViewBegin.setText("Début : " + begin);
        }
        else
        {
            scolaryear = EpiRestClient.model.projects.scolaryear_all[position];
            codemodule = EpiRestClient.model.projects.codemodule_all[position];
            title = EpiRestClient.model.projects.title_all[position];
            info = EpiRestClient.model.projects.project_all[position];
            registred = String.valueOf(EpiRestClient.model.projects.registred_all[position]);
            begin = EpiRestClient.model.projects.begin_all[position];
            ViewInfo.setText(info);
            ViewTitle.setText("Titre : " + title);
            ViewCodemodule.setText("Codemodule : " + codemodule);
            ViewRegistred.setText("Inscrit : " + registred);
            ViewScolaryear.setText("Année : " + scolaryear);
            ViewBegin.setText("Début : " + begin);
        }
        alert.setView(alertLayout);
        alert.setCancelable(true);
        AlertDialog dialog = alert.create();
        dialog.show();
    }
}
