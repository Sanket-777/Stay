package com.example.stay;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Pune_list extends AppCompatActivity {
    ListView list;
    String hotelname;
    String hotels[]={
            "P K Biryani House","Cafe Goodluck","Magrid Hotel","Dynasty","Aroma House","Vaibhav Restaurant","Sweet Cafe","Welcome to Tokiyo"
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
        Intent i = new Intent(Pune_list.this,MainActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mumbai_list);

        Custom_list adapter = new Custom_list(Pune_list.this,hotels,imageid);
        list = findViewById(R.id.list_pune);
        list.setAdapter(adapter);
    }
}