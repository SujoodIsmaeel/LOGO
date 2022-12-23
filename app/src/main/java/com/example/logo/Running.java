package com.example.logo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


public class Running extends AppCompatActivity {
    private VideoView video_view;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running);
        video_view=findViewById(R.id.video_view);
        button=findViewById(R.id.button);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.running;
        Uri uri = Uri.parse(videoPath);
        video_view.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        video_view.setMediaController(mediaController);
        mediaController.setAnchorView(video_view);
        initial();
    }
    private void initial() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.setClass(Running.this,StopWatch.class);
                startActivity(intent);
            }
        });
    }
}