package com.example.logo;


import static android.accounts.AccountManager.KEY_PASSWORD;
import static android.app.ProgressDialog.show;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class LogInActivity2 extends AppCompatActivity {
    public static final String TAG = "TAG";
    String emailTxt;
    String passTxt;
    Button loginBtn, signINButt;
    //TextView signup;



    private String email;
    private String password;

    FirebaseFirestore firestore;
    //String userID;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in2);


        //EditText
        EditText mNameEt = findViewById(R.id.editTextuserName);
        EditText mpassEt = findViewById(R.id.editTextuserPass);
        //Button
        Button mSaveBtn = findViewById(R.id.buttonLogin);
        //  emailTxt = findViewById(R.id.editTextuserPass);
        //passTxt = findViewById(R.id.editTextuserPass);
        loginBtn = findViewById(R.id.buttonLogin);
        signINButt = findViewById(R.id.buttonSignin2);////

        firebaseAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();


        /*if (firebaseAuth.getCurrentUser()!= null){
            startActivity(new Intent( getApplicationContext(),LogInActivity2.class));
            finish();
        }*/

        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = preferences.edit();

        checkBox.setChecked(preferences.getBoolean("checked", false));

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                boolean isCheckedValue = isChecked;
                editor.putBoolean("checked", isChecked);
                editor.apply();

                if (checkBox.isChecked()) {
                    isCheckedValue = isChecked;
                    editor.putBoolean("checked", true);
                    editor.apply();
                } else {
                    editor.putBoolean("checked", false);
                    editor.apply();
                }
            }
        });

        //actionbar title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("First Activity");


        ///****************************
        //  public static final String TAG = "TAG";


        //***************************************
        //    setContentView(R.layout.activity_log_in2);

        //signup = findViewById(R.id.signup);



/*
            if (firebaseAuth.getCurrentUser()!= null){
                startActivity(new Intent( getApplicationContext(),Login.class));
                finish();
            }

            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(),Register.class));

                }
            });*/

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mNameEt.getText().toString().trim();
                String password = mpassEt.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    mNameEt.setError("Email is Required!");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    mpassEt.setError("Password is Required !");
                    return;

                }
                if (password.length() < 6) {
                    mpassEt.setError("Password must be more than 6 digits");
                    return;
                }


                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "login Successfully", Toast.LENGTH_SHORT).show();
                            Intent send = new Intent(LogInActivity2.this, MainActivity2.class);
                            startActivity(send);
                            // startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        } else {
                            Log.e("LoginActivity", "Login with email failed.", task.getException());
                            Toast.makeText(getApplicationContext(), "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });

//        mSaveBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String name = mNameEt.getText().toString();
//                String pass = mpassEt.getText().toString();
//
//                //activity intent
//                Intent intent = new Intent(LogInActivity2.this, MainActivity2.class);
//                intent.putExtra("NAME", name);
//                intent.putExtra("Pass", pass);
//                startActivity(intent);
//            }
//        });


        signINButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String name = mNameEt.getText().toString();
                String email = mNameEt.getText().toString();
                String pass = mpassEt.getText().toString();

                //activity intent
                Intent intent = new Intent(LogInActivity2.this, Regestration.class);
                intent.putExtra("email", email);
                intent.putExtra("Pass", pass);
                startActivity(intent);
            }
        });


/* mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Log.e("LoginActivity", "Login with email failed.", task.getException());
                                    Toast.makeText(LoginActivity.this, "Login failed. Please try again.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });*/


    }

    /*private void checkInstance(Bundle savedInstanceState) {
        if(savedInstanceState != null){

            emailTxt = savedInstanceState.getString("email");
            passTxt = savedInstanceState.getString("Pass");

            //emailTxt = savedInstanceState.getString("email");
            //passTxt = savedInstanceState.getBoolean("Pass");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putString("email",emailTxt);
        outState.putString("Pass",passTxt);
        //outState.putInt("SECONDS", seconds);
        //outState.putBoolean("RUNNING", running);


    }*/





    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),  "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),  "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),  "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),  "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),  "onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(),  "onRestart", Toast.LENGTH_SHORT).show();
    }
}