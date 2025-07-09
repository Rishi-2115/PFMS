package com.example.keshri_rakesh.pfms;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class electronic_modify extends AppCompatActivity {
    EditText T1,T2,T3,T4,T5;
    Button updd,dell;
    SQLHelper sh;
    SQLiteDatabase sdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronic_modify);

        T1 = (EditText)findViewById(R.id.Electronicet);
        T2 = (EditText)findViewById(R.id.sdet);
        T3 = (EditText)findViewById(R.id.ENDET);
        T4 = (EditText)findViewById(R.id.INTERESTAMET);
        T5 = (EditText)findViewById(R.id.DUEET);

        updd = (Button)findViewById(R.id.upd_elec);
        dell = (Button)findViewById(R.id.del_elec);

        //upd.setOnClickListener(this);
        //del.setOnClickListener(this);



        sh = new SQLHelper(getApplicationContext());
        sdatabase = sh.getWritableDatabase();

        Intent i = getIntent();

       final String polno = i.getStringExtra("policynum");
        String electype = i.getStringExtra("electronictype");
        String sdate = i.getStringExtra("startdate");
        String edate = i.getStringExtra("enddate");
        String iamt = i.getStringExtra("intamt");
        String ddate = i.getStringExtra("duedate");

        T1.setText(electype);
        T2.setText(sdate);
        T3.setText(edate);
        T4.setText(iamt);
        T5.setText(ddate);

        updd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(electronic_modify.this);
                builder.setTitle("Confirmation!");
                builder.setMessage("Surely want to update?");



                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        String t1 =T1.getText().toString();
                        String t2 = T2.getText().toString();
                        String t3 = T3.getText().toString();
                        String t4 = T4.getText().toString();
                        String t5 = T5.getText().toString();

                        sh.updateelectronic(polno,t1,t2,t3,t4,t5,sdatabase);
                        Toast.makeText(electronic_modify.this, "Data updated", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(electronic_modify.this,electronicinsurance_list.class);
                        startActivity(intent);

                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(electronic_modify.this,electronicinsurance_list.class);
                        startActivity(intent);
                    }
                });

                builder.show();
            }
        });



        dell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(electronic_modify.this);
                builder.setTitle("Confirmation!");
                builder.setMessage("Surely want to delete?");


                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                            sh.deleteelectronic(polno,sdatabase);

                        Toast.makeText(electronic_modify.this, "Data deleted", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(electronic_modify.this,electronicinsurance_list.class);
                        startActivity(intent);
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(electronic_modify.this,electronicinsurance_list.class);
                        startActivity(intent);
                    }
                });

                builder.show();
            }
        });



    }


}
