package com.example.rsahomepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Transition extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 3000);
    }
}