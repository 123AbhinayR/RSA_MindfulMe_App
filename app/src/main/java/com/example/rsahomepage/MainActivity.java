package com.example.rsahomepage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public CardView card1, card2, card3, card4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        card1 = (CardView) findViewById(R.id.c1);
        card2 = (CardView) findViewById(R.id.c2);
        card3 = (CardView) findViewById(R.id.c3);
        card4 = (CardView) findViewById(R.id.c4);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);

        Button button = findViewById(R.id.chatbot_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChatbotActivity.class);
                startActivity(intent);
            }
        });

        Button button2 = findViewById(R.id.survey_button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SurveyActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {
        Intent i;

        int id = v.getId();
        if (id == R.id.c1) {
            i = new Intent(this, MeditationPageActivity.class);
            startActivity(i);
        } else if (id == R.id.c2) {
            i = new Intent(this, InformationPageActivity.class);
            startActivity(i);
        } else if (id == R.id.c3) {
            i = new Intent(this, AddictionsPageActivity.class);
            startActivity(i);
        } else if (id == R.id.c4) {
            i = new Intent(this, JournalPageActivity.class);
            startActivity(i);
        }
    }

}