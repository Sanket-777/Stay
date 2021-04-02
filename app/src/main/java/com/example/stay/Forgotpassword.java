package com.example.stay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forgotpassword extends AppCompatActivity {
    EditText email;
    Button done;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        email = findViewById(R.id.frg_email);
     done = findViewById(R.id.frg_done_button);

     firebaseAuth = FirebaseAuth.getInstance();
      done.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              firebaseAuth.sendPasswordResetEmail(email.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                  @Override
                  public void onComplete(@NonNull Task<Void> task) {
                      if(task.isSuccessful())
                      {
                          Toast.makeText(Forgotpassword.this,"Password reset Link is send to your email",Toast.LENGTH_SHORT).show();
                      }
                      else
                      {
                          Toast.makeText(Forgotpassword.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                      }

                  }
              });
          }
      });
    }
}