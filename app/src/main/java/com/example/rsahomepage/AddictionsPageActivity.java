package com.example.rsahomepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddictionsPageActivity extends AppCompatActivity {
    Button drugButton;
    Button anxietyDepressionButton;
    Button gamblingButton;
    Button alcoholButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addictions_page);
        drugButton = findViewById(R.id.DrugButton);
        anxietyDepressionButton = findViewById(R.id.AnxietyDepressionButton);
        gamblingButton = findViewById(R.id.GamblingButton);
        alcoholButton = findViewById(R.id.AlcoholButton);
        drugButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddictionsPageActivity.this, Drugs.class);
                startActivity(intent);
            }
        });
        anxietyDepressionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddictionsPageActivity.this, AnxietyDepression.class);
                startActivity(intent);
            }
        });
        gamblingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddictionsPageActivity.this, Gambling.class);
                startActivity(intent);
            }
        });
        alcoholButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddictionsPageActivity.this, Alcohol.class);
                startActivity(intent);
            }
        });
    }
}