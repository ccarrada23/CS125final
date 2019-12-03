package com.example.cs125finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NewGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_game);
        Button enterText = findViewById(R.id.enterText);
        Button enterBlank = findViewById(R.id.enterBlank);
        Button finish = findViewById(R.id.finish);
        enterText.setOnClickListener(unused -> enterText());
        enterBlank.setOnClickListener(unused -> enterBlank());
        finish.setOnClickListener(unused -> launchFillInGame());
    }

    public void enterText() {
        System.out.println("Text is added to the Mad Lib");
    }

    public void enterBlank() {
        System.out.println("A blank is added to the Mad Lib");
    }

    public void launchFillInGame() {
        Intent intent = new Intent(this, FillInGame.class);
        startActivity(intent);
    }
}