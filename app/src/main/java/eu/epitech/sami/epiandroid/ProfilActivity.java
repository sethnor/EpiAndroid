package eu.epitech.sami.epiandroid;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import eu.epitech.sami.epiandroid.Tasks.messagesTask;
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
        final TextView ViewNs = (TextView) findViewById(R.id.profil_nsstat_text);
        final ImageView ViewPicture = (ImageView) findViewById(R.id.profil_image);
        final ListView ViewMessages =(ListView) findViewById(R.id.profil_list);

        Thread t = new Thread(new userTask(EpiRestClient.model.token.token, EpiRestClient.model.token.login));
        Thread t2 = new Thread(new messagesTask(EpiRestClient.model.token.token));
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) { }

        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) { }

        EpiRestClient.model.user.parseUser();
        EpiRestClient.model.messages.parseMessages();
        Viewlogin.setText("login : " + EpiRestClient.model.user.login);
        ViewCurrentCredits.setText("Current credits : " + EpiRestClient.model.user.credits);
        ViewFullName.setText("Name : " + EpiRestClient.model.user.fullName);
        ViewEmail.setText("Email : " + EpiRestClient.model.user.email);
        ViewSemester.setText("Current semester : " + EpiRestClient.model.user.semester);
        ViewPromo.setText("Promo : " + EpiRestClient.model.user.promo);
        ViewNs.setText("Active log : " + EpiRestClient.model.user.nsStat);

/*        System.out.println(EpiRestClient.model.user.picturePath);

        try {
            URL url = new URL(EpiRestClient.model.user.picturePath);
            URLConnection connection = url.openConnection();
            InputStream in = null;

            if (!(connection instanceof HttpURLConnection))
                throw new Exception("Not an http connection");
            try {
                HttpURLConnection httpconnection = (HttpURLConnection) connection;
                httpconnection.setAllowUserInteraction(false);
                httpconnection.setInstanceFollowRedirects(true);
                httpconnection.setRequestMethod("GET");
                httpconnection.connect();
                int response = httpconnection.getResponseCode();
                if (response == HttpURLConnection.HTTP_OK)
                {
                    in = httpconnection.getInputStream();
                }
            } catch (Exception e) { }

            Bitmap bitmap = null;

            bitmap = BitmapFactory.decodeStream(in);
            in.close();
            ViewPicture.setImageBitmap(bitmap);
        } catch (Exception e) { System.out.println("Can't access picture"); }*/
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, EpiRestClient.model.messages.title);
        ViewMessages.setAdapter(adapter);

        final Button buttonGrades = (Button) findViewById(R.id.button_grades);

        buttonGrades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent grades = new Intent(ProfilActivity.this, GradesActivity.class);
                startActivity(grades);
            }
        });

        final Button buttonProjects = (Button) findViewById(R.id.button_projects);

        buttonProjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent projects = new Intent(ProfilActivity.this, ProjectsActivity.class);
                startActivity(projects);
            }
        });
    }
}
