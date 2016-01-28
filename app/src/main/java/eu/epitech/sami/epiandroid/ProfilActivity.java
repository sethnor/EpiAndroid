package eu.epitech.sami.epiandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import eu.epitech.sami.epiandroid.Tasks.userTask;

public class ProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        final TextView Viewlogin = (TextView) findViewById(R.id.profil_login_text);
        final TextView ViewCurrentCredits = (TextView) findViewById(R.id.profil_current_credit_text);
        final TextView ViewFullName = (TextView) findViewById(R.id.profil_full_name_text);
        final TextView ViewEmail = (TextView) findViewById(R.id.profil_email_text);
        final TextView ViewSemester = (TextView) findViewById(R.id.profil_semester_num_text);
        final TextView ViewPromo = (TextView) findViewById(R.id.profil_promo_text);

        Thread t = new Thread(new userTask(EpiRestClient.model.token.token, EpiRestClient.model.token.login));
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) { }

        EpiRestClient.model.user.parseUser();
        Viewlogin.setText("login : " + EpiRestClient.model.user.login);
        ViewCurrentCredits.setText("Current credits : " + EpiRestClient.model.user.credits);
        ViewFullName.setText("Nmae : " + EpiRestClient.model.user.fullName);
        ViewEmail.setText("Email : " + EpiRestClient.model.user.email);
        ViewSemester.setText("Current semester : " + EpiRestClient.model.user.semester);
        ViewPromo.setText("Promo : " + EpiRestClient.model.user.promo);
    }
}
