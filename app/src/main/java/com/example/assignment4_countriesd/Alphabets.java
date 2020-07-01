package com.example.assignment4_countriesd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class Alphabets extends AppCompatActivity {
    String[] alphabets;
    Intent intent,intent2,intent3,i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabets);
        Intent i1=getIntent();
        alphabets=getResources().getStringArray(R.array.alphabets);
        //i=getIntent();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alphabets);
        GridView grid=(GridView)findViewById(R.id.alphabets);
        intent=new Intent(this, Countries.class);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                intent.putExtra("alphabet",alphabets[position]);
                startActivity(intent);
            }
        });
    }
}
