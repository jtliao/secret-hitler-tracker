package com.jtliao.secrethitlertracker;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

import com.jtliao.secrethitlertracker.data.PolicyContract.PolicyEntry;
import com.jtliao.secrethitlertracker.data.PolicyDBHelper;

public class DisplayLiberal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_liberal);

        PolicyDBHelper mDbHelper = new PolicyDBHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + PolicyEntry.TABLE_NAME
                + " WHERE " + PolicyEntry.COLUMN_POLICY_TYPE + " = " +
                PolicyEntry.POLICY_LIBERAL + " ORDER BY " +
                PolicyEntry.COLUMN_POLICY_NUMBER, null);

        TextView policiesView = (TextView) findViewById(R.id.liberalTextView);
        policiesView.setText("There have been " + cursor.getCount() + " liberal policies " +
                "enacted\n\n");
        policiesView.append(PolicyEntry.COLUMN_POLICY_NUMBER + " - " +
                PolicyEntry.COLUMN_PRESIDENT + " - " +
                PolicyEntry.COLUMN_CHANCELLOR + " - " +
                PolicyEntry.COLUMN_NOTES + " - " + "\n");

        int policyNumberColumnIndex = cursor.getColumnIndex(PolicyEntry.COLUMN_POLICY_NUMBER);
        int presidentColumnIndex = cursor.getColumnIndex(PolicyEntry.COLUMN_PRESIDENT);
        int chancellorColumnIndex = cursor.getColumnIndex(PolicyEntry.COLUMN_CHANCELLOR);
        int notesColumnIndex = cursor.getColumnIndex(PolicyEntry.COLUMN_NOTES);


        while(cursor.moveToNext()) {
            int policyNum = cursor.getInt(policyNumberColumnIndex);
            String president = cursor.getString(presidentColumnIndex);
            String chancellor = cursor.getString(chancellorColumnIndex);
            String notes = cursor.getString(notesColumnIndex);
            policiesView.append("\n" + policyNum + " - " +
                    president + " - " +
                    chancellor+ " - " +
                    notes);
        }
        cursor.close();
    }

    public void returnHome(View view) {
        finish();
    }
}
