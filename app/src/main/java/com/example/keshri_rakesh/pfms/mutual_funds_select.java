package com.example.keshri_rakesh.pfms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mutual_funds_select extends AppCompatActivity {

    Button lum,sip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutual_funds_select);

        lum = (Button)findViewById(R.id.lumsum);
        sip = (Button)findViewById(R.id.SIP);

        lum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(mutual_funds_select.this,mutual_funds_lumsum_list.class);
                startActivity(intent1);
            }
        });

        sip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent1 = new Intent(mutual_funds_select.this,mutual_funds_sip_list.class);
                startActivity(intent1);
            }
        });


    }
}
