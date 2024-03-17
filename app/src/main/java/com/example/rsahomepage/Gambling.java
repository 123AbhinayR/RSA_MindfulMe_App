package com.example.rsahomepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Gambling extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gambling);
        ImageButton backButton3 = findViewById(R.id.backButton3);
        backButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gambling.this, AddictionsPageActivity.class);
                startActivity(intent);
            }
        });
        ImageView Art1 = findViewById(R.id.GamblingArt1);
        Art1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.forbes.com/health/mind/how-to-stop-gambling-expert-advice/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        ImageView Art2 = findViewById(R.id.GamblingArt2);
        Art2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.hollandhospital.org/healthy-life/articles/mark-bombara-ma-llp-lmsw-caadc/you-can-overcome-gambling-addiction";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        ImageView Art3 = findViewById(R.id.GamblingArt3);
        Art3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.helpguide.org/articles/addictions/gambling-addiction-and-problem-gambling.htm";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        ImageView Art4 = findViewById(R.id.GamblingArt4);
        Art4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.latimes.com/business/story/2024-01-20/gambling-risks-rise-for-young-people-how-to-lower-the-stakes";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        ImageView Art5 = findViewById(R.id.GamblingArt5);
        Art5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://steverosephd.com/how-to-stop-betting-on-sports/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}