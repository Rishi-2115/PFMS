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
import android.widget.Toast;

public class rd_modify extends AppCompatActivity {

    EditText aa1,aa2,aa3,aa4,aa5,aa6;

    Button upd_rd,del_rd;

    SQLHelper sqlHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rd_modify);

        aa1 = (EditText)findViewById(R.id.nameeet);
        aa2 = (EditText)findViewById(R.id.ROIIET);
        aa3 = (EditText)findViewById(R.id.MONTHLYAMOUNTET);
        aa4 = (EditText)findViewById(R.id.STDATEET);
        aa5 = (EditText)findViewById(R.id.ENDDATEET);
        aa6 = (EditText)findViewById(R.id.POSTADDET);

        upd_rd = (Button)findViewById(R.id.upd_rd);
        del_rd = (Button)findViewById(R.id.del_rd);

        sqlHelper = new SQLHelper(this);
        sqLiteDatabase = sqlHelper.getWritableDatabase();

        Intent intent = getIntent();
        final String acno = intent.getStringExtra("acno");
        String hold = intent.getStringExtra("holder");
        String roi = intent.getStringExtra("roi");
        String monthly = intent.getStringExtra("monthly");
        String sdate = intent.getStringExtra("sdate");
        String edate = intent.getStringExtra("edate");
        String postadd = intent.getStringExtra("postadd");

        aa1.setText(hold);
        aa2.setText(roi);
        aa3.setText(monthly);
        aa4.setText(sdate);
        aa5.setText(edate);
        aa6.setText(postadd);


        upd_rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(rd_modify.this);
                builder.setTitle("Confirmation!");
                builder.setMessage("Surely want to update?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String a = aa1.getText().toString();
                        String b = aa2.getText().toString();
                        String c = aa3.getText().toString();
                        String d = aa4.getText().toString();
                        String e = aa5.getText().toString();
                        String f = aa6.getText().toString();

                        sqlHelper.updaterd(acno,a,b,c,d,e,f,sqLiteDatabase);
                        Toast.makeText(rd_modify.this, "Record Updated", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(rd_modify.this,rd_list.class);
                        startActivity(intent1);
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent1 = new Intent(rd_modify.this,rd_list.class);
                        startActivity(intent1);

                    }
                });
                builder.show();

            }
        });


        del_rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(rd_modify.this);
                builder.setTitle("Confirmation!");
                builder.setMessage("Surely want to delete?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sqlHelper.deleterd(acno,sqLiteDatabase);
                        Toast.makeText(rd_modify.this, "Record Deleted", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(rd_modify.this,rd_list.class);
                        startActivity(intent2);

                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent1 = new Intent(rd_modify.this,rd_list.class);
                        startActivity(intent1);
                    }
                });
                builder.show();

            }
        });




    }
}
