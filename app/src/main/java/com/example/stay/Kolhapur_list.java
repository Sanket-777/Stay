package com.example.stay;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Kolhapur_list extends AppCompatActivity {
    ListView list;
    String hotelname;
    String hotels[]={
            "AAryan Hotel","Dawaat","Majestic Hotel","Assal Kolhapuri","Aroma  Biryani House","Sai  Restaurant","Panch Thali","Sharda Sucess"
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
        Intent i = new Intent(Kolhapur_list.this,MainActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_kolhapur);

        Custom_list adapter = new Custom_list(Kolhapur_list.this,hotels,imageid);
        list = findViewById(R.id.list_kolhapur);
        list.setAdapter(adapter);
    }
}