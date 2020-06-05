package com.iamstmvasan.programingmcq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;


public class Exam extends AppCompatActivity {
    Toolbar toolbar2;
    TextView questionIndicator , questionScreen , timer;
    Button option1 , option2 , option3 , option4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        toolbar2 = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);
        getSupportActionBar().setTitle("Programing MCQ");
        toolbar2.setTitleTextColor(Color.parseColor("#34495E"));

        questionIndicator = findViewById(R.id.questionIndicator);
        questionIndicator.setText(String.valueOf(1+" / "+Profile.questionNumber));
        questionScreen = findViewById(R.id.questionScreen);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        timer = findViewById(R.id.timer);

        reverseTimer(Profile.questionNumber*10,timer);
    }
    public void reverseTimer(int Seconds,final TextView tv){

        new CountDownTimer(Seconds* 1000+1000, 1000) {

            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                tv.setText(String.format("%02d", minutes)
                        + " : " + String.format("%02d", seconds));
            }

            public void onFinish() {
                tv.setText("Completed");
                Intent myIntent = new Intent(Exam.this,Result.class);
                startActivity(myIntent);
            }
        }.start();
    }
}

