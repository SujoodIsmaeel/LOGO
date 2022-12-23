package com.example.logo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SignUpActivity extends AppCompatActivity {
    private EditText password,email;
    private Button signup1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        email = findViewById(R.id.email);
        password =findViewById(R.id.password);
        signup1= (Button) findViewById(R.id.signup1);


        initial();



    }

    private void initial() {
        signup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(SignUpActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });


    }
}