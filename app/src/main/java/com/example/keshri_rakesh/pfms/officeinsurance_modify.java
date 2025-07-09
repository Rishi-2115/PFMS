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

public class officeinsurance_modify extends AppCompatActivity {
    EditText u,v;
    Button dd1,dd2;

    SQLHelper er;
    SQLiteDatabase ase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_officeinsurance_modify);

        er = new SQLHelper(this);
        ase = er.getWritableDatabase();


        u = (EditText)findViewById(R.id.BRET);
        v = (EditText)findViewById(R.id.IAET);

        dd1 = (Button)findViewById(R.id.upd_office);
        dd2 = (Button)findViewById(R.id.del_office);

        final Intent intent = getIntent();
        final String pno = intent.getStringExtra("pnum");
        String br = intent.getStringExtra("branch");
        String am = intent.getStringExtra("amount");

        u.setText(br);
        v.setText(am);


        dd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(officeinsurance_modify.this);
                builder.setTitle("Confirmation!");
                builder.setMessage("Surely want to update?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String a = u.getText().toString();
                        String b = v.getText().toString();

                        er.updateofficeinsurance(pno,a,b,ase);
                        Toast.makeText(officeinsurance_modify.this, "data updated", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(officeinsurance_modify.this,officeinsurance_list.class);
                        startActivity(intent1);
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent1 = new Intent(officeinsurance_modify.this,officeinsurance_list.class);
                        startActivity(intent1);
                    }
                });

                builder.show();
            }
        });

        dd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(officeinsurance_modify.this);
                builder.setTitle("Confirmation!");
                builder.setMessage("Surely want to delete?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        er.deleteofficeinsurance(pno,ase);
                        Toast.makeText(officeinsurance_modify.this, "data deleted", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(officeinsurance_modify.this,officeinsurance_list.class);
                        startActivity(intent1);
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       Intent intent1 = new Intent(officeinsurance_modify.this,officeinsurance_list.class);
                       startActivity(intent1);
                    }
                });

                builder.show();
            }
        });


    }
}
