package com.example.rsahomepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Drugs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drugs);
        ImageButton backButton1 = findViewById(R.id.backButton1);
        backButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Drugs.this, AddictionsPageActivity.class);
                startActivity(intent);
            }
        });
        ImageView Art1 = findViewById(R.id.DrugsArt1);
        Art1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://americanaddictioncenters.org/rehab-guide/overcoming-addiction";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        ImageView Art2 = findViewById(R.id.DrugsArt2);
        Art2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.helpguide.org/articles/addictions/overcoming-drug-addiction.htm";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        ImageView Art3 = findViewById(R.id.DrugsArt3);
        Art3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://nida.nih.gov/publications/drugs-brains-behavior-science-addiction/treatment-recovery";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        ImageView Art4 = findViewById(R.id.DrugsArt4);
        Art4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.mayoclinic.org/diseases-conditions/drug-addiction/symptoms-causes/syc-20365112";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        ImageView Art5 = findViewById(R.id.DrugsArt5);
        Art5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://kidshealth.org/en/teens/addictions.html";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}