package com.example.stay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class detail extends AppCompatActivity {
    private String title;
    private TextView t1,t2,t3,t4;
    Button b1;
    DatabaseReference myref;
    private static final String TAG = "detail";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle bundle = getIntent().getExtras();
        title = bundle.getString("key" );
        Toast.makeText(this,title,Toast.LENGTH_SHORT).show();


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myref = database.getReference("cities");
        myref = myref.child("Mumbai").child(title);

        t1 = findViewById(R.id.mum_hotel_name);
        t2 = findViewById(R.id.mum_hotel_addr);
        t3 = findViewById(R.id.mum_hotel_details);
        t4 = findViewById(R.id.mum_hotel_price);

        b1 = findViewById(R.id.mum_hotel_conf);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(detail.this,"Your Booking will be Confirmed",Toast.LENGTH_SHORT).show();



            }
        });

        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                detail_activity temp = snapshot.getValue(detail_activity.class);
                t1.setText(temp.name);
                t2.setText(temp.addr);
                t3.setText(temp.price);
                t4.setText(temp.detail);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Log.w(TAG,"Failed To read values",error.toException());
                Toast.makeText(detail.this,"Failed to load Post",Toast.LENGTH_SHORT).show();
            }
        });




    }

}