package com.example.cs125finalproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
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
        AlertDialog.Builder text = new AlertDialog.Builder(this);
        text.setTitle("Name your Mad Lib");

        // Input within AlertDialog
        EditText input = new EditText(this);
        text.setView(input);

        // Buttons within AlertDialog
        text.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String gameName = input.getText().toString().trim();
                startActivity(intent);
            }
        });
        text.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        text.show();
    }

    public void exit() {
        Intent intent = new Intent(this, MainActivity.class);
        AlertDialog.Builder text = new AlertDialog.Builder(this);
        text.setTitle("Are you sure?");

        // Buttons within AlertDialog
        text.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(intent);
            }
        });
        text.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        text.show();
    }
}