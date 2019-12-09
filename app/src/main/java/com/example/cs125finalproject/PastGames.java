package com.example.cs125finalproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class PastGames extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.past_games);
        Intent intent = getIntent();
        if (intent.getStringExtra("gameName") != null) {
            LinearLayout pGroup = findViewById(R.id.pastGamesGroup);
            LinearLayout pList = findViewById(R.id.pastGamesList);
            View pChunk = getLayoutInflater().inflate(R.layout.past_games_info, pGroup, false);
            TextView name = pChunk.findViewById(R.id.gameName);
            String gName = intent.getStringExtra("gameName");
            name.setText(gName);
            String completedLib = intent.getStringExtra("completedLib");
            Button open = pChunk.findViewById(R.id.openGame);
            open.setOnClickListener(unused -> displayGame(completedLib));
            pList.addView(pChunk);
        }
        Button exit = findViewById(R.id.exit);
        exit.setOnClickListener(unused -> exit());
    }

    public void displayGame(String completedLib) {
        AlertDialog.Builder text = new AlertDialog.Builder(this);
        text.setTitle(completedLib);

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
        startActivity(intent);
    }
}