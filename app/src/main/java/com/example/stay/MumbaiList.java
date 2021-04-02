package com.example.stay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.Vector;

public class MumbaiList extends AppCompatActivity {
    ListView  list;
    String hotelname;
   String hotels[]={
            "Sai Plaza Hotel","Surya","Taj Hotel","Dynasty","Raj Mahal","Hotel Lake View","Raj Mahal","Hotel Lake View"
    };
    Integer[] imageid ={
            R.drawable.thali,
            R.drawable.thali,
            R.drawable.thali,
            R.drawable.thali,
            R.drawable.thali,
            R.drawable.thali,
            R.drawable.thali,
            R.drawable.thali,
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(MumbaiList.this,MainActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mumbai_list);

        Custom_list adapter = new Custom_list(MumbaiList.this,hotels,imageid);
         list = findViewById(R.id.list_mumbai);
         list.setAdapter(adapter);
    }
}