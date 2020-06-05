package com.iamstmvasan.programingmcq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;

public class start extends AppCompatActivity {
    ImageView l1 , l2 , l3 , l4 , l5 ;
    private boolean l1_b = true , l2_b , l3_b , l4_b , l5_b = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);
        l3 = findViewById(R.id.l3);
        l4 = findViewById(R.id.l4);
        l5 = findViewById(R.id.l5);

        new CountDownTimer(5000 , 500) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(l1_b){
                    l1.setImageResource(R.drawable.loading_grey);
                    l2.setImageResource(R.drawable.loading_grey);
                    l3.setImageResource(R.drawable.loading_grey);
                    l4.setImageResource(R.drawable.loading_grey);
                    l5.setImageResource(R.drawable.loading_grey);
                    l1_b = false;
                    l2_b = true;
                    l1.setImageResource(R.drawable.loading_blue);
                }
                else if(l2_b){
                    l2_b = false;
                    l3_b = true;
                    l2.setImageResource(R.drawable.loading_blue);
                }
                else if(l3_b){
                    l3_b = false;
                    l4_b = true;
                    l3.setImageResource(R.drawable.loading_blue);
                }
                else if(l4_b){
                    l4_b = false;
                    l5_b = true;
                    l4.setImageResource(R.drawable.loading_blue);
                }
                else if(l5_b){
                    l5_b = false;
                    l1_b = true;
                    l5.setImageResource(R.drawable.loading_blue);
                }


            }

            @Override
            public void onFinish() {
                startActivity(new Intent(start.this , MainActivity.class));

            }
        }.start();
    }
}
