package com.example.travelexpenses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button create_trip,view_trip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StoreinFile storeinFile=new StoreinFile();
    create_trip=(Button)findViewById(R.id.create_trip);
    view_trip=(Button)findViewById(R.id.view_trip);

    create_trip.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getApplicationContext(),AddNewTrip.class);
            startActivity(intent);
        }
    });

    view_trip.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getApplicationContext(),YourTrips.class);
            startActivity(intent);
        }
    });
    }
}
