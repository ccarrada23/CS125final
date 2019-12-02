package com.example.cs125finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button newGame = findViewById(R.id.newGame);
        newGame.setOnClickListener(unused -> launchNewGame());
        Button pastGames = findViewById(R.id.pastGames);
        pastGames.setOnClickListener(unused -> launchPastGames());
    }

    public void launchNewGame() {
        Intent intent = new Intent(this, NewGame.class);
        startActivity(intent);
    }

    public void launchPastGames() {
        Intent intent = new Intent(this, PastGames.class);
        startActivity(intent);
    }
}
