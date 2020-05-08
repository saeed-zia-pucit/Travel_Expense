package com.example.travelexpenses;

import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import static android.content.Context.MODE_PRIVATE;

public class StoreinFile {

    TripModel tripModel;

    public StoreinFile() {
    }

    public TripModel getTripModel() {
        return tripModel;
    }

    public void setTripModel(TripModel tripModel) {
        this.tripModel = tripModel;
    }

    public StoreinFile(TripModel tripModel) {
        this.tripModel = tripModel;
    }
    public void  storeFile(){
        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "travel.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append("its my messge");
            writer.flush();
            writer.close();
            //Toast.makeText(, "Saved", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
}
}
