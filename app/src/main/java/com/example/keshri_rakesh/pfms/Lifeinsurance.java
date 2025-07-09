package com.example.keshri_rakesh.pfms;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Lifeinsurance extends AppCompatActivity implements View.OnClickListener{

    EditText polno,hold,polname,comnamee,stdatee,duedatee,periode,premiume,sumassurede;

    Button add_life;
    SQLHelper sqlHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifeinsurance);

        polno = (EditText)findViewById(R.id.POLN);
        hold = (EditText)findViewById(R.id.HOL);
        polname = (EditText)findViewById(R.id.POLNA);
        comnamee = (EditText)findViewById(R.id.COM);
        stdatee = (EditText)findViewById(R.id.DATE_S);
        duedatee = (EditText)findViewById(R.id.DATE_D);
        periode = (EditText)findViewById(R.id.PER);
        premiume = (EditText)findViewById(R.id.PRE);
        sumassurede = (EditText)findViewById(R.id.SUM);

        add_life = (Button)findViewById(R.id.btn_life);

        add_life.setOnClickListener(this);





    }

    @Override
    public void onClick(View view) {

        String a = polno.getText().toString();
        String b = hold.getText().toString();
        String c = polname.getText().toString();
        String d = comnamee.getText().toString();
        String e = stdatee.getText().toString();
        String f = duedatee.getText().toString();
        String g = periode.getText().toString();
        String h = premiume.getText().toString();
        String i = sumassurede.getText().toString();

        sqlHelper = new SQLHelper(this);

        sqLiteDatabase = sqlHelper.getWritableDatabase();

        sqlHelper.lifeinsurance(a,b,c,d,e,f,g,h,i,sqLiteDatabase);

        Toast.makeText(this, "Data Added", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Lifeinsurance.this,life_insurance_list.class);
        startActivity(intent);



    }
}
