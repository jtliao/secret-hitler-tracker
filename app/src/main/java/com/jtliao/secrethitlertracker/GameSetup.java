package com.jtliao.secrethitlertracker;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.app.AlertDialog;

public class GameSetup extends AppCompatActivity {
    int numPlayers = 5;
    public static final String EXTRA = "com.jtliao.secrethitlertracker.NUM_PLAYERS_EXTRA";
    AlertDialog.Builder decrementBuilder;
    AlertDialog.Builder incrementBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_setup);

        decrementBuilder = new AlertDialog.Builder(this);
        decrementBuilder.setMessage("Cannot have less than 5 players!")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {}
                });

        incrementBuilder = new AlertDialog.Builder(this);
        incrementBuilder.setMessage("Cannot have more than 10 players!")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {}
                });
    }

    public void startGame(View view) {
        Intent i = new Intent(this, GameIntro.class);
        i.putExtra(EXTRA, numPlayers);
        startActivity(i);
        finish();
    }

    public void increment(View view) {
        if (numPlayers >= 10) {
            AlertDialog alert = incrementBuilder.create();
            alert.show();
        }
        else {
            numPlayers++;
            displayPlayers(numPlayers);
        }
    }

    public void decrement(View view) {
        if (numPlayers <= 5) {
            AlertDialog alert = decrementBuilder.create();
            alert.show();
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

