package com.example.logo;







import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;


public class Other extends AppCompatActivity {
    private VideoView video_view;
    private TextView textView1;
    private Button button;
    private Animation top;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        textView1=findViewById(R.id.textView1);
        button=findViewById(R.id.button);
        top = AnimationUtils.loadAnimation(this, R.anim.top_animation);

        textView1.setAnimation(top);

        initial();
    }
    private void initial() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.setClass(Other.this,StopWatch.class);
                startActivity(intent);
            }
        });
    }
}