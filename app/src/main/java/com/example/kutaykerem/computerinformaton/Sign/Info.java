package com.example.kutaykerem.computerinformaton.Sign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ProgressBar;

import com.example.kutaykerem.computerinformaton.R;

public class Info extends AppCompatActivity {


    CountDownTimer countDownTimer;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState );
        setContentView(R.layout.activity_info);

        progressBar = findViewById(R.id.info_progressbar);

        countDownTimer = new CountDownTimer(1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(Info.this, UserLogin.class);
                startActivity(intent);

            }
        }.start();


        waiit();
    }

    public void waiit(){

        CountDownTimer countDownTimer2;


        countDownTimer2 = new CountDownTimer(1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

                Intent intent = new Intent(Info.this,UserLogin.class);
                startActivity(intent);

            }
        }.start();



    }




}
