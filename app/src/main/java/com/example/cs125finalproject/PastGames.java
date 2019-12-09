package com.example.cs125finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PastGames extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.past_games);
        LinearLayout pGroup = findViewById(R.id.pastGamesGroup);
        LinearLayout pList = findViewById(R.id.pastGamesList);
        View pChunk = getLayoutInflater().inflate(R.layout.past_games_info, pGroup, false);
        TextView name = pChunk.findViewById(R.id.gameName);
        Intent intent = getIntent();
        String gName = intent.getStringExtra("gameName");
        name.setText(gName);
        Button open = pChunk.findViewById(R.id.openGame);
        pList.addView(pChunk);
        Button exit = findViewById(R.id.exit);
        exit.setOnClickListener(unused -> exit());
    }

    public void exit() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}