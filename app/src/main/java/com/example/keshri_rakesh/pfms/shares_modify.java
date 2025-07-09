package com.example.keshri_rakesh.pfms;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
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

public class shares_modify extends AppCompatActivity {
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    SQLHelper hl = null;
    SQLiteDatabase db = null;
    Button btnn,btnn1;
    EditText edt1,edt2,edt3,edt4,edt5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shares_modify);
        edt1 = (EditText)findViewById(R.id.companynameet);
        edt2 = (EditText)findViewById(R.id.holdernameet);
        edt3 = (EditText)findViewById(R.id.noofshareset);
        edt4 = (EditText)findViewById(R.id.totalamtet);
        edt5 = (EditText)findViewById(R.id.BANKNAMEet);
        btnn = (Button)findViewById(R.id.update_shares);
        btnn1 = (Button)findViewById(R.id.delete_shares);


        hl = new SQLHelper(this);
        db = hl.getWritableDatabase();

        Intent intent = getIntent();
        final String sid = intent.getStringExtra("sid");
        String cname = intent.getStringExtra("cname");
        String hname = intent.getStringExtra("hname");
        //String pdate = intent.getStringExtra("pdate");
        String noofshares = intent.getStringExtra("noofshares");
        String totalamt = intent.getStringExtra("totalamt");
        String bname = intent.getStringExtra("bname");

        edt1.setText(cname);
        edt2.setText(hname);
        //dateView.setText(pdate);
        edt3.setText(noofshares);
        edt4.setText(totalamt);
        edt5.setText(bname);

        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(shares_modify.this);
                builder.setTitle("Confirmation!");
                builder.setMessage("Surely want to update?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String cname = edt1.getText().toString();
                        String hname = edt2.getText().toString();
                        //String pdate = dateView.getText().toString();
                        String noofshares = edt3.getText().toString();
                        String totalamt = edt4.getText().toString();
                        String bname = edt5.getText().toString();

                        hl.updateshares(sid,cname,hname,noofshares,totalamt,bname,db);
                        Toast.makeText(shares_modify.this, "data updated", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(shares_modify.this,share_list.class);
                        startActivity(intent1);


                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent1 = new Intent(shares_modify.this,share_list.class);
                        startActivity(intent1);
                    }
                });

                builder.show();
            }
        });

        btnn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(shares_modify.this);
                builder.setTitle("Confirmation!");
                builder.setMessage("Surely want to delete?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        hl.deleteshares(sid,db);
                        Toast.makeText(shares_modify.this, "data deleted", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(shares_modify.this,share_list.class);
                        startActivity(intent1);
                    }
                });

                builder.setNegativeButton("NO",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent1 = new Intent(shares_modify.this,share_list.class);
                        startActivity(intent1);
                    }
                });
                builder.show();
            }
        });





        /*dateView = (TextView) findViewById(R.id.tv5);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);*/
    }


    /*public void setDate1(View view) {
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
    }*/

}
