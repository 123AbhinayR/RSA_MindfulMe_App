package com.example.rsahomepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

public class InformationPageActivity extends AppCompatActivity {

    Button btn1;
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
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        TextView textView4 = findViewById(R.id.textview4);
        textView1.setMovementMethod(LinkMovementMethod.getInstance());

        TextView textView5 = findViewById(R.id.textview5);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());

        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPopUpWindow();
            }
        });
    }

    private void openPopUpWindow() {
        Intent popUpWindow = new Intent(InformationPageActivity.this, PopupWindow.class);
        startActivity(popUpWindow);
    }
}