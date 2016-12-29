package com.jtliao.secrethitlertracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

public class AddEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
    }

    public void eventDone(View view) {
        CardCounter cc = (CardCounter) getIntent().getSerializableExtra(CardCounter.EXTRA);
        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.outcomeToggle);

        if (toggleButton.isChecked()) {
            cc.setNumLiberal(cc.getNumLiberal() - 1);
        }
        else {
            cc.setNumFascist(cc.getNumFascist() - 1);
        }
        Intent i = new Intent(this, GameHome.class);
        i.putExtra(CardCounter.EXTRA, cc);
        startActivity(i);
    }
}

