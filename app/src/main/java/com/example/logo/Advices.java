package com.example.logo;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Advices extends AppCompatActivity {

    RecyclerView adv;
    String strAdvices1[] , strDescription[];
    RecyclerView.LayoutManager mLayoutManager;
    int imagelogo[] = {R.drawable.sleep,
            R.drawable.water1,
            R.drawable.food,
            R.drawable.sport,
            R.drawable.heart,
            R.drawable.breath,
            R.drawable.blood,
            R.drawable.temp,
            R.drawable.smoking,
            R.drawable.health
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advices);
        adv=findViewById(R.id.adv);
        strAdvices1= getResources().getStringArray(R.array.Advices1);
        strDescription= getResources().getStringArray(R.array.description);

        MyAdapter mAdapter = new MyAdapter(this,strAdvices1,strDescription,imagelogo);
        adv.setAdapter(mAdapter);
        mLayoutManager = new LinearLayoutManager(this);
        adv.setLayoutManager(mLayoutManager);
        adv.setHasFixedSize(true);
    }

}