package com.iamstmvasan.programingmcq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    Toolbar toolbar3;
    TextView hiUser , line1 , line2 , line3;
    Button secondsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        toolbar3 = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar3);
        getSupportActionBar().setTitle("Programing MCQ");
        toolbar3.setTitleTextColor(Color.parseColor("#34495E"));

        hiUser = findViewById(R.id.hiUser);
        line1 = findViewById(R.id.line1);
        line2 = findViewById(R.id.line2);
        line3 = findViewById(R.id.line3);

        secondsButton = findViewById(R.id.secondsButton);
        line1.setText("Hope you enjoy this Exam.");
        line2.setText("your result is send to your registered mail id,kindly check it.");
        line3.setText("This page is redirect to Home page.");
        reverseSeconds(10,secondsButton);

    }
    public void reverseSeconds(int Seconds,final Button bt){

        new CountDownTimer(Seconds* 1000+1000, 1000) {

            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                bt.setText(String.format("(%02d)", seconds));
            }

            public void onFinish() {
                bt.setText("Completed");
                Intent myIntent = new Intent(Result.this,Profile.class);
                startActivity(myIntent);
            }
        }.start();
    }
}
