package com.jtliao.secrethitlertracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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
        String president = ((EditText)findViewById(R.id.editPresident)).getText().toString();
        String chancellor = ((EditText)findViewById(R.id.editChancellor)).getText().toString();
        String notes = ((EditText)findViewById(R.id.editNotes)).getText().toString();

        PolicyInfo policy;
        if (toggleButton.isChecked()) {
            cc.setNumLiberal(cc.getNumLiberal() - 1);
            policy = new PolicyInfo("liberal", president, chancellor, notes);
        }
        else {
            cc.setNumFascist(cc.getNumFascist() - 1);
            policy = new PolicyInfo("fascist", president, chancellor, notes);
        }

        Intent i = new Intent(this, GameHome.class);
        i.putExtra(PolicyInfo.EXTRA, policy);
        i.putExtra(CardCounter.EXTRA, cc);

        startActivity(i);
    }
}

