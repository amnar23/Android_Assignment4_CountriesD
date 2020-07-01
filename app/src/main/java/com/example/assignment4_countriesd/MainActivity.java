package com.example.assignment4_countriesd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import static com.example.assignment4_countriesd.DatabaseContract.Country.TABLE_NAME;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper=new DatabaseHelper(this);
    }
    public void Insert(View v)
    {
        db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        try{
            /*long newRowID;
            values.put(DatabaseContract.Country.COL_NAME,"Pakistan");
            values.put(DatabaseContract.Country.COL_CONTINENT,"Asia");
            values.put(DatabaseContract.Country.COL_AREA,"770,880");
            values.put(DatabaseContract.Country.COL_POPULATION,"22089234");
            values.put(DatabaseContract.Country.COL_LANGUAGE,"Urdu");
            values.put(DatabaseContract.Country.COL_IMAGE,R.drawable.pakflag);
            newRowID=db.insert(TABLE_NAME,null,values);
            values.put(DatabaseContract.Country.COL_NAME, "Malaysia");
            values.put(DatabaseContract.Country.COL_CONTINENT,"Asia" );
            values.put(DatabaseContract.Country.COL_AREA,"328,550");
            values.put(DatabaseContract.Country.COL_POPULATION,"32,365,999");
            values.put(DatabaseContract.Country.COL_LANGUAGE,"Malay");
            values.put(DatabaseContract.Country.COL_IMAGE,R.drawable.malaysiaflag);
            newRowID=db.insert(TABLE_NAME,null,values);
            values.put(DatabaseContract.Country.COL_NAME, "Poland");
            values.put(DatabaseContract.Country.COL_CONTINENT,"Europe" );
            values.put(DatabaseContract.Country.COL_AREA,"306,230");
            values.put(DatabaseContract.Country.COL_POPULATION,"37,846,611");
            values.put(DatabaseContract.Country.COL_LANGUAGE,"Polish");
            values.put(DatabaseContract.Country.COL_IMAGE,R.drawable.polandflag);
            newRowID=db.insert(TABLE_NAME,null,values);
            values.put(DatabaseContract.Country.COL_NAME, "Turkey");
            values.put(DatabaseContract.Country.COL_CONTINENT,"Asia" );
            values.put(DatabaseContract.Country.COL_AREA,"769,630");
            values.put(DatabaseContract.Country.COL_POPULATION,"84,339,067");
            values.put(DatabaseContract.Country.COL_LANGUAGE,"Turkish");
            values.put(DatabaseContract.Country.COL_IMAGE,R.drawable.turkeyflag);
            newRowID=db.insert(TABLE_NAME,null,values);
            values.put(DatabaseContract.Country.COL_NAME, "Saudi Arabia");
            values.put(DatabaseContract.Country.COL_CONTINENT,"Asia" );
            values.put(DatabaseContract.Country.COL_AREA,"2,149,690");
            values.put(DatabaseContract.Country.COL_POPULATION,"34,813,871");
            values.put(DatabaseContract.Country.COL_LANGUAGE,"Arabic");
            values.put(DatabaseContract.Country.COL_IMAGE,R.drawable.saudiflag);
            newRowID=db.insert(TABLE_NAME,null,values);
            values.put(DatabaseContract.Country.COL_NAME, "Russia");
            values.put(DatabaseContract.Country.COL_CONTINENT,"Asia" );
            values.put(DatabaseContract.Country.COL_AREA,"16,376,870");
            values.put(DatabaseContract.Country.COL_POPULATION,"145,934,462");
            values.put(DatabaseContract.Country.COL_LANGUAGE,"Russian");
            values.put(DatabaseContract.Country.COL_IMAGE,R.drawable.russiaflag);
            newRowID=db.insert(TABLE_NAME,null,values);
            values.put(DatabaseContract.Country.COL_NAME, "Qatar");
            values.put(DatabaseContract.Country.COL_CONTINENT,"Asia" );
            values.put(DatabaseContract.Country.COL_AREA,"11,610");
            values.put(DatabaseContract.Country.COL_POPULATION,"2,881,053");
            values.put(DatabaseContract.Country.COL_LANGUAGE,"Arabic");
            values.put(DatabaseContract.Country.COL_IMAGE,R.drawable.qatarflag);
            newRowID=db.insert(TABLE_NAME,null,values);
            values.put(DatabaseContract.Country.COL_NAME, "Nepal");
            values.put(DatabaseContract.Country.COL_CONTINENT,"Asia" );
            values.put(DatabaseContract.Country.COL_AREA,"143,350");
            values.put(DatabaseContract.Country.COL_POPULATION,"29,136,808");
            values.put(DatabaseContract.Country.COL_LANGUAGE,"Nepali");
            values.put(DatabaseContract.Country.COL_IMAGE,R.drawable.nepalflag);
            newRowID=db.insert(TABLE_NAME,null,values);
            values.put(DatabaseContract.Country.COL_NAME, "Bahrain");
            values.put(DatabaseContract.Country.COL_CONTINENT,"Asia" );
            values.put(DatabaseContract.Country.COL_AREA,"760");
            values.put(DatabaseContract.Country.COL_POPULATION,"1,701,575");
            values.put(DatabaseContract.Country.COL_LANGUAGE,"Arabic");
            values.put(DatabaseContract.Country.COL_IMAGE,R.drawable.bahrain);
            newRowID=db.insert(TABLE_NAME,null,values);
            values.put(DatabaseContract.Country.COL_NAME, "Bangladesh");
            values.put(DatabaseContract.Country.COL_CONTINENT,"Asia" );
            values.put(DatabaseContract.Country.COL_AREA,"130,170");
            values.put(DatabaseContract.Country.COL_POPULATION,"164,689,383");
            values.put(DatabaseContract.Country.COL_LANGUAGE,"Bengali");
            values.put(DatabaseContract.Country.COL_IMAGE,R.drawable.bangladeshflag);
            newRowID=db.insert(TABLE_NAME,null,values);*/
           /* String whereClause= DatabaseContract.Country._ID + " =?";
            String[] whereArgs={String.valueOf(12)};
            int result=db.delete(TABLE_NAME,whereClause,whereArgs);
            if(result>0)
                Toast.makeText(this,"Record Deleted: "+result,Toast.LENGTH_SHORT).show();*/
            db.close();
        }catch(SQLiteException e)
        {
            Log.d("TAG",e.getMessage());
        }
        Intent i=new Intent(this, Alphabets.class);
        startActivity(i);
    }
}
