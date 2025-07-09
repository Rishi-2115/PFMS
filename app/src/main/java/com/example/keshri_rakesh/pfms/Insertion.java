package com.example.keshri_rakesh.pfms;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Insertion extends Activity implements View.OnClickListener {
    EditText et1,et2,et3,et4,et5,et6,et7,et8;
    Button btn1,btn2;
    Spinner sp;
    String ab;
    Context context = this;
    SQLHelper sqlHelper;
    SQLiteDatabase sqLiteDatabase;
    String[] c = {"INTEREST TYPE:","MONTHLY","QUATERLY","HALF YEARLY","YEARLY","ON MATURITY"};

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertion);
        et1 = (EditText)findViewById(R.id.e1);
        et2 = (EditText)findViewById(R.id.e2);
        et3 = (EditText)findViewById(R.id.e3);
        et4 = (EditText)findViewById(R.id.e4);
        et5 = (EditText)findViewById(R.id.e5);
        et6 = (EditText)findViewById(R.id.e6);
        sp = (Spinner)findViewById(R.id.sp1);
        et7 = (EditText)findViewById(R.id.e7);
        et8 = (EditText)findViewById(R.id.e8);
        btn1 = (Button)findViewById(R.id.btn1);


        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,c);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==1)
                {
                    ab="MONTHLY";
                }
                if(i==2)
                {
                    ab="QUARTERLY";
                }
                if(i==3)
                {
                    ab="HALF YEARLY";
                }
                if(i==4)
                {
                    ab="YEARLY";
                }
                if(i==5)
                {
                    ab="ON MATURITY";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //btn2 = (Button)findViewById(R.id.view);



       btn1.setOnClickListener(this);
    }

    @Override

    public void onClick(View view) {
        String bid = et1.getText().toString();
        String bank = et2.getText().toString();
        String name = et3.getText().toString();
        String scheme = et4.getText().toString();
        String amt = et5.getText().toString();
        String starts = et6.getText().toString();
        String roi = et7.getText().toString();
        String mdate = et8.getText().toString();

        sqlHelper = new SQLHelper(context);
        sqLiteDatabase = sqlHelper.getWritableDatabase();
        sqlHelper.fd(bid,bank,name,scheme,amt,starts,ab,roi,mdate,sqLiteDatabase);

        Toast.makeText(getBaseContext(), "Data added", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Insertion.this,fd.class);
        startActivity(intent);
        sqlHelper.close();

    }
}
