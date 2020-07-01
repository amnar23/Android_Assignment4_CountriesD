package com.example.assignment4_countriesd;

import android.provider.BaseColumns;

public class DatabaseContract {
    public DatabaseContract(){}
    public static abstract class Country implements BaseColumns{
        public static final String TABLE_NAME="countries";
            public static final String COL_NAME="name";
        public static final String COL_CONTINENT="continent";
        public static final String COL_AREA="area";
        public static final String COL_POPULATION="population";
        public static final String COL_LANGUAGE="language";
        public static final String COL_IMAGE = "img";
    }
}
