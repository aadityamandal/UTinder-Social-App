package com.example.utinder_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.time.*;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;

public class Dashboard extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        UserData data = new UserData();
        //Get transfered info
        Intent email_intent = getIntent();
        String uoft_email = email_intent.getStringExtra("uoft email");


        //OPTION 1 - find username from email
        String morning_greet = "Good Morning, " + data.findNickfromEmail(uoft_email);
        String afternoon_greet = "Good Afternoon, " + data.findNickfromEmail(uoft_email);
        String evening_greet = "Good Evening, " + data.findNickfromEmail(uoft_email);

        //OPTION 2 - find name from first word of email
//        String [] email_split = uoft_email.split(".");
//        String first_name = email_split[0];
//        String morning_greet = "Good Morning, " + first_name.substring(0, 1).toUpperCase() +
//                first_name.substring(1);
//        String evening_greet = "Good Evening, " + first_name.substring(0, 1).toUpperCase() +
//                first_name.substring(1);

        // Greeting based on Time
        LocalTime datetime = LocalTime.now();
        LocalDate date_date = LocalDate.now();
        final TextView greeting = findViewById(R.id.greetings_txt);
        final TextView date = findViewById(R.id.date_txt);
        if(datetime.getHour() < 12){
            greeting.setText(morning_greet);
        }else if(datetime.getHour() >= 12 && datetime.getHour() < 17) {
            greeting.setText(afternoon_greet);
        }else greeting.setText(evening_greet);
        String date_sm = "Today is " + date_date.getDayOfMonth() + " " + date_date.getMonth().toString() + ", " + date_date.getYear();
        date.setText(date_sm);



        final ListView lst_of_tasks = findViewById(R.id.tasks_listview);
        ArrayList<String> tasks_arrlst = new ArrayList<>();

        tasks_arrlst.add("finish CS assignment");
        tasks_arrlst.add("finish physics lab");
        tasks_arrlst.add("exersize");
        tasks_arrlst.add("finish R Lab 1");

        UserData tst = new UserData();

        // TODO: Add the input for Tasks
        // TODO: Add a My Courses option
        // TODO: Try to program a input for classes in My Courses


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, tasks_arrlst);
        lst_of_tasks.setAdapter(arrayAdapter);
    }
}
