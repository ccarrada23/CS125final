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
        previous.setVisibility(View.GONE);
        previous.setOnClickListener(unused -> goToPrevious());
        next.setOnClickListener(unused -> goToNext(savedInstanceState));
    }

    public void goToPrevious() {
        Button previous = findViewById(R.id.previous);
        blankIndex--;
        if (blankIndex == 0) {
            previous.setVisibility(View.GONE);
        } else {
            previous.setVisibility(View.VISIBLE);
        }
    }

    public void goToNext(Bundle savedInstanceState) {
        if(blankIndex == numBlanks) {
            Intent intent = new Intent(this, CompletedGame.class);
            startActivity(intent);
        } else {
            blankIndex++;
            if(blankIndex == numBlanks) {
                Button next = findViewById(R.id.next);
                next.setText("Finish");
            }
        }
    }
}