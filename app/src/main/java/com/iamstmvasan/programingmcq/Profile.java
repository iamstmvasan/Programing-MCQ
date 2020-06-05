package com.iamstmvasan.programingmcq;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {
    Toolbar toolbar;
    ImageView userImage;
    TextView userName;
    Button courseName , courseNext , abilityName , abilityNext , startExam , noOfQuestion;
    SeekBar questionSeekbar;

    private int courseIndex = 0 , abilityIndex = 0;
    public static String courseSelection = "", abilitySelection ="";
    public static int questionNumber = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Programing MCQ");
        toolbar.setTitleTextColor(Color.parseColor("#34495E"));

        userImage = findViewById(R.id.usr_img);
        userName = findViewById(R.id.usr_name);
        courseName = findViewById(R.id.courseName);
        courseNext = findViewById(R.id.courseNext);
        abilityName = findViewById(R.id.abilityName);
        abilityNext = findViewById(R.id.abilityNext);
        startExam = findViewById(R.id.startExam);

        noOfQuestion = findViewById(R.id.noOfQuestion);
        questionSeekbar = findViewById(R.id.questionSeekBar);
        questionSeekbar.setMax(30);

        final String[] course = {"C","Java","Python"};
        final String[] ability = {"Easy","Medium","Hard"};

        courseNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                courseName.setText(course[courseIndex++]);
                if(courseIndex == 3){
                    courseIndex = 0;
                }

            }
        });
        abilityNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abilityName.setText(ability[abilityIndex++]);
                if(abilityIndex == 3){
                    abilityIndex = 0;
                }
            }
        });

        startExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = true;
                if(courseName.getText().toString().equalsIgnoreCase("Click next")){
                    flag = false;
                    Toast.makeText(Profile.this, "Invalid Course Selection", Toast.LENGTH_SHORT).show();
                }
                if(abilityName.getText().toString().equalsIgnoreCase("Click next")){
                    flag = false;
                    Toast.makeText(Profile.this, "Invalid Ability Selection", Toast.LENGTH_SHORT).show();
                }
                if(questionNumber == 0){
                    flag = false;
                    Toast.makeText(Profile.this, "Invalid No. of question Selection", Toast.LENGTH_SHORT).show();
                }
                if(flag){
                    courseSelection = courseName.getText().toString();
                    abilitySelection = abilityName.getText().toString();
                    startActivity(new Intent(Profile.this , Exam.class));
                }
            }
        });

        questionSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                questionNumber = questionSeekbar.getProgress();
                noOfQuestion.setText(String.valueOf(questionNumber));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.about){
            Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();

        }
        if(item.getItemId() == R.id.sign_out){
            Toast.makeText(this, "Sign out", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
