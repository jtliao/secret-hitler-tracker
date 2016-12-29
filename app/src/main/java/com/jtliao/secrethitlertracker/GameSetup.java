package com.jtliao.secrethitlertracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameSetup extends AppCompatActivity {
    int numPlayers = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_setup);
    }

    public void startGame(View view) {
        Intent i = new Intent(this, GameHome.class);
        i.putExtra("EXTRA_PLAYERS", numPlayers);
        startActivity(i);
    }

    public void increment(View view) {
        if (numPlayers >= 10) {

        }
        else {
            numPlayers++;
            displayPlayers(numPlayers);
        }
    }

    public void decrement(View view) {
        if (numPlayers <= 5) {

        }
        else {
            numPlayers--;
            displayPlayers(numPlayers);
        }
    }

    private void displayPlayers(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.num_players);
        quantityTextView.setText("" + number);
    }
}

