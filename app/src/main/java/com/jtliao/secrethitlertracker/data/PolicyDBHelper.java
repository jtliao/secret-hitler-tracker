package com.jtliao.secrethitlertracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.jtliao.secrethitlertracker.data.PolicyContract.PolicyEntry;

/**
 * Created by Jason on 12/29/2016.
 */

public class PolicyDBHelper extends SQLiteOpenHelper{
    /** Name of the database file */
    private static final String DATABASE_NAME = "policies.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    public PolicyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_PETS_TABLE =  "CREATE TABLE " + PolicyEntry.TABLE_NAME + " ("
                + PolicyEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PolicyEntry.COLUMN_POLICY_TYPE + " INTEGER NOT NULL, "
                + PolicyEntry.COLUMN_POLICY_NUMBER + " INTEGER NOT NULL, "
                + PolicyEntry.COLUMN_PRESIDENT + " TEXT NOT NULL, "
                + PolicyEntry.COLUMN_CHANCELLOR + " TEXT NOT NULL, "
                + PolicyEntry.COLUMN_NOTES + " TEXT);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }
}
