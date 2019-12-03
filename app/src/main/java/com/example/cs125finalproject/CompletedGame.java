package com.example.cs125finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CompletedGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.completed_game);
        Button saveExit = findViewById(R.id.saveExit);
        Button exit = findViewById(R.id.exit);
        saveExit.setOnClickListener(unused -> saveExit());
        exit.setOnClickListener(unused -> exit());
    }

    public void saveExit() {
        Intent intent = new Intent(this, MainActivity.class);
        System.out.print("saves game to previous games");
        startActivity(intent);
    }

    public void exit() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}