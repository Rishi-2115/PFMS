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

public class shares extends AppCompatActivity {
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    SQLHelper helper=null;
    SQLiteDatabase database=null;
    Button bt1;
    EditText e1,e2,e3,e4,e5,sh_id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shares);

        e1=(EditText)findViewById(R.id.et1);
        e2=(EditText)findViewById(R.id.et2);
        e3=(EditText)findViewById(R.id.et3);
        e4=(EditText)findViewById(R.id.et4);
        e5=(EditText)findViewById(R.id.et5);
        sh_id=(EditText)findViewById(R.id.sh_id);
        bt1=(Button)findViewById(R.id.btn1);

        helper=new SQLHelper(this);
        database=helper.getWritableDatabase();



        dateView = (TextView) findViewById(R.id.tv5);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

    }

    public void setDate(View view) {
        showDialog(999);
        //Toast.makeText(getApplicationContext(), "ca",
               // Toast.LENGTH_SHORT)
                //.show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }
    public void s_data(View v)
    {
        String id=sh_id.getText().toString();
        String c_name=e1.getText().toString();
        String h_name=e2.getText().toString();
        String p_date=dateView.getText().toString();
        String no_of_shares=e3.getText().toString();
        String total_amt=e4.getText().toString();
        String bank_name=e5.getText().toString();

        if (id.isEmpty() || c_name.isEmpty()||h_name.isEmpty()||p_date.isEmpty()||no_of_shares.isEmpty()||total_amt.isEmpty()||bank_name.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Fill out all the fields!!", Toast.LENGTH_SHORT).show();
        }
                /*else {
                    String query = "insert into trans values('"+a+"','"+ab+"','"+b+"','"+bc+"','"+rad1+"','"+c+"','"+d+"','"+e+"','"+f+"');";
                    database.execSQL(query);
                    Toast.makeText(getApplicationContext(), "RECORD ADDED", Toast.LENGTH_SHORT).show();

                }*/
        else {
            helper.shares(id, c_name, h_name, p_date, no_of_shares, total_amt, bank_name,database);

                Toast.makeText(getBaseContext(),"record inserted"+id+c_name, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(shares.this,share_list.class);
                startActivity(i);
                helper.close();



        }

        /*String query="insert into shares values('+c_name+','+h_name+','+p_date+','+no_of_shares+','+total_amt+','+bank_name+');";
        database.execSQL(query);
        Toast.makeText(this,"your record inserted successfully",Toast.LENGTH_LONG).show();

        Intent i = new Intent(this,sec1.class);
        startActivity(i);*/
    }


}
