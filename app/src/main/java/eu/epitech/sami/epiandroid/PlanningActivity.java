package eu.epitech.sami.epiandroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import eu.epitech.sami.epiandroid.Tasks.planningTask;

public class PlanningActivity extends AppCompatActivity {
    public static String    todayDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(c.getTime());

        final TextView txt = (TextView) findViewById(R.id.textView);
        final ListView list = (ListView) findViewById(R.id.listView);

        System.out.println(date);
        txt.setText(date);

        Thread t1 = new Thread(new planningTask(EpiRestClient.model.token.token, date, date));
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) { return ; }

        EpiRestClient.model.planning.parsePlanning();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, EpiRestClient.model.planning.actititle);
        list.setAdapter(adapter);
    }

}
