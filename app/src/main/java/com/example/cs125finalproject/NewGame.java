package com.example.cs125finalproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class NewGame extends AppCompatActivity {

    public ArrayList<String> totalLib = new ArrayList<>();
    public ArrayList<String> blanksToEnter = new ArrayList<>();
    public String currentLib = new String();
    public String textEntered = new String();
    public String blankEntered = new String();

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
        AlertDialog.Builder text = new AlertDialog.Builder(this);
        text.setTitle("Enter Text");

        // Input within AlertDialog
        EditText input = new EditText(this);
        text.setView(input);

        // Buttons within AlertDialog
        text.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textEntered = input.getText().toString().trim();
                totalLib.add(textEntered);
                currentLib = currentLib + " " + textEntered;
                TextView currentLibText = findViewById(R.id.currentLib);
                currentLibText.setText(currentLib);
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

    public void enterBlank() {
        AlertDialog.Builder text = new AlertDialog.Builder(this);
        text.setTitle("Enter a Type of Word");

        // Input within AlertDialog
        EditText input = new EditText(this);
        text.setView(input);

        // Buttons within AlertDialog
        text.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                blankEntered = input.getText().toString().trim();
                totalLib.add("BLANK");
                blanksToEnter.add(blankEntered);
                currentLib = currentLib + " [" + blankEntered + "]";
                TextView currentLibText = findViewById(R.id.currentLib);
                currentLibText.setText(currentLib);
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

    public void launchFillInGame() {
        Intent intent = new Intent(this, FillInGame.class);
        intent.putExtra("totalLib", totalLib);
        intent.putExtra("blanksToEnter", blanksToEnter);
        startActivity(intent);
    }
}