package com.example.keshri_rakesh.pfms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Insaurance extends AppCompatActivity {

    Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insaurance);

        b1=(Button)findViewById(R.id.b1);

        b2=(Button)findViewById(R.id.b2);

        b3=(Button)findViewById(R.id.b3);

        b4=(Button)findViewById(R.id.b4);
    }

    public void lifeinsuarance(View view)
    {
        Intent intent= new Intent(this,life_insurance_list.class);
        startActivity(intent);

    }

    public void vehicle(View view)
    {
        Intent intent= new Intent(this,Vehicleinsurance_list.class);
        startActivity(intent);
    }

    public void office(View view)
    {
        Intent intent=new Intent(this,officeinsurance_list.class);
        startActivity(intent);
    }
    public void electronic(View view)
    {
        Intent intent=new Intent(this,electronicinsurance_list.class);
        startActivity(intent);
    }

}
