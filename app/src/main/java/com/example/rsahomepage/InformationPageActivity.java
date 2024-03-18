package com.example.rsahomepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class InformationPageActivity extends AppCompatActivity {

    TextView web1;
    TextView web2;
    TextView web3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_page);

        //articles
        TextView textView  = findViewById(R.id.textview);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        TextView textView1 = findViewById(R.id.textview1);
        textView1.setMovementMethod(LinkMovementMethod.getInstance());

        TextView textView2 = findViewById(R.id.textView2);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());

        //videos
        TextView textView3  = findViewById(R.id.textview3);
        textView3.setMovementMethod(LinkMovementMethod.getInstance());

        TextView textView4 = findViewById(R.id.textview4);
        textView4.setMovementMethod(LinkMovementMethod.getInstance());

        TextView textView5 = findViewById(R.id.textview5);
        textView5.setMovementMethod(LinkMovementMethod.getInstance());


        web1 = findViewById(R.id.btn1);
        web1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURL("https://www.theatlantic.com/magazine/archive/2005/10/lincolns-great-depression/304247/");
            }
        });

        web2 = findViewById(R.id.btn2);
        web2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURL("https://abcnews.go.com/GMA/Culture/dwayne-rock-johnson-shares-struggles-depression/story?id=99320228");
            }
        });

        web3 = findViewById(R.id.btn3);
        web3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURL("https://www.menshealth.com/uk/mental-strength/a758320/watch-why-chris-evans-still-gets-anxiety-about-captain-america/");
            }
        });



    }

    void gotoURL(String s) {
        try {
            Uri uri = Uri.parse(s);
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "No Website Linked", Toast.LENGTH_SHORT).show();
        }
    }
}