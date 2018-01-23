package com.example.vitalya.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import android.view.View.OnClickListener;

import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LaterActivity extends AppCompatActivity {
    //  EditText reading=findViewById(R.id.read);
    EditText writing;
    Button wr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_later);
        writing=findViewById(R.id.write);
        wr=findViewById(R.id.btnWrite);


//    protected void onClick(View view) {
//        // TODO Auto-generated method stub
//
//        try{
//            String etName =  writing.getText().toString();
//            if(!etName.trim().equals("")){
//                File file =new File("/sdcard/Accelerometer.html");
//
//                //if file doesnt exists, then create it
//                if(!file.exists()){
//                    file.createNewFile();
//                }
//
//
//                FileWriter fileWritter = new FileWriter(file.getName(),true);
//                BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
//                bufferWritter.write(etName);
//                bufferWritter.close();
//            }
//        }catch (IOException e) {
//
//            e.printStackTrace(); }
//
//
    }

}