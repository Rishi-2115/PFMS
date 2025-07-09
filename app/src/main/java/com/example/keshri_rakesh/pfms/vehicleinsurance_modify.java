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

public class vehicleinsurance_modify extends AppCompatActivity {

    EditText A,B,C;
    Button upda,del;
    SQLHelper sqlHelper1;
    SQLiteDatabase db1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicleinsurance_modify);

        A = (EditText)findViewById(R.id.VEHICLENUM_ET);
        B = (EditText)findViewById(R.id.VEHICLETYPE_ET);
        C = (EditText)findViewById(R.id.IAMOUNT_ET);

        upda = (Button)findViewById(R.id.upd_vehicle);
        del = (Button)findViewById(R.id.del_vehicle);

        sqlHelper1 = new SQLHelper(this);
        db1 = sqlHelper1.getWritableDatabase();

        final Intent intent1 = getIntent();
        final String pnum = intent1.getStringExtra("pnum");
        String vehiclenum = intent1.getStringExtra("vehinum");
        String vehicletype = intent1.getStringExtra("vehitype");
        String amount = intent1.getStringExtra("amnt");


        A.setText(vehiclenum);
        B.setText(vehicletype);
        C.setText(amount);

        upda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(vehicleinsurance_modify.this);
                builder.setTitle("Confirmation");
                builder.setMessage("Surely want to update?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String a = A.getText().toString();
                        String b = B.getText().toString();
                        String c = C.getText().toString();

                        sqlHelper1.updatevehicle(pnum,a,b,c,db1);
                        Toast.makeText(vehicleinsurance_modify.this, "Data Updated", Toast.LENGTH_SHORT).show();
                        Intent intent11 = new Intent(vehicleinsurance_modify.this,Vehicleinsurance_list.class);
                        startActivity(intent11);
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent11 = new Intent(vehicleinsurance_modify.this,Vehicleinsurance_list.class);
                        startActivity(intent11);
                    }
                });

                builder.show();
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(vehicleinsurance_modify.this);
                builder.setTitle("Confirmation!");
                builder.setMessage("Surely want to delete?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sqlHelper1.deletevehicle(pnum,db1);
                        Toast.makeText(vehicleinsurance_modify.this, "data deleted", Toast.LENGTH_SHORT).show();

                        Intent intent11 = new Intent(vehicleinsurance_modify.this,Vehicleinsurance_list.class);
                        startActivity(intent11);

                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(vehicleinsurance_modify.this,Vehicleinsurance_list.class);
                        startActivity(intent);
                    }
                });

                builder.show();
            }
        });
    }
}
