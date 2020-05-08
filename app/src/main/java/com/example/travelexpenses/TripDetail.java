package com.example.travelexpenses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TripDetail extends AppCompatActivity {
TextView trip_memory,trip_name;
ArrayList<TripModel> tripList;
Button expense,saveDetail,deposit;
String tripName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_detail);
        trip_name=(TextView)findViewById(R.id.trip_name);
        trip_memory=(TextView)findViewById(R.id.trip_memory);
        expense=(Button)findViewById(R.id.show_expense);
deposit=findViewById(R.id.deposit_btn);


        TripData tripData=new TripData();
      tripList= tripData.getTrip_list();


        final Intent intent=getIntent();
        tripName=intent.getStringExtra("trip_name");
        for(TripModel trip :tripList){
          if(trip.trip_name.equals(tripName)){
              trip_name.setText(trip.trip_name);
              trip_memory.setText(trip.trip_detail);
                break;

          }
        }


      expense.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent1=new Intent(getApplicationContext(),TripExpense.class);
              intent1.putExtra("trip_name",tripName);
              startActivity(intent1);
          }
      });

    saveDetail=findViewById(R.id.save_detail);
    saveDetail.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            for(TripModel trip :tripList){
                if(trip.trip_name.equals(tripName)){
                   trip.setTrip_detail(trip_memory.getText().toString());
                    break;

                }
            }

        }
    });


    }

}

