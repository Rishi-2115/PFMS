package com.example.keshri_rakesh.pfms;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity implements View.OnClickListener{

    TextInputEditText et1, et2, et3, et4;
    Button b1;
    TextView tv1;

    SQLHelper helper = null;
    SQLiteDatabase database = null;


    //@SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        et1 = (TextInputEditText) findViewById(R.id.et1);
        et2 = (TextInputEditText) findViewById(R.id.et2);
        et3 = (TextInputEditText) findViewById(R.id.et3);
        et4 = (TextInputEditText) findViewById(R.id.et4);
        b1 = (Button) findViewById(R.id.b1);
        tv1 = (TextView) findViewById(R.id.tv1);

        b1.setOnClickListener(this);

        helper = new SQLHelper(this);

        final Intent i = new Intent(this, Login.class);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i);
            }
        });
       /* b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = helper.getWritableDatabase();
                String s = et1.getText().toString();
                String s1 = et2.getText().toString();
                String s2 = et3.getText().toString();
                String s3 = et4.getText().toString();


                if(s.equals("")||s1.equals("")||s2.equals("")||s3.equals(""))
                {
                    Toast.makeText(Registration.this, "Please fill out all the fields", Toast.LENGTH_SHORT).show();
                }
                else if(s2.equals(s3))
                {
                    Boolean chekemail = helper.chkemail(s1);
                    if(chekemail==true)
                    {
                        Boolean insert = helper.insert(s,s1,s2);
                        if(insert==true)
                        {
                            Toast.makeText(Registration.this, "USER REGISTERED", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(),Login.class);
                            startActivity(i);

                        }
                        else
                        {
                            Toast.makeText(Registration.this, "UNSUCCESSFUL", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(Registration.this, "EMAIL ALREADY EXISTS", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(Registration.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                }


            }
        });*/
    }

    @Override
    public void onClick(View view) {

        database = helper.getWritableDatabase();
        String s = et1.getText().toString();
        String s1 = et2.getText().toString();
        String s2 = et3.getText().toString();
        String s3 = et4.getText().toString();


        if(s.equals("")||s1.equals("")||s2.equals("")||s3.equals(""))
        {
            Toast.makeText(Registration.this, "Please fill out all the fields", Toast.LENGTH_SHORT).show();
        }
        else if(s2.equals(s3))
        {
            Boolean chekemail = helper.chkemail(s1);
            if(chekemail==true)
            {
                Boolean insert = helper.insert(s,s1,s2);
                if(insert==true)
                {
                    Toast.makeText(Registration.this, "USER REGISTERED", Toast.LENGTH_SHORT).show();
                    this.finish();
                    Intent i = new Intent(getApplicationContext(),Login.class);
                    startActivity(i);

                }
                else
                {
                    Toast.makeText(Registration.this, "UNSUCCESSFUL", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(Registration.this, "EMAIL ALREADY EXISTS", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(Registration.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
        }

    }
}

   /* private void insertdata(String s, String s1, String s2) {
        ContentValues contentValues=new ContentValues();
        contentValues.put(SQLHelper.name,s);
        contentValues.put(SQLHelper.id,s1);
        contentValues.put(SQLHelper.pass,s2);
        long id=database.insert(SQLHelper.registration,null,contentValues);
    }
}*/