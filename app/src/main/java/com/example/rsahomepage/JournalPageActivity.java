package com.example.rsahomepage;

import android.content.DialogInterface;
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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rsahomepage.databinding.ActivityJournalPageBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class JournalPageActivity extends AppCompatActivity {

    private ActivityJournalPageBinding binding;

    private static final String PREFS_NAME = "NotePrefs";
    private static final String KEY_NOTE_COUNT = "NoteCount";
    private LinearLayout notesContainer;
    private List<Note> noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityJournalPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        notesContainer = findViewById(R.id.notesContainer);
        Button saveButton = findViewById(R.id.saveButton);
        noteList = new ArrayList<>();
        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                saveNote();
            }
        });

        displayNotes();
        loadNotesFromPreferences();

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
        String formattedDate = dateFormat.format(date);
        DateFormat timeFormat = DateFormat.getTimeInstance(DateFormat.SHORT);
        String formattedTime = timeFormat.format(date);
        TextView dateTextView = findViewById(R.id.xml_text_date);
        TextView timeTextView = findViewById(R.id.xml_text_time);

        dateTextView.setText(formattedDate);
        timeTextView.setText(formattedTime);



    }

    private void displayNotes() {
        for(Note note: noteList){
            createNoteView(note);
        }
    }

    private void loadNotesFromPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        int noteCount = sharedPreferences.getInt(KEY_NOTE_COUNT, 0);
        for(int i = 0; i < noteCount; i++){
            String title = sharedPreferences.getString("note_title_" + i, "");
            String content = sharedPreferences.getString("note_count_" + i, "");

            Note note = new Note();
            note.setTitle(title);
            note.setContent(content);
            noteList.add(note);
        }
    }

    public void saveNote(){
        EditText titleEditText = findViewById(R.id.titleEditText);
        EditText contentEditText = findViewById(R.id.contentEditText);

        String title = titleEditText.getText().toString();
        String content = contentEditText.getText().toString();

        if(!title.isEmpty() && !content.isEmpty()){
            Note note = new Note();
            note.setTitle(title);
            note.setContent(content);

            noteList.add(note);
            saveNotesToPreferences();

            createNoteView(note);
            clearInputFields();
        }


    }

    private void clearInputFields() {
        EditText titleEditText = findViewById(R.id.titleEditText);
        EditText contentEditText = findViewById(R.id.contentEditText);

        titleEditText.getText().clear();
        contentEditText.getText().clear();
    }

    private void createNoteView(final Note note){
        View noteView = getLayoutInflater().inflate(R.layout.note_item, null);
        TextView titleTextView = noteView.findViewById(R.id.titleTextView);
        TextView contentTextView = noteView.findViewById(R.id.contentTextView);

        titleTextView.setText(note.getTitle());
        contentTextView.setText(note.getContent());

        noteView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return true;
            }
        });

        notesContainer.addView(noteView);
    }

    private void showDeleteDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete this note.");
        builder.setMessage("Are you sure you want to delete this note?");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                deleteNoteAndReferesh(); //deleted note from inside parenthesis
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }

    private void deleteNoteAndReferesh(){
        Note note = new Note(); //added
        noteList.remove(note);
        saveNotesToPreferences();
        refereshNoteViews();
    }

    private void refereshNoteViews(){
        notesContainer.removeAllViews();
        displayNotes();
    }

    private void saveNotesToPreferences(){
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(KEY_NOTE_COUNT, noteList.size());
        for(int i = 0; i < noteList.size(); i++){
            Note note = noteList.get(i);
            editor.putString("note_title_" + i, note.getTitle());
            editor.putString("note_content_" + i, note.getContent());
        }
        editor.apply();
    }

}
