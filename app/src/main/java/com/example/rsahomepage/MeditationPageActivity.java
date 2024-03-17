package com.example.rsahomepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class MeditationPageActivity extends AppCompatActivity {

    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    EditText timeEditText;
    Spinner musicSpinner;
    Spinner ringtoneSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation_page);
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        timeEditText = findViewById(R.id.editTextTime);
        musicSpinner = findViewById(R.id.music_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.music_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        musicSpinner.setAdapter(adapter);
        ringtoneSpinner = findViewById(R.id.timer_noise_spinner);
        ArrayAdapter<CharSequence> ringtoneAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.ringtone_array,
                android.R.layout.simple_spinner_item
        );
        ringtoneAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ringtoneSpinner.setAdapter(ringtoneAdapter);


        Button startButton = findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimerPage();
            }
        });

        // Apply OnClickListener  to imageView to
        // switch from one activity to another
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent class will help to go to next activity using
                // it's object named intent.
                // SecondActivty is the name of new created EmptyActivity.
                String url = "https://www.youtube.com/watch?v=ZToicYcHIOU";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent class will help to go to next activity using
                // it's object named intent.
                // SecondActivty is the name of new created EmptyActivity.
                String url = "https://www.youtube.com/watch?v=d4S4twjeWTs";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent class will help to go to next activity using
                // it's object named intent.
                // SecondActivty is the name of new created EmptyActivity.
                String url = "https://www.youtube.com/watch?v=O8H-MaxzK80";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
    public void timerClick(View view) {
        long timeInMillis = Long.parseLong(timeEditText.getText().toString()) * 60000; // Convert minutes to milliseconds

        // Get selected ringtone and music options
        String selectedRingtone = ringtoneSpinner.getSelectedItem().toString();
        String selectedMusic = musicSpinner.getSelectedItem().toString();

        // Pass data to TimerActivity
        Intent intent = new Intent(this, TimerActivity.class);
        intent.putExtra("timeInMillis", timeInMillis);
        intent.putExtra("selectedRingtone", selectedRingtone);
        intent.putExtra("selectedMusic", selectedMusic);
        startActivity(intent);
    }
    private void startTimerPage() {
        // Get meditation time from EditText
        long timeInMillis = Long.parseLong(timeEditText.getText().toString()) * 60000; // Convert minutes to milliseconds

        // Get selected ringtone and music options
        String selectedRingtone = ringtoneSpinner.getSelectedItem().toString();
        String selectedMusic = musicSpinner.getSelectedItem().toString();

        // Pass data to TimerActivity
        Intent intent = new Intent(this, TimerActivity.class);
        intent.putExtra("timeInMillis", timeInMillis);
        intent.putExtra("selectedRingtone", selectedRingtone);
        intent.putExtra("selectedMusic", selectedMusic);
        startActivity(intent);
    }
}