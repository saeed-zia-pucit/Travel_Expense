package com.example.travelexpenses;


import android.app.Activity;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class YourTripsAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList<String> trip_names;

    public YourTripsAdapter(Activity context, ArrayList<String> trip_names,int layout) {
        super(context, layout,trip_names);
        // TODO Auto-generated constructor stub
        this.context=context;
        this.trip_names=trip_names;



    }

    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.trip_list, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.trip_name);


        titleText.setText(trip_names.get(position));


        Button detail=(Button)rowView.findViewById(R.id.detail);
        Button visit=(Button)rowView.findViewById(R.id.visit_place);


        visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final TextView tv_id = (TextView) v.findViewById(R.id.trip_name);
                String name= trip_names.get(position).toString();
                Toast.makeText(context,"visit clikview",Toast.LENGTH_SHORT).show();
Intent intent=new Intent(context,VisitPlaces.class);
context.startActivity(intent);

            }
        });

        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView tv_id = (TextView) v.findViewById(R.id.trip_name);
                String name= trip_names.get(position).toString();


                Intent intent=new Intent(context,TripDetail.class);
                intent.putExtra("trip_name",name);
                context.startActivity(intent);
            }
        });


        return rowView;

    };


    public  void addnewTrip(String s){
        //trip_names.add(s);
        //notifyDataSetChanged();
    }
}
