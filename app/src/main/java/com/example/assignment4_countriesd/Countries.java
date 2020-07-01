package com.example.assignment4_countriesd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Countries extends AppCompatActivity {
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    Intent send;
    ArrayList<String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);
        dbHelper=new DatabaseHelper(this);
        db=dbHelper.getReadableDatabase();
        Intent i=getIntent();
        String alpha=i.getStringExtra("alphabet");
        final ArrayList<String> countryList=new ArrayList<>();
        //Retrieve from database and display country name starting what 'alpha'
        try {
            String[] columns= {DatabaseContract.Country.COL_NAME};
            String sortOrder=DatabaseContract.Country.COL_NAME + " ASC";
            String selection=DatabaseContract.Country.COL_NAME + " LIKE? ";
            String[] selectionArgs={alpha+"%"};
            Cursor c = db.query(DatabaseContract.Country.TABLE_NAME, columns, selection, selectionArgs, null, null, sortOrder);
            while (c.moveToNext()) {
                //Long id = c.getLong(0);
                String name = c.getString(0);
                countryList.add(name);
            }
            c.close();
        }catch (SQLiteException e)
        {
            Log.d("TAG",e.getMessage());
        }
        ListView lv=(ListView) findViewById(R.id.countries);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,countryList);
        lv.setAdapter(adapter);
        data=new ArrayList<>();
        send=new Intent(this,Display.class);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String c_name=countryList.get(position);
                ArrayList<String> data=new ArrayList<>();

               try{
                   String[] country_columns={DatabaseContract.Country.COL_CONTINENT,DatabaseContract.Country.COL_AREA,DatabaseContract.Country.COL_POPULATION,DatabaseContract.Country.COL_LANGUAGE,DatabaseContract.Country.COL_IMAGE};
                   String selection=DatabaseContract.Country.COL_NAME + " =? ";
                   String[] selectionArgs={c_name};
                   Cursor cc=db.query(DatabaseContract.Country.TABLE_NAME,country_columns,selection,selectionArgs,null,null,null);
                   while(cc.moveToNext()){
                       data.add(cc.getString(0));
                       data.add(cc.getString(1));
                       data.add(cc.getString(2));
                       data.add(cc.getString(3));
                       data.add(String.valueOf(cc.getInt(4)));
                   }
                   cc.close();
               }catch(SQLiteException e) {
                   Log.d("TAG",e.getMessage());
               }
               send.putExtra("name",c_name);
               send.putExtra("continent",data.get(0));
               send.putExtra("area",data.get(1));
               send.putExtra("population",data.get(2));
               send.putExtra("language",data.get(3));
               send.putExtra("image",Integer.valueOf(data.get(4)));
               startActivity(send);
            }

        });
    }
}
