package com.example.travelexpenses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewPlace extends AppCompatActivity {
Button add_btn;
EditText Place;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_place);

    add_btn=findViewById(R.id.add_btn);
    Place=findViewById(R.id.place);
    add_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String s=Place.getText().toString();
            Intent intent=new Intent();
            intent.putExtra("place",s);
            setResult(2,intent);
            finish();
        }
    });

    }
}
