package com.jtliao.secrethitlertracker;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.jtliao.secrethitlertracker.data.PolicyContract.PolicyEntry;
import com.jtliao.secrethitlertracker.data.PolicyDBHelper;

public class AddEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
    }

    public void eventDone(View view) {
        //CardCounter cc = (CardCounter) getIntent().getSerializableExtra(CardCounter.EXTRA);
        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.outcomeToggle);
        String president = ((EditText)findViewById(R.id.editPresident)).getText().toString().trim();
        String chancellor = ((EditText)findViewById(R.id.editChancellor)).getText().toString().trim();
        String notes = ((EditText)findViewById(R.id.editNotes)).getText().toString().trim();

        //PolicyInfo policy;

        PolicyDBHelper mDbHelper = new PolicyDBHelper(this);
        SQLiteDatabase readDb = mDbHelper.getReadableDatabase();
        int count;

        ContentValues values = new ContentValues();
        if (toggleButton.isChecked()) {
            //cc.setNumLiberal(cc.getNumLiberal() - 1);
            //policy = new PolicyInfo("liberal", president, chancellor, notes);
            values.put(PolicyEntry.COLUMN_POLICY_TYPE, PolicyEntry.POLICY_LIBERAL);
            count = readDb.rawQuery("SELECT * FROM " + PolicyEntry.TABLE_NAME + " WHERE " +
                    PolicyEntry.COLUMN_POLICY_TYPE + " = " + PolicyEntry.POLICY_LIBERAL, null)
                    .getCount();
        }
        else {
            //cc.setNumFascist(cc.getNumFascist() - 1);
            //policy = new PolicyInfo("fascist", president, chancellor, notes);
            values.put(PolicyEntry.COLUMN_POLICY_TYPE, PolicyEntry.POLICY_FASCIST);
            count = readDb.rawQuery("SELECT * FROM " + PolicyEntry.TABLE_NAME + " WHERE " +
                    PolicyEntry.COLUMN_POLICY_TYPE + " = " + PolicyEntry.POLICY_FASCIST, null)
                    .getCount();
        }

        values.put(PolicyEntry.COLUMN_POLICY_NUMBER, count + 1);
        values.put(PolicyEntry.COLUMN_PRESIDENT, president);
        values.put(PolicyEntry.COLUMN_CHANCELLOR, chancellor);
        values.put(PolicyEntry.COLUMN_NOTES, notes);

        SQLiteDatabase writeDb = mDbHelper.getWritableDatabase();

        long rowId = writeDb.insert(PolicyEntry.TABLE_NAME, null, values);
        if (rowId == -1) {
            // If the row ID is -1, then there was an error with insertion.
            Toast.makeText(this, "Error with saving policy", Toast.LENGTH_SHORT).show();
        }
        else {
            finish();
        }

//        Intent i = new Intent(this, GameHome.class);
//        i.putExtra(PolicyInfo.EXTRA, policy);
//        i.putExtra(CardCounter.EXTRA, cc);
//
//        startActivity(i);
    }
}

