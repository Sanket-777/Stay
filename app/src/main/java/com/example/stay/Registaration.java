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

public class Registaration extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private static final String TAG = "EmailPassword";
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";  //Email Pattern to recognise the email is valid or not


    EditText username,email,password,confmpassword;
    Button register,link_to_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser()!=null)
        {
            startActivity(new Intent(Registaration.this,MainActivity.class));
            finish();
        }
        setContentView(R.layout.activity_registaration);

        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        confmpassword=findViewById(R.id.confpassword);
        register = findViewById(R.id.login_button);
        link_to_login=findViewById(R.id.Sign_in_button);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }


        });
        link_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Registaration.this,Login.class);
                startActivity(i);
            }
        });

    }

    private void signup(){
        Log.d(TAG,"signup"+email);
        if (!validateform())
        {
            return;
        }
        String em = email.getText().toString();
        String pw = password.getText().toString();

        mAuth.createUserWithEmailAndPassword(em,pw)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Registaration.this,"Registration Sucessfull You Can Now Sign in ",Toast.LENGTH_SHORT).show();

                        }
                        else
                        {
                            Log.w(TAG,"Failed to Sign-up",task.getException());
                            Toast.makeText(Registaration.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
    private boolean validateform() {
        boolean valid = true;

         String us =username.getText().toString();
        if(TextUtils.isEmpty(us)){
            username.setError("Field Empty");
            valid = false;
        }
        else
        {
            username.setError(null);
        }
        String em = email.getText().toString();
        if(TextUtils.isEmpty(em)){
            email.setError("Field Empty");
            valid = false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(em).matches()) {
            Toast.makeText(getApplicationContext(),"Invalid email address",Toast.LENGTH_SHORT).show();
            valid = false;
        }
        else
        {
            email.setError(null);
        }
// onClick of button perform this simplest code.
        String pw = password.getText().toString();
        if(TextUtils.isEmpty(pw)){
            password.setError("Field Empty");
            valid = false;
        }
        else
        {
            password.setError(null);
        }
         String cpw = confmpassword.getText().toString();
        if(TextUtils.isEmpty(cpw)){
            confmpassword.setError("Field Empty");
            valid = false;
        }
        else
        {
            confmpassword.setError(null);
        }
        if(!(cpw.equals(pw)))
        {
            confmpassword.setError("Password Not Match");
        }
        else
        {
            confmpassword.setError(null);
        }
        return valid;
    }
}
