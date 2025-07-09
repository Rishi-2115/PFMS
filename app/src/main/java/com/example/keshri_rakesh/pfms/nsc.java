package com.example.keshri_rakesh.pfms;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class nsc extends AppCompatActivity {

    private DatePicker datePicker,datePicker1;
    private Calendar calendar,c1;
    private EditText dateView,dateView1;
    private int year, month, day,y1,m1,d1;
    SQLHelper helper=null;
    SQLiteDatabase database=null;
    Button bt1;
    EditText e1,e2,e5,e6,e7,e8;
    public boolean doubleBackToExitPressedOnce=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nsc);
        e1=(EditText)findViewById(R.id.et1);
        e2=(EditText)findViewById(R.id.et2);
        e5=(EditText)findViewById(R.id.et5);
        e6=(EditText)findViewById(R.id.et6);
        e7=(EditText)findViewById(R.id.et7);
        e8=(EditText)findViewById(R.id.et8);
        bt1=(Button)findViewById(R.id.btn1);

        helper=new SQLHelper(this);
        database=helper.getWritableDatabase();



        dateView = (EditText) findViewById(R.id.et3);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        // showDate(year, month+1, day);

        dateView1 = (EditText) findViewById(R.id.et4);
        c1 = Calendar.getInstance();
        y1 = c1.get(Calendar.YEAR);
        m1 = c1.get(Calendar.MONTH);
        d1 = c1.get(Calendar.DAY_OF_MONTH);
        // showdDate(y1, m1+1, d1);
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);



    }
    public void setdDate(View view)
    {
        showDialog(1000);

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        else if(id == 1000)
        {
            return new DatePickerDialog(this,
                    myDateListener1, y1, m1, d1);

        }
        return null;

    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {

                    showDate(arg1, arg2+1, arg3);
                }
            };
    private DatePickerDialog.OnDateSetListener myDateListener1 = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2)
                {
                    showDate1(i,i1+1,i2);

                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    private void showDate1(int y1, int m1, int d1) {
        dateView1.setText(new StringBuilder().append(d1).append("/")
                .append(m1).append("/").append(y1));
    }
    public void add(View v)
    {
        String nsc_no=e1.getText().toString();
        String h_name=e2.getText().toString();
        String s_date=dateView.getText().toString();
        String e_date=dateView1.getText().toString();
        String amt=e5.getText().toString();
        String roi=e6.getText().toString();
        String m_amt=e7.getText().toString();
        String p_add=e8.getText().toString();

        if(nsc_no.isEmpty()| h_name.isEmpty()| s_date.isEmpty()| e_date.isEmpty()| amt.isEmpty() | roi.isEmpty() | m_amt.isEmpty()| p_add.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Fill all Records!", Toast.LENGTH_SHORT).show();
            //this.finish();

        }
        else {
            helper.nsc(nsc_no, h_name, s_date, e_date, amt, roi, m_amt, p_add,database);

                Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(nsc.this,nsc_list.class);
                startActivity(intent);



        }


        /*String query="insert into nsc values('+nsc_no+','+h_name+','+s_date+','+e_date+','+amt+','+roi+','+m_amt+','+p_add+');";
        database.execSQL(query);
        Toast.makeText(this,"your record inserted successfully",Toast.LENGTH_LONG).show();

        e1.setText("");        e2.setText("");         e5.setText("");
        e6.setText("");        e7.setText("");        e8.setText("");
        dateView1.setText("");        dateView.setText("");*/





        /*Intent i = new Intent(this,sec.class);
        startActivity(i);*/
    }
    /*@Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;

        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();

        //this.finish();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
        //this.finish();

    }*/


}




