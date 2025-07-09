package com.example.keshri_rakesh.pfms;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class OfficeInsurance extends AppCompatActivity {
    private DatePicker datePicker,datePicker1;
    private Calendar calendar,c1;
    private TextView dateView,dateView1;
    private int year, month, day,y1,m1,d1;
    SQLHelper helper=null;
    SQLiteDatabase database=null;
    Button bt1;
    EditText e1,e2,e3,e4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office_insurance);

        e1=(EditText)findViewById(R.id.et1);
        e2=(EditText)findViewById(R.id.et2);
        e3=(EditText)findViewById(R.id.et5);
        bt1=(Button)findViewById(R.id.btn1);

        helper=new SQLHelper(this);
        database=helper.getWritableDatabase();



        dateView = (TextView) findViewById(R.id.tv9);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        // showDate(year, month+1, day);

        dateView1 = (TextView) findViewById(R.id.tv8);
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
    public void s_data(View v)
    {
        String p_no=e1.getText().toString();
        String branch=e2.getText().toString();
        String s_date=dateView.getText().toString();
        String d_date=dateView1.getText().toString();
        String i_amt=e3.getText().toString();

        if(p_no.isEmpty()| branch.isEmpty()| s_date.isEmpty()| d_date.isEmpty()| i_amt.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Fill all Records!", Toast.LENGTH_SHORT).show();

        }
        else {
            helper.oi(p_no, branch, s_date, d_date, i_amt,database);

                Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(OfficeInsurance.this,officeinsurance_list.class);
                startActivity(intent);
                this.finish();



        }

        //String query="insert into OfficeInsurance values('+p_no+','+branch+','+s_date+','+d_date+','+i_amt+');";
        //database.execSQL(query);
        //Toast.makeText(this,"your record inserted successfully",Toast.LENGTH_LONG).show();

        //Intent i = new Intent(this,Insaurance.class);
        //startActivity(i);
    }


}





