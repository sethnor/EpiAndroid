package eu.epitech.sami.epiandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import eu.epitech.sami.epiandroid.Tasks.infosTask;

public class ProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        final TextView Viewlogin = (TextView) findViewById(R.id.profil_login_text);
        final TextView ViewCurrentCredits = (TextView) findViewById(R.id.profil_current_credit_text);
        final TextView ViewProgressCredits = (TextView) findViewById(R.id.profil_in_progress_credit_text);
        final TextView ViewFailCredits = (TextView) findViewById(R.id.profil_fail_credit_text);
        final TextView ViewSemester = (TextView) findViewById(R.id.profil_semester_num_text);
        final TextView ViewPromo = (TextView) findViewById(R.id.profil_promo_text);
        final TextView ViewLog = (TextView) findViewById(R.id.profil_log_text);

        Thread t = new Thread(new infosTask(EpiRestClient.model.token.token));
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) { }

        EpiRestClient.model.infos.parseInfos();
        Viewlogin.setText("login : " + EpiRestClient.model.infos.login);
        ViewCurrentCredits.setText("Current credits : " + EpiRestClient.model.infos.currentCredits);
        ViewProgressCredits.setText("In progress credits : " + EpiRestClient.model.infos.progressCredits);
        ViewFailCredits.setText("Failed credits : " + EpiRestClient.model.infos.failedCredits);
        ViewSemester.setText("Current semester : " + EpiRestClient.model.infos.semester);
        ViewPromo.setText("Promo : " + EpiRestClient.model.infos.promo);
        ViewLog.setText("Active log : " + EpiRestClient.model.infos.log);
    }
}
