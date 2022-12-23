package com.example.logo;


import static android.app.ProgressDialog.show;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogInActivity2 extends AppCompatActivity {
    private EditText email,Password;
    private Button login;
    private TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in2);
        email= findViewById(R.id.email);
        Password=findViewById(R.id.Password);
        login=findViewById(R.id.login);
        signup=findViewById(R.id.signup);
        initial();
        Toast.makeText(getApplicationContext(),  "onCreat", Toast.LENGTH_SHORT).show();

    }


    private void initial(){
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.setClass(LogInActivity2.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginWithEmail(email.getText().toString(),Password.getText().toString());
                Intent intent= new Intent();
                intent.setClass(LogInActivity2.this,MainActivity2.class);
                startActivity(intent);
            }
        });


    }
    private void loginWithEmail(String em,String pas){
        if(em.length()>4 && pas.length() >8){

        }else {
            if(em.length()< 4){
                email.setError("email not valid");
            }
            if (pas.length()< 8){
                Password.setError("Password is short");
            }
        }
    }

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