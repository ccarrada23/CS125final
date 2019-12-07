package com.example.cs125finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class NewGame extends AppCompatActivity {

    public ArrayList<String> totalLib = new ArrayList<>();
    public ArrayList<String> blanksToEnter = new ArrayList<>();
    public String currentLib = new String();

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
        String textEntered = new String(); //trim when recieved.
        totalLib.add(textEntered);
        currentLib = currentLib + " " + textEntered;
        TextView currentLibText = findViewById(R.id.currentLib);
        currentLibText.setText(currentLib);
    }

    public void enterBlank() {
        String blankEntered = new String(); //trim when recieved.
        totalLib.add("BLANK");
        blanksToEnter.add(blankEntered);
        currentLib = currentLib + " [" + blankEntered + "]";
        TextView currentLibText = findViewById(R.id.currentLib);
        currentLibText.setText(currentLib);
    }

    public void launchFillInGame() {
        Intent intent = new Intent(this, FillInGame.class);
        intent.putExtra("totalLib", totalLib);
        intent.putExtra("blanksToEnter", blanksToEnter);
        startActivity(intent);
    }
}