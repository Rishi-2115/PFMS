package com.example.keshri_rakesh.pfms;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class mutual_funds_lumsum_add extends AppCompatActivity {

    EditText companyname,folionumber,AMOUNT;
    Button lumsumadd;
    SQLHelper sqlHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutual_funds_lumsum_add);

        companyname = (EditText)findViewById(R.id.COMPANYNAMEET);
        folionumber = (EditText)findViewById(R.id.FOLIONOET);
        AMOUNT = (EditText)findViewById(R.id.AMOUNTET);

        lumsumadd = (Button)findViewById(R.id.ADD);

        lumsumadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = companyname.getText().toString();
                String b = folionumber.getText().toString();
                String c = AMOUNT.getText().toString();

                sqlHelper = new SQLHelper(getApplicationContext());
                sqLiteDatabase = sqlHelper.getWritableDatabase();

                sqlHelper.lumsum_add(a,b,c,sqLiteDatabase);

                Toast.makeText(mutual_funds_lumsum_add.this, "Data Added", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(mutual_funds_lumsum_add.this,mutual_funds_lumsum_list.class);
                startActivity(i);


            }
        });


    }
}
