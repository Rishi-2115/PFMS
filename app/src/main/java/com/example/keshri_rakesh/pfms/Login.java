package com.example.keshri_rakesh.pfms;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    TextInputEditText et1,et2;
    Button b1;
    TextView tv1;
    SQLHelper helper=null;
    SQLiteDatabase database=null;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et1=(TextInputEditText)findViewById(R.id.et1);
        et2=(TextInputEditText)findViewById(R.id.et2);
        b1=(Button)findViewById(R.id.b1);
        tv1=(TextView)findViewById(R.id.tv1);
        helper=new SQLHelper(this);
        database =helper.getReadableDatabase();

        final Intent i=new Intent(this,Registration.class);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(i);
            }
        });

        /*b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=et1.getText().toString();
                String pass=et2.getText().toString();

                Boolean check1 = helper.check(email,pass);
                if(check1==true)
                {
                    Intent intent = new Intent(getApplicationContext(),Dashboard.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Login.this, "Invalid email or password!", Toast.LENGTH_SHORT).show();
                    et1.setText("");
                    et2.setText("");
                }





            }
        });*/


    }

    public void log(View view) {
        String email=et1.getText().toString();
        String pass=et2.getText().toString();

        Boolean check1 = helper.check(email,pass);
        if(check1==true)
        {
            Intent intent = new Intent(getApplicationContext(),navdraw.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(Login.this, "Invalid email or password!", Toast.LENGTH_SHORT).show();
            et1.setText("");
            et2.setText("");
        }
        this.finish();
       // Intent i=new Intent(getApplicationContext(),Login.class);
        //startActivity(i);
    }
}