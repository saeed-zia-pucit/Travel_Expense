package com.example.travelexpenses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class TripExpense extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{
TextView name1,name2,Total;
EditText Exp1,Exp2;
ArrayList<TripModel> tripList;
ArrayList<ExpenseModel>expenseList;
Button Save1,Save2,deposit,share;
String selected_cat;
ExpenseModel tripExpense;
    String[] category = { "Fair", "Food", "Taxi"};
    String tripName="";
    FileOutputStream fstream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_expense);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());


        name1=findViewById(R.id.name1);
        name2=findViewById(R.id.name2);
        Exp1=findViewById(R.id.exp1);
        Exp2=findViewById(R.id.exp2);
        share=findViewById(R.id.share);
        Save1=findViewById(R.id.save);
        Save2=findViewById(R.id.save2);
        deposit=findViewById(R.id.deposit_btn);
        Intent intent=getIntent();
        tripName=intent.getStringExtra("trip_name");



        TripData tripData=new TripData();


        tripList= tripData.getTrip_list();

        expenseList=tripData.getExpense_list();

        //
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,category);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

//


        for(TripModel trip :tripList){
            if(trip.trip_name.equals(tripName)){
                name1.setText(trip.mem1);
                name2.setText(trip.mem2);
                Exp1.setText(trip.exp1+"");
                Exp2.setText(trip.exp2+"");
               // Total.setText(trip.exp1+trip.exp2+"");
                break;

            }
        }

    Save1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            for(ExpenseModel expense :expenseList){
                if(expense.trip_name.equals(tripName) && expense.category.equals(selected_cat)){


                    expense.setExp1(Exp1.getText().toString());
                   // Total.setText(expense.exp1+expense.exp2+"");

                    break;

                }
            }

        }
    });

        Save2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            for(ExpenseModel expense :expenseList){
                if(expense.trip_name.equals(tripName) && expense.category.equals(selected_cat)){


                    expense.setExp2(Exp2.getText().toString());
                   // Total.setText(Integer.parseInt(expense.exp1)+Integer.parseInt(expense.exp2)+"");

                    break;

                }
            }



        }
    });
        deposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),DepositAmount.class);
                intent1.putExtra("title",tripName);
                startActivity(intent1);
            }
        });


        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File myFile;
                String username = "name";
                String password = "password";
                try {
                    ActivityCompat.requestPermissions(TripExpense.this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},23);
                    File direct = new File(Environment.getExternalStorageDirectory() + "/expense.txt");

//                    if (!direct.exists()) {
//                        File wallpaperDirectory = new File("/sdcard/DirName/");
//                        wallpaperDirectory.mkdirs();
//                    }

//                    File file = new File("/sdcard/DirName/", "myfile.txt");
//                    if (file.exists()) {
//                        file.delete();
//                    }
                    String data=tripExpense.getTrip_name()+","+tripExpense.getCategory()+",Trip Expense of Member 1"+tripExpense.getExp1()+",Trip Expense of Member2"+tripExpense.getExp2();
                    fstream = new FileOutputStream(direct);
                    fstream.write(data.getBytes());
                   // fstream.write(password.getBytes());
                    fstream.close();
                    shareFile();




                    //
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
           //


           //
            }


        });
        //


    }
    private void shareFile() {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("plain/*");
        String imagePath = Environment.getExternalStorageDirectory()+ "/expense.txt";
        File imageFileToShare = new File(imagePath);

        Uri uri = Uri.fromFile(imageFileToShare);
        share.putExtra(Intent.EXTRA_STREAM, uri);
        startActivity(Intent.createChooser(share, "Share Expense!"));
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selected_cat=category[position];

        for(ExpenseModel expense :expenseList){
            if(expense.trip_name.equals(tripName) && expense.category.equals(selected_cat)){
               Exp1.setText(expense.getExp1());
               Exp2.setText(expense.getExp2());
                // Total.setText(expense.exp1+expense.exp2+"");
                tripExpense=expense;

                break;

            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


