package com.example.vitalya.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RefuelingActivity extends AppCompatActivity implements View.OnClickListener  {
    EditText editTextL;
    EditText editTextR;
    EditText editTextKm;
    EditText data;
    TextView textViewRub;
    Button buttonSave;
    Button buttonMainMenu;

    float num1 = 0;
    float num2 = 0;
    float result = 0;
    //для записи в файл

    //Создаем переменные для вызова календаря
    private EditText callcalendar;
    private DatePickerDialog datepicker;
    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_refueling );

        //Указываем формат даты
        dateFormatter=new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        //Создаем методы для запуска календаря
        findViewsByID();
        setDateTimeField();

        editTextL = findViewById( R.id.editTextL );
        editTextR = findViewById( R.id.editTextR );
        editTextKm = findViewById( R.id.editTextKm );
        data = findViewById( R.id.editTextCalendar );
        textViewRub = findViewById( R.id.textViewRub );

        buttonSave = findViewById( R.id.buttonSave );
        buttonSave.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Проверяем если в поля "Заправлено" и "Цена за 1 литр" введены какие-либо значения и если нет, то выдаем предупреждения
                //Переменная warning1 вводится для проверки поля "Заправлено"
                String warning1=editTextL.getText().toString();
                //Переменная warning2 вводится для проверки поля "Цена за 1 литр"
                String warning2=editTextR.getText().toString();
                String msgtext="Введите значение";
                if(TextUtils.isEmpty(warning1)){
                    //Собственно само сообщение
                    editTextL.setError(msgtext);
                    return;
                }
                if(TextUtils.isEmpty(warning2)){
                    editTextR.setError(msgtext);
                    return;
                }
                // читаем EditText и заполняем переменные числами
                num1 = Float.parseFloat(editTextL.getText().toString());
                num2 = Float.parseFloat(editTextR.getText().toString());
                result = num1 * num2;

                String summa = result+";"+";"+editTextKm+";"+editTextL+"\n";
                        //Вывод на экран

                textViewRub.setText(result + " руб. ");
                //Запись в файл
                try {
                    FileOutputStream fileout=openFileOutput("mytextfile.txt", MODE_APPEND);
//                    PrintStream printStream=new PrintStream(fileout);
//                    printStream.print(textViewRub.getText().toString()+"\n");
//                    fileout.close();

                    fileout.write(summa.getBytes());
                    fileout.close();


                    //display file saved message
                    Toast.makeText(getBaseContext(), "Файл сохранен!",
                            Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        buttonMainMenu=findViewById(R.id.buttonMainMenu);
        buttonMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GoToMainMenu=new Intent(RefuelingActivity.this,MainActivity.class);
                startActivity(GoToMainMenu);
            }
        });
        // write text to file

        // add-write text into file

    }

    //Описываем методы
    private void findViewsByID(){
        callcalendar=(EditText) findViewById(R.id.editTextCalendar);
        callcalendar.setInputType(InputType.TYPE_NULL);
        callcalendar.requestFocus();
    }
    private void setDateTimeField(){
        callcalendar.setOnClickListener(this);
        Calendar newCalendar=Calendar.getInstance();
        datepicker=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar newDate=Calendar.getInstance();
                newDate.set(year,month,dayOfMonth);
                callcalendar.setText(dateFormatter.format(newDate.getTime()));
            }
        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

    }

    @Override
    public void onClick(View view) {
        if(view == callcalendar) {
            datepicker.show();
        }
    }

}








