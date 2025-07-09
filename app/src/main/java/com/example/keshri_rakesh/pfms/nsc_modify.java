package com.example.keshri_rakesh.pfms;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class nsc_modify extends AppCompatActivity {

    EditText edt1,edt2,edt3,edt4,edt5;

    Button btt1,btt2;
    SQLHelper sqlHelper;
    SQLiteDatabase sqLiteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nsc_modify);

        sqlHelper = new SQLHelper(this);
        sqLiteDatabase = sqlHelper.getWritableDatabase();

        edt1 =   (EditText)findViewById(R.id.HNAME_ET);

        edt2 = (EditText)findViewById(R.id.AMO_ET);
        edt3 = (EditText) findViewById(R.id.RROIET);
        edt4 = (EditText)findViewById(R.id.MAMTET);
        edt5 = (EditText)findViewById(R.id.PADDET);

        btt1 = (Button)findViewById(R.id.upd_nsc);
        btt2 = (Button)findViewById(R.id.del_nsc);

        Intent intent = getIntent();
        final String nscno = intent.getStringExtra("nscno");
        String hname = intent.getStringExtra("hname");
        String amt = intent.getStringExtra("amnt");
        String rroi = intent.getStringExtra("rroi");
        String mamt = intent.getStringExtra("mamt");
        String padd = intent.getStringExtra("padd");

        edt1.setText(hname);
        edt2.setText(amt);
        edt3.setText(rroi);
        edt4.setText(mamt);
        edt5.setText(padd);

        btt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(nsc_modify.this);
                builder.setTitle("Confirmation!");
                builder.setMessage("Surely want to update?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String a = edt1.getText().toString();
                        String b = edt2.getText().toString();
                        String c = edt3.getText().toString();
                        //String inttype = edt3.getText().toString();
                        String d = edt4.getText().toString();
                        String e = edt5.getText().toString();

                        sqlHelper.updatensc(nscno,a,b,c,d,e,sqLiteDatabase);
                        Toast.makeText(nsc_modify.this, "Record Updated", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(nsc_modify.this,nsc_list.class);
                        startActivity(intent1);
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent1 = new Intent(nsc_modify.this,nsc_list.class);
                        startActivity(intent1);

                    }
                });

                builder.show();
            }
        });


        btt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(nsc_modify.this);
                builder.setTitle("Confirmation!");
                builder.setMessage("Surely want to delete?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sqlHelper.deletensc(nscno,sqLiteDatabase);
                        Toast.makeText(nsc_modify.this, "Record Deleted", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(nsc_modify.this,nsc_list.class);
                        startActivity(intent2);

                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent1 = new Intent(nsc_modify.this,nsc_list.class);
                        startActivity(intent1);
                    }
                });
                builder.show();
            }
        });



    }
}
