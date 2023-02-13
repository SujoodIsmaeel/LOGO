package com.example.logo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Regestration extends AppCompatActivity {


    EditText username,emailTxt, passTxt;
    Button signINButt;
    FirebaseFirestore firestore;
    String userID;
    FirebaseAuth firebaseAuth;
    Button buttonSignin;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_regestration);



           // EditText mNameEt = findViewById(R.id.editTextuserName);
            EditText emailTxt = findViewById(R.id.editTextEmail);
            EditText mpassEt = findViewById(R.id.editTextuserPass);
            Button buttonSignin = findViewById(R.id.buttonSignin);

            firebaseAuth = FirebaseAuth.getInstance();
            firestore = FirebaseFirestore.getInstance();

            signINButt = findViewById(R.id.buttonSignin);

            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("First Activity");

            signINButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String username = mNameEt.getText().toString();
                String email = emailTxt.getText().toString();
                String pass = mpassEt.getText().toString();

                //activity intent
                Intent intent = new Intent(Regestration.this, LogInActivity2.class);
                //intent.putExtra("NAME", username);
                intent.putExtra("email", email);
                intent.putExtra("Pass", pass);
                startActivity(intent);
            }
        });

            buttonSignin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email = emailTxt.getText().toString().trim();
                    String password =  mpassEt.getText().toString().trim();

                    if (TextUtils.isEmpty(email)){
                        emailTxt.setError("Email is Required!");
                        return;
                    }
                    if (TextUtils.isEmpty(password)) {
                        passTxt.setError("Password is Required !");
                        return;

                    }
                    if (password.length()< 6){
                        passTxt.setError("Password must be more than 6 digits");
                        return;
                    }

                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"login Successfully",Toast.LENGTH_SHORT).show();
                                Intent send = new Intent(Regestration.this, LogInActivity2.class);
                                startActivity(send);
                                // startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"Error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }
            });


    }
}