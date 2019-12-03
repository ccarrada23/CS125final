package com.example.cs125finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FillInGame extends AppCompatActivity {

    int numBlanks = 2;
    int blankIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        if (blankIndex == numBlanks) {
            next.setText("Finish");
        } else {
            next.setText("Next");
        }
    }

    public void goToPrevious() {
        blankIndex--;
        reloadPage();
    }

    public void goToNext() {
        if(blankIndex == numBlanks) {
            Intent intent = new Intent(this, CompletedGame.class);
            startActivity(intent);
        } else {
            blankIndex++;
            reloadPage();
        }
    }
}