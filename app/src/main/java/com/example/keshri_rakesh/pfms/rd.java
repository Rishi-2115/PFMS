package com.example.keshri_rakesh.pfms;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;


public class rd extends AppCompatActivity {

    EditText et1, et2, et3, et4, et5 ,et6, et7;
    Button b1;

    SQLHelper helper=null;
    SQLiteDatabase database = null;

    private DatePicker datePicker,datePicker2;
    private Calendar calendar,calendar2;
    private int year, month, day;
    private int year2, month2, day2;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rd);

        helper = new SQLHelper(this);
        database = helper.getWritableDatabase();

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        calendar2 = Calendar.getInstance();
        year2 = calendar.get(Calendar.YEAR);
        month2 = calendar.get(Calendar.MONTH);
        day2 = calendar.get(Calendar.DAY_OF_MONTH);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        et5 = (EditText) findViewById(R.id.et5);
        et6 = (EditText) findViewById(R.id.et6);
        et7 = (EditText) findViewById(R.id.et7);

        b1=(Button)findViewById(R.id.button);

    }

    public void show(View view) {
        showDialog(999);

    }

    public void show1(View view)
    {
        showDialog(1000);
    }

    protected Dialog onCreateDialog(int id) {
        if (id == 999) {

            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        else if (id==1000)
        {
            return new DatePickerDialog(this, getMyDateListener, year2, month2, day2);
        }
        return null;


    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int arg1, int arg2, int arg3) {

            showDate(arg1, arg2 + 1, arg3);
        }
    };

    private DatePickerDialog.OnDateSetListener getMyDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int ar1, int ar2, int ar3) {
            showDate2(ar1, ar2 + 1, ar3);
        }
    };

    private void showDate(int year, int month , int day) {
        et5.setText(new StringBuilder().append(day).append("/").append(month).append("/").append(year));

    }

    private void showDate2(int year, int month , int day) {

        et6.setText(new StringBuilder().append(day).append("/").append(month).append("/").append(year));
    }


    public void log(View view) {
        String a, b, c, d, e, f, g;
        a = et1.getText().toString();
        b = et2.getText().toString();
        c = et3.getText().toString();
        d=et4.getText().toString();
        e = et5.getText().toString();
        f = et6.getText().toString();
        g = et7.getText().toString();



        if (a.isEmpty() | b.isEmpty() | c.isEmpty() | d.isEmpty() | e.isEmpty() | f.isEmpty() | g.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Fill all Records!", Toast.LENGTH_LONG).show();
        } /*else
                    {
                    String query = "insert into recurring values('+a+','+b+','+c+','+d+','+e+','+f+','+g+');";
                    database.execSQL(query);
                    Toast.makeText(getApplicationContext(), "Record Inserted Successfully...!!", Toast.LENGTH_LONG).show();
                    et1.setText("");et2.setText("");et3.setText("");
                    et4.setText("");et5.setText("");et6.setText("");
                    et7.setText("");
                    }*/
        else {
            helper.rd(a, b, c, d, e, f, g,database);

                Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(rd.this,rd_list.class);
            startActivity(i);



        }

    }
}
