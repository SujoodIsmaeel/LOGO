package com.example.logo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class exercise extends AppCompatActivity {
   private TextView textView1;
   private Button btnwalking,btnrun,btncycling,btnhik,btnswim,btnmash,btnother;
   private Animation top;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
textView1=findViewById(R.id.textView1);
        btnwalking= findViewById(R.id.btnwalking);
        btnrun=findViewById(R.id.btnrun);
        btncycling=findViewById(R.id.btncycling);
        btnhik=findViewById(R.id.btnhik);
        btnswim=findViewById(R.id.btnswim);
        btnmash=findViewById(R.id.btnmash);
        btnother=findViewById(R.id.btnother);
        top = AnimationUtils.loadAnimation(this, R.anim.top_animation);

        textView1.setAnimation(top);

        initial();
        initial1();
        initial2();
        initial3();
        initial4();
        initial5();
        initial6();

        Toast.makeText(getApplicationContext(),  "onCreate", Toast.LENGTH_SHORT).show();
    }

    private void initial6() {
        btnhik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.setClass(exercise.this,Hiking.class);
                startActivity(intent);
            }
        });
    }

    private void initial5() {
        btnswim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.setClass(exercise.this,Swimming.class);
                startActivity(intent);
            }
        });
    }

    private void initial4() {
        btnwalking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.setClass(exercise.this,Walking.class);
                startActivity(intent);
            }
        });
    }

    private void initial3() {
        btnother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.setClass(exercise.this,Other.class);
                startActivity(intent);
            }
        });
    }

    private void initial2() {
        btncycling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.setClass(exercise.this,Cycling.class);
                startActivity(intent);
            }
        });

    }

    private void initial1() {
        btnrun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.setClass(exercise.this,Running.class);
                startActivity(intent);
            }
        });

    }

    private void initial() {
        btnmash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.setClass(exercise.this,Machines.class);
                startActivity(intent);
            }
        });


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