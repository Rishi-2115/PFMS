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
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class KVP extends AppCompatActivity {
    EditText kvno,ho_name,amount_kvp,mamount,stadate,endate,poadd;

    Button btn_add;

    SQLHelper helpers = null;
    SQLiteDatabase databases = null;

    private DatePicker datePicker,datePicker2;
    private Calendar calendar,calendar2;
    private int year, month, day;
    private int year2, month2, day2;
    String a11, b11, c11, d11, e11, f11, g11,z11;
    int x,y;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kvp);



        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        calendar2 = Calendar.getInstance();
        year2 = calendar2.get(Calendar.YEAR);
        month2 = calendar2.get(Calendar.MONTH);
        day2 = calendar2.get(Calendar.DAY_OF_MONTH);

        kvno = (EditText)findViewById(R.id.kvpno);
        ho_name = (EditText)findViewById(R.id.HNAME);
        amount_kvp = (EditText)findViewById(R.id.AMTT);
        mamount = (EditText)findViewById(R.id.MAMT);
        stadate = (EditText)findViewById(R.id.startingdate);
        endate = (EditText)findViewById(R.id.endingdate);
        poadd = (EditText)findViewById(R.id.POSTADDRESS);

        btn_add = (Button)findViewById(R.id.add_kvp);


        amount_kvp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                int len = charSequence.length();
                if (len==0)
                {
                    amount_kvp.requestFocus();
                    mamount.setText("");
                }
                else
                {
                    c11 = amount_kvp.getText().toString();
                    x = Integer.parseInt(c11);
                    y = x * 2;
                    z11 = Integer.toString(y);
                    mamount.setText(z11);
                    d11 = mamount.getText().toString();

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

    public void add(View view) {
        String a = kvno.getText().toString();
        String b = ho_name.getText().toString();
        String c = amount_kvp.getText().toString();
        String e = stadate.getText().toString();
        String f = endate.getText().toString();
        String g = poadd.getText().toString();

        helpers = new SQLHelper(this);
        databases = helpers.getWritableDatabase();

        helpers.kvps(a,b,c,d11,e,f,g,databases);

        Toast.makeText(this, "Data Added", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(KVP.this,kvp_list.class);
        startActivity(intent);


    }

    public void show(View view) {
        showDialog(999);
    }

    public void show1(View view) {
        showDialog(1000);
    }

    protected Dialog onCreateDialog(int id)
    {
        if(id==999)
        {
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
        stadate.setText(new StringBuilder().append(day).append("/").append(month).append("/").append(year));

    }

    private void showDate2(int year, int month , int day) {

        endate.setText(new StringBuilder().append(day).append("/").append(month).append("/").append(year));
    }
}
