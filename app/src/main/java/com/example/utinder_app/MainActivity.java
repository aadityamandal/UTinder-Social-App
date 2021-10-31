package com.example.utinder_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text1 = findViewById(R.id.textView1);
        final Button btn_to_dashboard = (Button)findViewById(R.id.button2);
        final EditText email = findViewById(R.id.email_txt);
        final Button btn_to_pomodoro = (Button)findViewById(R.id.pomodoro_btn);


        btn_to_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dashboard_intent = new Intent(MainActivity.this, Dashboard.class);
                String strEmail = email.getText().toString();

//                User new_user = new User("admin2", strEmail, "password123");
//                UserData test = new UserData();
//                test.addUserData(new_user);

                dashboard_intent.putExtra("uoft email", strEmail);
                startActivity(dashboard_intent);
                text1.setText("Hello");

            }
        });

        btn_to_pomodoro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pomodoro_intent = new Intent(MainActivity.this, Pomodoro.class);
                startActivity(pomodoro_intent);

            }
        });

    }
}