package eu.epitech.sami.epiandroid;

import android.app.AlertDialog;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
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

import eu.epitech.sami.epiandroid.Tasks.allModulesTask;
import eu.epitech.sami.epiandroid.Tasks.moduleUserTask;

public class GradesActivity extends AppCompatActivity {
    public static boolean          userModule = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);
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

        final Button userModuleButton = (Button) findViewById(R.id.button_user_module);
        final Button allModulesButton = (Button) findViewById(R.id.button_all_modules);
        int scolaryear = EpiRestClient.model.user.promo - EpiRestClient.model.user.year;

        Thread t1 = new Thread(new moduleUserTask(EpiRestClient.model.token.token));
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) { }

        Thread t2 = new Thread(new allModulesTask(EpiRestClient.model.token.token, scolaryear, EpiRestClient.model.user.location, EpiRestClient.model.user.course));
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
        }

        EpiRestClient.model.usermodules.parseUserModule();
        EpiRestClient.model.allmodules.parseAllModules();
        setListData();

        userModuleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!userModule) {
                    userModule = true;
                    setListData();
                }
            }
        });
        allModulesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userModule) {
                    userModule = false;
                    setListData();
                }
            }
        });
    }

    public void setListData()
    {
        final ListView ViewModules = (ListView) findViewById(R.id.profil_list);

        if (userModule) {
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, EpiRestClient.model.usermodules.title);
            ViewModules.setAdapter(adapter);
        }
        else
        {
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, EpiRestClient.model.allmodules.title);
            ViewModules.setAdapter(adapter);
        }
        ViewModules.setClickable(true);
        ViewModules.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
        View alertLayout = inflater.inflate(R.layout.module_alert_layout, null);

        final TextView ViewScolaryear = (TextView) alertLayout.findViewById(R.id.module_scolaryear_text);
        final TextView ViewCodemodule = (TextView) alertLayout.findViewById(R.id.module_codemodule_text);
        final TextView ViewTitle = (TextView) alertLayout.findViewById(R.id.module_title_text);
        final TextView ViewGrade = (TextView) alertLayout.findViewById(R.id.module_grade_text);
        final TextView ViewCredit = (TextView) alertLayout.findViewById(R.id.module_credits_text);
        int scolaryear;
        String codemodule;
        String title;
        String grade;
        String credits;

        if (userModule) {
            scolaryear = EpiRestClient.model.usermodules.scolaryear[position];
            codemodule = EpiRestClient.model.usermodules.codemodule[position];
            title = EpiRestClient.model.usermodules.title[position];
            grade = EpiRestClient.model.usermodules.grades[position];
            credits = String.valueOf(EpiRestClient.model.usermodules.credits[position]);
            ViewScolaryear.setText("Année scolaire : " + String.valueOf(scolaryear));
            ViewCodemodule.setText("Code du module : " + codemodule);
            ViewTitle.setText("Titre du module : " + title);
            ViewGrade.setText("Grade : " + grade);
            ViewCredit.setText("Credits : " + credits);
        }
        else
        {
            scolaryear = EpiRestClient.model.allmodules.scolaryear[position];
            codemodule = EpiRestClient.model.allmodules.codemodule[position];
            title = EpiRestClient.model.allmodules.title[position];
            grade = EpiRestClient.model.allmodules.status[position];
            credits = EpiRestClient.model.allmodules.credits[position];
            ViewScolaryear.setText("Année scolaire : " + String.valueOf(scolaryear));
            ViewCodemodule.setText("Code du module : " + codemodule);
            ViewTitle.setText("Titre du module : " + title);
            ViewGrade.setText("Statut : " + grade);
            ViewCredit.setText("Credits : " + credits);
        }
        alert.setView(alertLayout);
        alert.setCancelable(true);
        AlertDialog dialog = alert.create();
        dialog.show();
    }
}
