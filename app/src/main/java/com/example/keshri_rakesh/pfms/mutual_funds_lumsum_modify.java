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

public class mutual_funds_lumsum_modify extends AppCompatActivity {
    EditText lumsum_1,lumsum_2;
    Button upd_lumsum,del_lumsum;
    SQLHelper sh;
    SQLiteDatabase sdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutual_funds_lumsum_modify);

        lumsum_1 = (EditText)findViewById(R.id.COM_NAME_ET);
        lumsum_2 = (EditText)findViewById(R.id.AMTET);
        upd_lumsum = (Button)findViewById(R.id.upd_lumsum);
        del_lumsum = (Button)findViewById(R.id.del_lumsum);


        sh = new SQLHelper(getApplicationContext());
        sdatabase = sh.getWritableDatabase();


        Intent i = getIntent();

        String comname = i.getStringExtra("comname");
        final String folionum = i.getStringExtra("folionum");
        String amt = i.getStringExtra("amt");

        lumsum_1.setText(comname);
        lumsum_2.setText(amt);

        upd_lumsum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mutual_funds_lumsum_modify.this);
                builder.setTitle("Confirmation!");
                builder.setMessage("Surely want to update?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String cname = lumsum_1.getText().toString();
                        String amt = lumsum_2.getText().toString();

                        sh.updatelumsum(cname,folionum,amt,sdatabase);
                        Toast.makeText(mutual_funds_lumsum_modify.this, "Data updated", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(mutual_funds_lumsum_modify.this,mutual_funds_lumsum_list.class);
                        startActivity(intent1);
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent1 = new Intent(mutual_funds_lumsum_modify.this,mutual_funds_lumsum_list.class);
                        startActivity(intent1);


                    }
                });
                builder.show();
            }
        });

        del_lumsum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mutual_funds_lumsum_modify.this);
                builder.setTitle("Confirmation!");
                builder.setMessage("Surely want to delete?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sh.deletelumsum(folionum,sdatabase);
                        Toast.makeText(mutual_funds_lumsum_modify.this, "Data deleted", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(mutual_funds_lumsum_modify.this,mutual_funds_lumsum_list.class);
                        startActivity(intent1);

                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent1 = new Intent(mutual_funds_lumsum_modify.this,mutual_funds_lumsum_list.class);
                        startActivity(intent1);
                    }
                });

                builder.show();
            }
        });
    }
}
