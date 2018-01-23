package com.example.vitalya.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    Button buttonrefueling;
    Button buttonrepairs;
    Button buttonlater;
    //переменные для отображения топлива
    static final int READ_BLOCK_SIZE = 100;
    TextView expenses;
    Button buttonreset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Отображаем значение стоимости заправленного топлива в поле editMoney
        expenses = findViewById(R.id.textMoney);
        try {
            FileInputStream inputStream = new FileInputStream("mytextfile.txt");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (bufferedReader.ready()) {
                String s = bufferedReader.readLine();
                String[] array = s.split(";");
                // индекс 0 -км; индекс 1 -л; индекс 2 -р;
                int km = 0;
                int l = 0;
                for (int i = 0; i < array.length; i++) {
                    switch (i) {
                        case 0:
                            km += Integer.parseInt(array[i]);
                            break;
                        case 1:
                            l += Integer.parseInt(array[i]);
                            break;
                    }
                    expenses.setText(km);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


//            InputStreamReader InputRead = new InputStreamReader(fileIn);
//
//            char[] inputBuffer = new char[READ_BLOCK_SIZE];
//            String s = "";
//            int charRead;
//            while ((charRead = InputRead.read(inputBuffer)) > 0) {
//                // char to string conversion
//                String readstring = String.copyValueOf(inputBuffer, 0, charRead);
//                s += readstring;
//            }
//            InputRead.close();
//            // Toast.makeText(getBaseContext(), s, Toast.LENGTH_SHORT).show();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        buttonrefueling = findViewById(R.id.buttonreFueling);
        buttonrepairs = findViewById(R.id.buttonRepairs);
        buttonlater = findViewById(R.id.buttonLater);

        buttonrefueling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RefuelingActivity.class);
                startActivity(intent);
            }
        });
        buttonrepairs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RepairsActivity.class);
                startActivity(intent);
            }
        });
        buttonlater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LaterActivity.class);
                startActivity(intent);
            }
        });
        buttonreset = findViewById(R.id.reset);
        buttonreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteFile("mytextfile.txt");
                recreate();
//
            }
        });


    }
}