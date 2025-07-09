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

public class modify_td extends AppCompatActivity {

    EditText z1,z2,z3,z4,z5;
    Button upd_td,del_td;
    SQLHelper sh;
    SQLiteDatabase sdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_td);

        z1 = (EditText)findViewById(R.id.ST_ET);
        z2 = (EditText)findViewById(R.id.DD_ET);
        z3 = (EditText)findViewById(R.id.AT_ET);
        z4 = (EditText)findViewById(R.id.RT_ET);
        z5 = (EditText)findViewById(R.id.MA_ET);

        upd_td = (Button)findViewById(R.id.upd_td);
        del_td  = (Button)findViewById(R.id.del_td);



        sh = new SQLHelper(getApplicationContext());
        sdatabase = sh.getWritableDatabase();

        Intent intent = getIntent();

        final String a = intent.getStringExtra("name");
        String b = intent.getStringExtra("datestart");
        String c = intent.getStringExtra("datedue");
        String d = intent.getStringExtra("tdamount");
        String e = intent.getStringExtra("rateofinterest");
        String f = intent.getStringExtra("maturityamount");

        z1.setText(b);
        z2.setText(c);
        z3.setText(d);
        z4.setText(e);
        z5.setText(f);


        upd_td.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(modify_td.this);
                builder.setTitle("Confirmation!");
                builder.setMessage("Surely want to update?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String g = z1.getText().toString();
                        String b = z2.getText().toString();
                        String c = z3.getText().toString();
                        String d = z4.getText().toString();
                        String e = z5.getText().toString();


                        sh.updatedtd(a,g,b,c,d,e,sdatabase);
                        Toast.makeText(modify_td.this, "Data updated", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(modify_td.this,td_list.class);
                        startActivity(intent1);
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent1 = new Intent(modify_td.this,td_list.class);
                        startActivity(intent1);


                    }
                });
                builder.show();
            }
        });


        del_td.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(modify_td.this);
                builder.setTitle("Confirmation!");
                builder.setMessage("Surely want to delete?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sh.deletelumsum(a,sdatabase);
                        Toast.makeText(modify_td.this, "Data deleted", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(modify_td.this,td_list.class);
                        startActivity(intent1);

                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent1 = new Intent(modify_td.this,td_list.class);
                        startActivity(intent1);
                    }
                });

                builder.show();
            }
        });
    }
}
