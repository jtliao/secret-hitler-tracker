package com.jtliao.secrethitlertracker.data;

import android.provider.BaseColumns;

/**
 * Created by Jason on 12/29/2016.
 */

public final class PolicyContract {

    public static final class PolicyEntry implements BaseColumns {
        public final static String TABLE_NAME = "policies";

        /**
         * Unique ID number for the policy
         *
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Type of policy enacted.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_POLICY_TYPE = "type";

        /**
         * What number policy this one is.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_POLICY_NUMBER = "number";

        /**
         * Name of the president.
         *
         * Type: TEXT
         */
        public final static String COLUMN_PRESIDENT = "president";

        /**
         * Name of chancellor.
         *
         * Type: TEXT
         */
        public final static String COLUMN_CHANCELLOR ="chancellor";

        /**
         * Notes about the policy.
         *
         * Type: TEXT
         */
        public final static String COLUMN_NOTES ="notes";

        /**
         * Possible types of policies
         */
        public static final int POLICY_LIBERAL = 0;
        public static final int POLICY_FASCIST = 1;
    }
}
