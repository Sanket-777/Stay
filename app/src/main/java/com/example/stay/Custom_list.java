package com.example.stay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class Custom_list extends ArrayAdapter {
    private final Activity  context;
    private final String[] hotel;
    private final Integer[] imageId;

    public Custom_list(Activity context,String[] hotel,Integer[] imageId) {
        super(context, R.layout.mum_custom_list,hotel);
        this.context = context;
        this.hotel= hotel;
        this.imageId = imageId;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mum_custom_list,null,true);
        TextView txtview = rowView.findViewById(R.id.txt);
        ImageView imageView = rowView.findViewById(R.id.mimg1);

        txtview.setText(hotel[position]);
        imageView.setImageResource(imageId[position]);


        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,detail.class);
                intent.putExtra("key",hotel[position]);
                context.startActivity(intent);
            }
        });

        return rowView;
    }



}
