package com.example.keshri_rakesh.pfms;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Bank extends AppCompatActivity  {

    Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bank);

        b1=(Button)findViewById(R.id.b1);

       // b2=(Button)findViewById(R.id.b2);

        b3=(Button)findViewById(R.id.b3);

        //b4=(Button)findViewById(R.id.b4);

        /*b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Bank.this,transaction_list.class);
                startActivity(i);
            }
        });*/

        /*b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bank.this,bank_acc_list.class);
                startActivity(intent);
            }
        });*/
        /*b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/

    }
    public void createacc(View view)
    {

        Intent intent= new Intent(this,ListAccounts.class);
        startActivity(intent);
        //this.finish();

    }


    public void fd(View view) {
        Intent j=new Intent(Bank.this,fd.class);
        startActivity(j);

    }
}
