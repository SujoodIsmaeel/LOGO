package com.example.logo;




import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Calender extends AppCompatActivity {

    private   CalendarView calendarView;
    // Calendar calendar;


    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        calendarView = findViewById(R.id.calendarView);
        textView = findViewById(R.id.textView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                String myDate = "Year: " + year +" - "+  "Month: " +month +" - "+ "Day: " +dayOfMonth;
                Toast.makeText(getApplicationContext(),myDate,Toast.LENGTH_LONG).show();
                textView.setText(myDate);
            }
        });
        Toast.makeText(getApplicationContext(),  "onCreate", Toast.LENGTH_SHORT).show();
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