package com.example.rsahomepage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rsahomepage.databinding.ActivitySurveyBinding;

public class SurveyActivity extends AppCompatActivity {

private ActivitySurveyBinding binding;

    private static final String PREFS_NAME = "SurveyPrefs";
    private static final String SURVEY_COMPLETED_KEY = "SurveyCompleted";
    private static final String DISCLAIMER_ACCEPTED_KEY = "DisclaimerAccepted";

    private RadioGroup answerChoicesRadioGroup;
    private Button nextButton;
    private SharedPreferences sharedPreferences;

    private static String[] questions;
    private static String[][] answers;
    private static String[] selectedAnswers;
    private int currentQuestionIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        answerChoicesRadioGroup = findViewById(R.id.answerChoicesRadioGroup);
        nextButton = findViewById(R.id.nextButton);
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        // Initialize the list of questions
        initializeQuestions();

        // Check if the disclaimer has been accepted before
        if (!sharedPreferences.getBoolean(DISCLAIMER_ACCEPTED_KEY, false)) {
            // Disclaimer has not been accepted, show the disclaimer popup
            showDisclaimerPopup();
        } else {
            // Start the survey
            showNextQuestion();
        }

        nextButton.setOnClickListener(view -> {
            int selectedId = answerChoicesRadioGroup.getCheckedRadioButtonId();

            if (selectedId == -1) {
                Toast.makeText(SurveyActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
            } else {
                // Survey completed
                markSurveyCompleted();
                RadioButton selectedRadioButton = findViewById(selectedId);
                String answer = selectedRadioButton.getText().toString();
                Toast.makeText(SurveyActivity.this, "Selected Answer: " + answer, Toast.LENGTH_SHORT).show();
                selectedAnswers[currentQuestionIndex] = answer;

                // Show next question or finish survey
                currentQuestionIndex++;
                if (currentQuestionIndex < questions.length) {
                    showNextQuestion();
                } else {
                    // All questions answered, perform any other actions
                    Intent intent = new Intent(SurveyActivity.this, Name.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void showNextQuestion() {
        String question = questions[currentQuestionIndex];
        String answer1 = answers[currentQuestionIndex][0];
        String answer2 = answers[currentQuestionIndex][1];
        String answer3 = answers[currentQuestionIndex][2];
        TextView questionTextView = findViewById(R.id.questionTextView);
        questionTextView.setText(question);
        RadioButton choice1RadioButton = findViewById(R.id.choice1RadioButton);
        RadioButton choice2RadioButton = findViewById(R.id.choice2RadioButton);
        RadioButton choice3RadioButton = findViewById(R.id.choice3RadioButton);
        choice1RadioButton.setText(answer1);
        choice2RadioButton.setText(answer2);
        choice3RadioButton.setText(answer3);


    }

    private void initializeQuestions() {
        questions = new String[]{"Which area of your life do you feel contribute the most to your mental health challenges?", "How would you describe your current coping mechanisms when faced with stress or challenging emotions?", "What is your primary mental health goal?", "What do you plan to use this app for?", "What addictions do you struggle with, if any?", "How comfortable are you with interacting with a chatbot for support?", "What information or resources would be most valuable to you when it comes to managing stress?"};
        // Add your questions and answer choices here
        // Add more questions here as needed
        selectedAnswers = questions;
        answers = new String[][]{{"School/Work","Personal Habits","Relationships"},{"Meditation","Communication","Substance Use"},{"I want to feel at peace","I want to have confidence in whatever I do.","I want to feel more connected"},{"Dealing with addictions","Meditating and feeling at peace","Learning about mental health"},{"Drug addiction","Gambling addiction","Alcohol addiction"},{"Very comfortable","Neutral","Uncomfortable"},{"Coping techniques","Educational content","Other people's stories"}};
        // questions.add(new Question("Next question?", new String[]{"Option A", "Option B", "Option C"}));
        currentQuestionIndex = 0;
    }

    private void showDisclaimerPopup() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Disclaimer");
        builder.setMessage("This mental health app provides general information and support but is not a substitute for professional advice. Users should consult qualified mental health professionals for personalized guidance, and the app does not guarantee specific outcomes.");
        builder.setPositiveButton("I Understand", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Mark disclaimer as accepted
                markDisclaimerAccepted();
                // Start the survey
                showNextQuestion();
            }
        });
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                // Continue with the app flow
            }
        });
        builder.show();
    }

    private void markSurveyCompleted() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(SURVEY_COMPLETED_KEY, true);
        editor.apply();
    }

    private void markDisclaimerAccepted() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(DISCLAIMER_ACCEPTED_KEY, true);
        editor.apply();
    }
}