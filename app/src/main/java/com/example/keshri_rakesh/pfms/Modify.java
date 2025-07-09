package com.example.keshri_rakesh.pfms;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Modify extends Activity {

    EditText edt1,amount,edt2,edt4,edt5;
    Spinner edt3;
    Button b1,b2;
    SQLHelper sqlHelper;
    SQLiteDatabase sqLiteDatabase;

    String[]  d = {"SELECT TYPE","MONTHLY","QUARTERLY","HALF YEARLY","YEARLY","ON MATURITY"};
    String ab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_modify);
        sqlHelper = new SQLHelper(this);
        sqLiteDatabase = sqlHelper.getWritableDatabase();


        edt1 =   (EditText)findViewById(R.id.ett1);
        amount=(EditText)findViewById(R.id.amount);
        edt2 = (EditText)findViewById(R.id.ett2);
        edt3 = (Spinner)findViewById(R.id.sp2);
        edt4 = (EditText)findViewById(R.id.ett4);
        edt5 = (EditText)findViewById(R.id.ett5);

        b1 = (Button)findViewById(R.id.btn_update);
        b2 = (Button)findViewById(R.id.btn_delete);

        Intent intent = getIntent();
        final String bid = intent.getStringExtra("bid");
        String scheme = intent.getStringExtra("scheme");
        String amt = intent.getStringExtra("amount");
        final String starts = intent.getStringExtra("starts");
        String inttype = intent.getStringExtra("inttype");
        String roi = intent.getStringExtra("roi");
        String mdate = intent.getStringExtra("mdate");

        edt1.setText(scheme);
        amount.setText(amt);
        edt2.setText(starts);
        //edt3.setText(inttype);
        edt4.setText(roi);
        edt5.setText(mdate);

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,d);
        edt3.setAdapter(adapter);

        edt3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==1)
                {
                    ab="MONTHLY";
                }
                if(i==2)
                {
                    ab="QUARTERLY";
                }
                if(i==3)
                {
                    ab="HALF YEARLY";
                }
                if(i==4)
                {
                    ab="YEARLY";
                }
                if(i==5)
                {
                    ab="ON MATURITY";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Modify.this);
                builder.setTitle("Confirmation!");
                builder.setMessage("Surely want to update?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String scheme = edt1.getText().toString();
                        String amt = amount.getText().toString();
                        String starts = edt2.getText().toString();
                        //String inttype = edt3.getText().toString();
                        String roi = edt4.getText().toString();
                        String mdate = edt5.getText().toString();

                        sqlHelper.updatefd(bid,scheme,amt,starts,ab,roi,mdate,sqLiteDatabase);
                        Toast.makeText(Modify.this, "Record Updated", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(Modify.this,fd.class);
                        startActivity(intent1);
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent1 = new Intent(Modify.this,fd.class);
                        startActivity(intent1);

                    }
                });
                builder.show();

            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Modify.this);
                builder.setTitle("Confirmation!");
                builder.setMessage("Surely want to delete?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sqlHelper.delete(bid,sqLiteDatabase);
                        Toast.makeText(Modify.this, "Record Deleted", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(Modify.this,fd.class);
                        startActivity(intent2);

                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent1 = new Intent(Modify.this,fd.class);
                        startActivity(intent1);
                    }
                });
                builder.show();

            }
        });
    }
}
