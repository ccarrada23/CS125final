package com.example.cs125finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PastGames extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.past_games);
        Button exit = findViewById(R.id.exit);
        exit.setOnClickListener(unused -> exit());
    }

    public void exit() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}