package com.jtliao.secrethitlertracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

public class GameHome extends AppCompatActivity {

    CardCounter cc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_home);

        if(getIntent() == null || getIntent().getSerializableExtra(CardCounter.EXTRA) == null) {
            cc = new CardCounter(6, 11);
        }
        else {
            cc = (CardCounter) getIntent().getSerializableExtra(CardCounter.EXTRA);
        }
        TextView liberalTextView = (TextView) findViewById(R.id.liberalCount);
        liberalTextView.setText("" + cc.getNumLiberal());

        TextView fascistTextView = (TextView) findViewById(R.id.fascistCount);
        fascistTextView.setText("" + cc.getNumFascist());

        if(getIntent() != null && getIntent().getSerializableExtra(PolicyInfo.EXTRA) != null) {
            PolicyInfo policy = (PolicyInfo) getIntent().getSerializableExtra(PolicyInfo.EXTRA);
            TextView newPolicy = new TextView(this);
            if (policy.getParty().equals("liberal")) {
                newPolicy.setText("Pass");
                TableRow row = (TableRow) findViewById(R.id.liberalRow);
                row.addView(newPolicy);
            }
            else {
                newPolicy.setText("Pass");
                TableRow row = (TableRow) findViewById(R.id.fascistRow);
                row.addView(newPolicy);
            }
        }
//        LinearLayout fascistView = (LinearLayout) findViewById(R.id.fascistList);
//
//        TextView enactedView = new TextView(this);
//        enactedView.setText("something");
//        fascistView.addView(enactedView);
//
//        TextView enactedView2 = new TextView(this);
//        enactedView2.setText("something2");
//        fascistView.addView(enactedView2);
    }

    public void addEvent(View view) {
        Intent i = new Intent(this, AddEvent.class);
        i.putExtra(cc.EXTRA, cc);
        startActivity(i);
    }
}
