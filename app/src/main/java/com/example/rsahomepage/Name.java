package com.example.rsahomepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Name extends AppCompatActivity {


    public EditText aName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        aName = findViewById(R.id.name);
    }
    public void returnClick (View view){
        Intent intent = new Intent(Name.this, MainActivity.class);
        String theName = aName.getText().toString();
        intent.putExtra("name",theName);
        startActivity(intent);
    }
}