package com.example.keshri_rakesh.pfms;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class mutual_funds_sip_add extends AppCompatActivity {

        EditText E1,E2,E3,E4,E5,E6,E7,E8,E9,E10,E11,E12,E13;
        Spinner spin1;
        Button bt3;
        String datas;

        SQLHelper sr = null;
        SQLiteDatabase lite = null;
    String[] d = {"FREQUENCY:","MONTHLY","QUATERLY","HALF YEARLY","YEARLY"};


        private DatePicker datePicker,datePicker2;
        private Calendar calendar,calendar2;
        private int year,month,day;
        private int year2,month2,day2;
        String bc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutual_funds_sip_add);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        calendar2 = Calendar.getInstance();
        year2 = calendar.get(Calendar.YEAR);
        month2 = calendar.get(Calendar.MONTH);
        day2 = calendar.get(Calendar.DAY_OF_MONTH);

        E1 = (EditText)findViewById(R.id.cnamet);
        E2 = (EditText)findViewById(R.id.flnoet);
        E3 = (EditText)findViewById(R.id.sdateet);
        E4 = (EditText)findViewById(R.id.todateet);
        E5 = (EditText)findViewById(R.id.amtet);
        E6 = (EditText)findViewById(R.id.het);
        E7 = (EditText)findViewById(R.id.baet);
        E8 = (EditText)findViewById(R.id.nouet);
        E9 = (EditText)findViewById(R.id.adet);
        E10 = (EditText)findViewById(R.id.plaet);
        E11 = (EditText)findViewById(R.id.et12);
        E12 = (EditText)findViewById(R.id.et13);

        spin1 = (Spinner)findViewById(R.id.spinner);
        bt3 = (Button)findViewById(R.id.b3);

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,d);
        spin1.setAdapter(adapter);

        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==1)
                {
                    bc = "MONTHLY";
                }
                if(i==2)
                {
                    bc = "QUARTERLY";

                }
                if(i==3)
                {
                    bc = "HALF YEARLY";

                }
                if(i==4)
                {
                    bc = "YEARLY";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

bt3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String a = E1.getText().toString();
        String b = E2.getText().toString();
        String  c = E3.getText().toString();
        String d = E4.getText().toString();
        String e = E5.getText().toString();
        String f = E6.getText().toString();
        String g = E7.getText().toString();
        String h = E8.getText().toString();
        String i = E9.getText().toString();
        String j = E10.getText().toString();
        String k = E11.getText().toString();
        String l = E12.getText().toString();
        sr = new SQLHelper(getApplicationContext());
        lite = sr.getWritableDatabase();

        sr.sip_add(a,b,c,d,e,bc,f,g,h,i,j,k,l,lite);

        Toast.makeText(getBaseContext(), "Data ADDED", Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(mutual_funds_sip_add.this,mutual_funds_sip_list.class);
        startActivity(intent1);




    }
});
    }

    public void show(View view) {
        showDialog(999);
    }

    public void show1(View view) {
        showDialog(1000);
    }

    protected Dialog onCreateDialog(int id)
    {
        if(id==999){
            return new DatePickerDialog(this, myDateListener, year, month, day);

        }
        else if(id==1000){
            return new DatePickerDialog(this, getMyDateListener, year2, month2, day2);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            showDate(i,i1+1,i2);
        }
    };

    private DatePickerDialog.OnDateSetListener getMyDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            showDate2(i,i1+1,i2);
        }
    };

    private void showDate(int year,int month, int day)
    {
        E3.setText(new StringBuilder().append(day).append("/").append(month).append("/").append(year));
    }
    private void showDate2(int year, int month, int day)
    {
        E4.setText(new StringBuilder().append(day).append("/").append(month).append("/").append(year));
    }
}
