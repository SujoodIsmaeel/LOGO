package com.example.logo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private Button exercise,stopW,advices,todo,calen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        exercise=findViewById(R.id.exercise);
        stopW=findViewById(R.id.stopW);
        advices=findViewById(R.id.advices);
        todo=findViewById(R.id.todo);
        calen=findViewById(R.id.calen);
        initial();
        initial1();
        initial2();
    }

    private void initial2() {
        exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.setClass(MainActivity2.this,exercise.class);
                startActivity(intent);
            }
        });

    }

    private void initial() {
        stopW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.setClass(MainActivity2.this,StopWatch.class);
                startActivity(intent);
            }
        });


    }
    private void initial1() {
        calen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.setClass(MainActivity2.this,Calender.class);
                startActivity(intent);
            }
        });


    }

   /* private void initiala() {
        advices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.setClass(MainActivity2.this,Advices.class);
                startActivity(intent);
            }
        });


    }*/



}