package com.example.assignment4_countriesd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME="CountryData.db";
    private static final String CREATE_TABLE_COUNTRIES = "CREATE TABLE "
            +DatabaseContract.Country.TABLE_NAME + "("
            +DatabaseContract.Country._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            +DatabaseContract.Country.COL_NAME + " TEXT NOT NULL, "
            +DatabaseContract.Country.COL_CONTINENT+" TEXT, "
            +DatabaseContract.Country.COL_AREA+" TEXT, "
            +DatabaseContract.Country.COL_POPULATION+" TEXT, "
            +DatabaseContract.Country.COL_LANGUAGE+" TEXT, "
            +DatabaseContract.Country.COL_IMAGE+" INTEGER)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_COUNTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       // db.execSQL(ALTER_TABLE);
    }
}
