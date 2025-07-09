package com.example.keshri_rakesh.pfms;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class mutual_funds_sip_modify extends AppCompatActivity {

    EditText A1,A2,A3,A4,A5,A6,A7,A8;
    Spinner SP;
    Button updsip,delsip;

    String e[] = {"FREQUENCY:","MONTHLY","QUARTERLY","HALF YEARLY","YEARLY"};
    SQLHelper sqlHelper;
    SQLiteDatabase sqLiteDatabase;

String cd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutual_funds_sip_modify);
        sqlHelper = new SQLHelper(this);
        sqLiteDatabase = sqlHelper.getWritableDatabase();

        A1 = (EditText)findViewById(R.id.COM_ET);
        A2 = (EditText)findViewById(R.id.AMET);
        A3  = (EditText)findViewById(R.id.H_ET);
        A4 = (EditText)findViewById(R.id.B_ET);
        A5 = (EditText)findViewById(R.id.nouET);
        A6 = (EditText)findViewById(R.id.ADDET);
        A7 = (EditText)findViewById(R.id.NAVET);
        A8 = (EditText)findViewById(R.id.RATEET);

        SP = (Spinner)findViewById(R.id.F_sp);

        updsip = (Button)findViewById(R.id.upd_sip);
        delsip = (Button)findViewById(R.id.del_sip);

        Intent intent = getIntent();
         String comname = intent.getStringExtra("comname");
         final String folio = intent.getStringExtra("folionum");
        String amt = intent.getStringExtra("amount");
         String freq = intent.getStringExtra("frequency");
        String hold = intent.getStringExtra("holder");
        final String bname = intent.getStringExtra("bankname");
        String nou = intent.getStringExtra("noofunit");
        String add = intent.getStringExtra("add");
        String nav = intent.getStringExtra("navv");
        String rate = intent.getStringExtra("ratee");


        A1.setText(comname);
        A2.setText(amt);
        A3.setText(hold);
        A4.setText(bname);
        A5.setText(nou);
        A6.setText(add);
        A7.setText(nav);
        A8.setText(rate);


        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,e);
        SP.setAdapter(adapter);

        SP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==1)
                {
                    cd="MONTHLY";
                }
                if(i==2)
                {
                    cd="QUARTERLY";
                }
                if(i==3)
                {
                    cd="HALF YEARLY";
                }
                if(i==4)
                {
                    cd="YEARLY";
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        updsip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                builder.setTitle("Confirmation!");
                builder.setMessage("Surely want to update?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String comp = A1.getText().toString();
                        String amnt = A2.getText().toString();
                        String holder = A3.getText().toString();
                        String bname = A4.getText().toString();
                        String nou = A5.getText().toString();
                        String add = A6.getText().toString();
                        String nav = A7.getText().toString();
                        String rate = A8.getText().toString();

                        sqlHelper.updatesip(comp,folio,amnt,cd,holder,bname,nou,add,nav,rate,sqLiteDatabase);
                        Toast.makeText(mutual_funds_sip_modify.this, "Data updated", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(getApplicationContext(),mutual_funds_sip_list.class);
                        startActivity(intent1);

                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent1 = new Intent(getApplicationContext(),mutual_funds_sip_list.class);
                        startActivity(intent1);

                    }
                });

                builder.show();

            }
        });

        delsip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                builder.setTitle("Confirmation!");
                builder.setMessage("Surely want to delete?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       sqlHelper.deletesip(folio,sqLiteDatabase);
                        Toast.makeText(mutual_funds_sip_modify.this, "Data deleted", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(getApplicationContext(),mutual_funds_sip_list.class);
                        startActivity(intent1);
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent1 = new Intent(getApplicationContext(),mutual_funds_sip_list.class);
                        startActivity(intent1);

                    }
                });
                builder.show();

            }
        });


    }
}
