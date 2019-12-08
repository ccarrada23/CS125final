package com.example.cs125finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CompletedGame extends AppCompatActivity {

    protected String completed = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.completed_game);
        Intent intent = getIntent();
        ArrayList<String> blanksEntered = intent.getStringArrayListExtra("blanksEntered");
        ArrayList<String> totalLib = intent.getStringArrayListExtra("totalLib");
        int blankIndex = 0;
        for (int i = 0; i < totalLib.size(); i++) {
            if (totalLib.get(i).equals("BLANK")) {
                completed = completed + " " + blanksEntered.get(blankIndex);
                blankIndex++;
            } else {
                completed = completed + " " + totalLib.get(i);
            }
        }
        TextView completedLib = findViewById(R.id.completedMadLib);
        completedLib.setText(completed);
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