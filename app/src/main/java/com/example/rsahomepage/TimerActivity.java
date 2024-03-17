package com.example.rsahomepage;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {

    private TextView timerDisplay;
    private long timeLeftInMillis;
    private CountDownTimer countDownTimer;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        timerDisplay = findViewById(R.id.timer_display);
        timeLeftInMillis = getIntent().getLongExtra("timeInMillis", 0);
        String selectedRingtone = getIntent().getStringExtra("selectedRingtone");
        String selectedMusic = getIntent().getStringExtra("selectedMusic");

        // Start playing selected music
        // You can implement this according to how you handle playing music in your app

        startTimer();
    }

    private void startTimer() {
        startMusic();
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateTimerDisplay();
            }

            @Override
            public void onFinish() {
                // Start ringtone
                startRingtone();
                // Delay 10 seconds before finishing the activity
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                }, 10000);
            }
        }.start();
    }

    private void updateTimerDisplay() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format("%02d:%02d", minutes, seconds);
        timerDisplay.setText(timeLeftFormatted);
    }
    public void startMusic() {
        //mediaPlayer = MediaPlayer.create(this, R.raw.your_music);
        //mediaPlayer.start();
    }
    private void startRingtone() {
        // Play ringtone
        // mediaPlayer = MediaPlayer.create(this, R.raw.your_ringtone);
        //mediaPlayer.start();
    }
}