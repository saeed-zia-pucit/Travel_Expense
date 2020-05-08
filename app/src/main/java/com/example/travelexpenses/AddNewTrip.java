package com.example.travelexpenses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AddNewTrip extends AppCompatActivity {
Button add_new;
EditText trip_name,mem1,mem2,detail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_trip);

    add_new=(Button)findViewById(R.id.add);
    add_new.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            trip_name=(EditText)findViewById(R.id.trip_name);
            mem1=(EditText)findViewById(R.id.part1);
            mem2=(EditText)findViewById(R.id.part2);
            mem2=(EditText)findViewById(R.id.part2);
            detail=(EditText)findViewById(R.id.detail);

            String name=trip_name.getText().toString();
            String details=detail.getText().toString();
            String m1=mem1.getText().toString();
            String m2=mem2.getText().toString();


            TripData tripData=new TripData();
            tripData.add_trip(new TripModel(name,details,m1,m2,0,0));
            tripData.add_expense(new ExpenseModel(name,"Fair","0","0"));
            tripData.add_expense(new ExpenseModel(name,"Food","0","0"));
            tripData.add_expense(new ExpenseModel(name,"Taxi","0","0"));



        }
    });

    }
}
