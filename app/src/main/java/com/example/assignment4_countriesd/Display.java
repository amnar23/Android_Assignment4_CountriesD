package com.example.assignment4_countriesd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Display extends AppCompatActivity {
    String name,cont,area,pop,lang;
    int img;
    TextView c_name,c_cont,c_area,c_pop,c_lang;
    ImageView flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Intent i=getIntent();
        name=i.getStringExtra("name");
        cont=i.getStringExtra("continent");
        area=i.getStringExtra("area");
        pop=i.getStringExtra("population");
        lang=i.getStringExtra("language");
        img=i.getIntExtra("image",0);
        c_name=(TextView)findViewById(R.id.c_name);
        c_cont=(TextView)findViewById(R.id.con);
        c_area=(TextView)findViewById(R.id.area);
        c_pop=(TextView)findViewById(R.id.pop);
        c_lang=(TextView)findViewById(R.id.lan);
        flag=(ImageView)findViewById(R.id.img);
        c_name.setText(name);
        c_cont.setText("Continent: "+cont);
        c_area.setText("Area: "+area+" kmsq");
        c_pop.setText("Population: "+pop);
        c_lang.setText("Langugae: "+lang);
        flag.setImageResource(img);
    }
}
