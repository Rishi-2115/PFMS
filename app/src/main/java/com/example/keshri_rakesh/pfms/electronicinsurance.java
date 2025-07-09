package com.example.keshri_rakesh.pfms;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class electronicinsurance extends AppCompatActivity {
    private Calendar calendar, calendar1, calendar2;
    private int year, month, day, year1, month1, day1, year2, month2, day2;

    SQLHelper helper = null;
    SQLiteDatabase database = null;

    EditText policy_no, int_amt;
    Spinner spin;
    EditText date1, date2, date3;
    Button btn1;
    String data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronicinsurance);

        helper = new SQLHelper(this);
        database = helper.getWritableDatabase();

        btn1 = (Button) findViewById(R.id.btn1);

        spin=(Spinner)findViewById(R.id.spin);

        policy_no = (EditText) findViewById(R.id.policy_no);
        int_amt = (EditText) findViewById(R.id.int_amt);

        //for picking dates

        date1 = (EditText) findViewById(R.id.date1);
        date2 = (EditText) findViewById(R.id.date2);
        date3 = (EditText) findViewById(R.id.date3);

        calendar2 = Calendar.getInstance();
        year2 = calendar2.get(Calendar.YEAR);
        month2 = calendar2.get(Calendar.MONTH);
        day2 = calendar2.get(Calendar.DAY_OF_MONTH);

        calendar1 = Calendar.getInstance();
        year1 = calendar1.get(Calendar.YEAR);
        month1 = calendar1.get(Calendar.MONTH);
        day1 = calendar1.get(Calendar.DAY_OF_MONTH);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month + 1, day);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                {
                    data="";
                }
                else if(i==1)
                {
                    data="Television";
                }
                else if(i==2)
                {
                    data="Laptop";
                }
                else if(i==3)
                {
                    data="Desktop";
                }
                else if(i==4)
                {
                    data="Mobile Phone";
                }
                data=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

      /*  ArrayAdapter<String> aa=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.items));
        spin.setAdapter(aa);*/

    }
        public void log (View view) {
            String policy = policy_no.getText().toString();
            String data=spin.getSelectedItem().toString();
            String interest_amt = int_amt.getText().toString();
            String s_date = date1.getText().toString();
            String e_date = date2.getText().toString();
            String d_date = date3.getText().toString();

            if (policy.isEmpty() | interest_amt.isEmpty() | s_date.isEmpty() | e_date.isEmpty() | d_date.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Fill all Records!", Toast.LENGTH_SHORT).show();

            } else {
                 helper.ei(policy, data, s_date, e_date, interest_amt, d_date,database);

                    Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(electronicinsurance.this,electronicinsurance_list.class);

                    startActivity(intent);
                    this.finish();

            }
        }



        /*btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String policy =policy_no.getText().toString();
                String interest_amt=int_amt.getText().toString();
                String s_date= date1.getText().toString();
                String e_date=date2.getText().toString();
                String d_date=date3.getText().toString();

                if(policy.isEmpty()| interest_amt.isEmpty()| s_date.isEmpty()| e_date.isEmpty()| d_date.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Fill all Records!", Toast.LENGTH_SHORT).show();

                }
                else {
                    Boolean oi=helper.oi(policy, interest_amt, s_date, e_date, d_date);
                    if(oi==true)
                    {
                        Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                        Intent k = new Intent(getApplicationContext(),Insaurance.class);
                        startActivity(k);
                    }

                }

                //String query="insert into user values('+policy+','+interest_amt+','+s_date+','+e_date+','+d_date+');";
               // database.execSQL(query);
                //Toast.makeText(electronicinsurance.this,"Insurance details added",Toast.LENGTH_LONG).show();
            }
        });
    }*/

        public void setDate (View view)

        {

            showDialog(999);
        }
        public void setDate1 (View view)
        {
            showDialog(1000);

        }
        public void setDate2 (View view)
        {
            showDialog(1001);

        }

        protected Dialog onCreateDialog ( int id)

        {
            //TODO Auto-generated method stub
            if (id == 999) {
                return new DatePickerDialog(this, myDateListener, year, month, day);
            } else if (id == 1000) {
                return new DatePickerDialog(this, myDateListener1, year1, month1, day1);
            } else if (id == 1001) {
                return new DatePickerDialog(this, myDateListener2, year2, month2, day2);
            }
            return null;
        }
        private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                showDate(i, i1 + 1, i2);
            }
        };
        private DatePickerDialog.OnDateSetListener myDateListener1 = new
                DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        showDate1(i, i1 + 1, i2);

                    }
                };
        private DatePickerDialog.OnDateSetListener myDateListener2 = new
                DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        showDate2(i, i1 + 1, i2);

                    }
                };

        private void showDate ( int year, int month, int day)
        {
            date1.setText(new StringBuilder().append(day).append("/").append(month).append("/").append(year));
        }

        private void showDate1 ( int year1, int month1, int day1){
            date2.setText(new StringBuilder().append(day1).append("/")
                    .append(month1).append("/").append(year1));
        }

        private void showDate2 ( int year2, int month2, int day2){
            date3.setText(new StringBuilder().append(day1).append("/")
                    .append(month1).append("/").append(year1));
        }
    }



