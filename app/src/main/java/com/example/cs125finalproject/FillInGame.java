package com.example.cs125finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FillInGame extends AppCompatActivity {

    protected int numBlanks;
    protected int blankIndex = 0;
    protected ArrayList<String> blanksEntered = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        numBlanks = intent.getStringArrayListExtra("blanksToEnter").size();
        blanksEntered = intent.getStringArrayListExtra("blanksToEnter");
        setContentView(R.layout.fill_in_game);
        Button previous = findViewById(R.id.previous);
        Button next = findViewById(R.id.next);
        reloadPage();
        previous.setOnClickListener(unused -> goToPrevious());
        next.setOnClickListener(unused -> goToNext());
    }

    public void reloadPage() {
        Button previous = findViewById(R.id.previous);
        Button next = findViewById(R.id.next);
        if (blankIndex == 0) {
            previous.setVisibility(View.GONE);
        } else {
            previous.setVisibility(View.VISIBLE);
        }
        if (blankIndex == numBlanks - 1) {
            next.setText("Finish");
        } else {
            next.setText("Next");
        }
        EditText enterBlank = findViewById(R.id.editText);
        enterBlank.setText("");
        Intent intent = getIntent();
        String blankType = intent.getStringArrayListExtra("blanksToEnter").get(blankIndex);
        enterBlank.setHint("Enter a " + blankType);
    }

    public void goToPrevious() {
        EditText enterBlank = findViewById(R.id.editText);
        String blankEntered = enterBlank.getText().toString();
        blanksEntered.set(blankIndex, blankEntered);
        blankIndex--;
        reloadPage();
    }

    public void goToNext() {
        if(blankIndex == numBlanks - 1) {
            Intent oldIntent = getIntent();
            Intent intent = new Intent(this, CompletedGame.class);
            intent.putExtra("blanksEntered", blanksEntered);
            intent.putExtra("totalLib", oldIntent.getStringArrayListExtra("totalLib"));
            startActivity(intent);
        } else {
            EditText enterBlank = findViewById(R.id.editText);
            String blankEntered = enterBlank.getText().toString();
            blanksEntered.set(blankIndex, blankEntered);
            blankIndex++;
            reloadPage();
        }
    }
}