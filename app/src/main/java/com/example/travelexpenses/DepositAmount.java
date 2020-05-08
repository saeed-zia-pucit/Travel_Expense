package com.example.travelexpenses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class DepositAmount extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{
Button deposit;
EditText exp1,exp2;
String cat="Fair";
String[] category = { "Fair", "Food", "Taxi"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit_amount);

        Intent intent=getIntent();
        final String trip_name=intent.getStringExtra("title");
     //
        Spinner spin = (Spinner) findViewById(R.id.spinner2);
        spin.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,category);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
    //
    deposit=findViewById(R.id.deposit);
    exp1=findViewById(R.id.exp1);
    exp2=findViewById(R.id.exp2);
    deposit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TripData tripData=new TripData();
            tripData.saveDeposit(new ExpenseModel(trip_name,cat,exp1.getText().toString(),exp2.getText().toString()));
        }
    });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        cat=category[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
