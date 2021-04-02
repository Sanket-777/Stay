package com.example.stay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private FirebaseAuth  mAuth ;
    private static final  String TAG = "EmailPassword";

    EditText email,password;
    Button signin,frgpass,link_to_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser()!=null)
        {
            startActivity(new Intent(Login.this,MainActivity.class) );
            finish();
        }
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signin = findViewById(R.id.login_button);
        frgpass = findViewById(R.id.forgotpasword_button);
        link_to_signup = findViewById(R.id.Sign_up_button);

        link_to_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this,Registaration.class);
                startActivity(i);
                finish();
            }
        });

        frgpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,Forgotpassword.class));

            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                signIn();
            }
        });
    }

    private void signIn() {

        Log.d(TAG,"signin"+email);
        if (!validateform())
        {
            return;
        }

        String em = email.getText().toString();
        String pw = password.getText().toString();


        mAuth.signInWithEmailAndPassword(em,pw)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(Login.this,"Sign-In Sucessfull",Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Login.this,MainActivity.class);
                            startActivity(i);
                            finish();
                        }
                        else
                        {
                            Log.w(TAG,"Failed to Sign-in",task.getException());
                            Toast.makeText(Login.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }


    private boolean validateform() {
        boolean valid = true;
        String em = email.getText().toString();
        if(TextUtils.isEmpty(em)){
            email.setError("Field Empty");
            valid = false;
        }

        else
        {
            email.setError(null);
        }

        String pw = password.getText().toString();
        if(TextUtils.isEmpty(pw)){
            password.setError("Field Empty");
            valid = false;
        }
        else
        {
            password.setError(null);
        }
        return valid;

        }



}