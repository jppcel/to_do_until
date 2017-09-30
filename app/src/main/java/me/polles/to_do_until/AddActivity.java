package me.polles.to_do_until;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Created by fabricio on 28/09/17.
 */

public class AddActivity extends AppCompatActivity {

    final Calendar myCalendar = Calendar.getInstance();
//    final TimePicker myTimer = new TimePicker(getApplicationContext());
    TextInputEditText atv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

        EditText choseDate = (EditText) findViewById(R.id.btnData);
//        EditText choseHour = (EditText) findViewById(R.id.btnHora);
        FloatingActionButton persist = (FloatingActionButton) findViewById(R.id.btnPersist);
        atv = ((TextInputEditText) findViewById(R.id.desc));

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            }

        };

//        final TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener(){
//
//            @Override
//            public void onTimeSet(TimePicker time, int hour, int min) {
//                myTimer.setHour(myCalendar.get(Calendar.HOUR));
//            }
//        };

        choseDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(AddActivity.this, date, Calendar.getInstance()
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

//        choseHour.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                new TimePickerDialog(AddActivity.this, time, Calendar.getInstance().get(Calendar.HOUR), Calendar.getInstance()
//                        .get(Calendar.MINUTE),true).show();
//            }
//        });

        persist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alerta;
                AlertDialog.Builder builder = new AlertDialog.Builder(AddActivity.this);
                //define o titulo
                builder.setTitle("Titulo");
                //define a mensagem
                builder.setMessage("A atividade: "+atv.getText().toString()+" com a data: "+ myCalendar.get(Calendar.DAY_OF_MONTH)+"/"+(myCalendar.get(Calendar.MONTH)+1) + " confere?");
                //define um botão como positivo
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(AddActivity.this, "Salvo com sucesso", Toast.LENGTH_SHORT).show();
                    }
                });
                //define um botão como negativo.
                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(AddActivity.this, "Sinto muito, salvei igual", Toast.LENGTH_SHORT).show();
                    }
                });
                //cria o AlertDialog
                alerta = builder.create();
                //Exibe
                alerta.show();
            }
        });
    }

}
