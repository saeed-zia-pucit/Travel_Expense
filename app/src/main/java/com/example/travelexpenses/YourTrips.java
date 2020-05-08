package com.example.travelexpenses;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class YourTrips extends AppCompatActivity {

    ListView list;
    ArrayList<TripModel> trips;
String status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_trips);

        Intent intent=getIntent();

           addTrip();

        trips=new ArrayList<TripModel>();

        final YourTripsAdapter adapter;
//

        //
ArrayList<String>names=new ArrayList<String>();
names=new TripData().getTripNames();

        adapter = new YourTripsAdapter(this, names, R.layout.trip_list);


        list=(ListView)findViewById(R.id.trip_listview);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub


//
//                final TextView tv_id = (TextView) view.findViewById(R.id.employe_phone);
//                String phone = tv_id.getText().toString();
              Toast.makeText(getApplicationContext(),"list clikview",Toast.LENGTH_SHORT).show();

//
//


            }
        });


    }

protected static void addTrip(){

    TripData tripData=new TripData();
    tripData.add_trip(new TripModel("Northen Areas","Its a tour to northern aresa,to spend vacation","Ali Hassan",
            "Hasanat Amir",0,0));

    // tripData.add_trip(new TripModel("Mountain Hills","Its a tour to northern aresa,to spend vacation","Ahmad","Usama",
    //      100,100));

    tripData.add_expense(new ExpenseModel("Northen Areas","Fair","0","0"));
    tripData.add_expense(new ExpenseModel("Northen Areas","Food","0","0"));
    tripData.add_expense(new ExpenseModel("Northen Areas","Taxi","0","0"));



}
}

