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
import android.widget.ListView;
import android.widget.TextView;

import eu.epitech.sami.epiandroid.Tasks.moduleUserTask;

public class GradesActivity extends AppCompatActivity {

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

        ListView ViewModules = (ListView) findViewById(R.id.profil_list);

        Thread t3 = new Thread(new moduleUserTask(EpiRestClient.model.token.token));
        t3.start();
        try {
            t3.join();
        } catch (InterruptedException e) { }
        EpiRestClient.model.usermodules.parseUserModule();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, EpiRestClient.model.usermodules.title);
        ViewModules.setAdapter(adapter);
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

        int scolaryear = EpiRestClient.model.usermodules.scolaryear[position];
        String codemodule = EpiRestClient.model.usermodules.codemodule[position];
        String title = EpiRestClient.model.usermodules.title[position];
        String grade = EpiRestClient.model.usermodules.grades[position];
        int credits = EpiRestClient.model.usermodules.credits[position];

        ViewScolaryear.setText("Année scolaire : " + String.valueOf(scolaryear));
        ViewCodemodule.setText("Code du module : " + codemodule);
        ViewTitle.setText("Titre du module : " + title);
        ViewGrade.setText("Grade : " + grade);
        ViewCredit.setText("Credits : " + String.valueOf(credits));

        alert.setTitle(title);
        alert.setView(alertLayout);
        alert.setCancelable(true);
        AlertDialog dialog = alert.create();
        dialog.show();
    }
}
