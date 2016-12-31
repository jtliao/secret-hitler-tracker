package com.jtliao.secrethitlertracker;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

import com.jtliao.secrethitlertracker.data.PolicyContract.PolicyEntry;
import com.jtliao.secrethitlertracker.data.PolicyDBHelper;

public class GameHome extends AppCompatActivity {

    public static final int NUM_LIBERAL = 6;
    public static final int NUM_FASCIST = 11;
    //CardCounter cc;
    private PolicyDBHelper mDbHelper;

    TextView liberalTextView;
    TextView fascistTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_home);

//        if(getIntent() == null || getIntent().getSerializableExtra(CardCounter.EXTRA) == null) {
//            cc = new CardCounter(6, 11);
//        }
//        else {
//            cc = (CardCounter) getIntent().getSerializableExtra(CardCounter.EXTRA);
//        }
        liberalTextView = (TextView) findViewById(R.id.liberalCount);
        liberalTextView.setText("" + NUM_LIBERAL);

        fascistTextView = (TextView) findViewById(R.id.fascistCount);
        fascistTextView.setText("" + NUM_FASCIST);

//        if(getIntent() != null && getIntent().getSerializableExtra(PolicyInfo.EXTRA) != null) {
//            PolicyInfo policy = (PolicyInfo) getIntent().getSerializableExtra(PolicyInfo.EXTRA);
//            TextView newPolicy = new TextView(this);
//            if (policy.getParty().equals("liberal")) {
//                newPolicy.setText("Pass");
//                TableRow row = (TableRow) findViewById(R.id.liberalRow);
//                row.addView(newPolicy);
//            }
//            else {
//                newPolicy.setText("Pass");
//                TableRow row = (TableRow) findViewById(R.id.fascistRow);
//                row.addView(newPolicy);
//            }
//        }
        mDbHelper = new PolicyDBHelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        db.delete(PolicyEntry.TABLE_NAME, null, null);
    }

    protected void onStart() {
        super.onStart();
        mDbHelper = new PolicyDBHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        Cursor liberalCursor = db.rawQuery("SELECT * FROM " + PolicyEntry.TABLE_NAME + " WHERE " +
                PolicyEntry.COLUMN_POLICY_TYPE + " = " + PolicyEntry.POLICY_LIBERAL +
                " ORDER BY " + PolicyEntry.COLUMN_POLICY_NUMBER, null);
        Cursor fascistCursor = db.rawQuery("SELECT * FROM " + PolicyEntry.TABLE_NAME + " WHERE " +
                PolicyEntry.COLUMN_POLICY_TYPE + " = " + PolicyEntry.POLICY_FASCIST +
                " ORDER BY " + PolicyEntry.COLUMN_POLICY_NUMBER, null);

        int liberalCount = NUM_LIBERAL - liberalCursor.getCount();
        int fascistCount = NUM_FASCIST - fascistCursor.getCount();

        liberalTextView.setText("" + liberalCount);
        fascistTextView.setText("" + fascistCount);

        liberalCursor.close();
        fascistCursor.close();
    }

    public void addEvent(View view) {
        Intent i = new Intent(this, AddEvent.class);
        //i.putExtra(cc.EXTRA, cc);
        startActivity(i);
    }

    public void newGame(View view) {
        Intent i = new Intent(this, GameSetup.class);
        startActivity(i);
        finish();
    }

    public void displayLiberal(View view) {
        Intent i = new Intent(this, DisplayLiberal.class);
        startActivity(i);
    }

    public void displayFascist(View view) {
        Intent i = new Intent(this, DisplayFascist.class);
        startActivity(i);
    }
}
