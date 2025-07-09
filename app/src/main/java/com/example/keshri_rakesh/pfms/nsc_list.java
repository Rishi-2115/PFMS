package com.example.keshri_rakesh.pfms;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class nsc_list extends AppCompatActivity {
    ListView lve;
    SQLiteDatabase se;
    SQLHelper sr;
    Cursor x;

    ListAdapter_nsc lnsc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nsc_list);

        lve = (ListView)findViewById(R.id.lv_nsc);

        lnsc = new ListAdapter_nsc(getApplicationContext(),R.layout.row_layout_nsc);
        lve.setAdapter(lnsc);

        sr = new SQLHelper(this);
        se = sr.getReadableDatabase();
        x = sr.getDnsc(se);

        if(x.moveToFirst())
        {
            do {
                String l,m,n,o,p,q,r,s;

                l = x.getString(0);
                m = x.getString(1);
                n = x.getString(2);
                o = x.getString(3);
                p = x.getString(4);
                q = x.getString(5);
                r = x.getString(6);
                s = x.getString(7);


                Dataprovider_nsc dns = new Dataprovider_nsc(l,m,n,o,p,q,r,s);

                lnsc.add(dns);
            }while (x.moveToNext());
        }

        lve.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView r = (TextView)view.findViewById(R.id.nscnotv);
                TextView s = (TextView)view.findViewById(R.id.h_name_tv);
                TextView t = (TextView)view.findViewById(R.id.amnttv);
                TextView u = (TextView)view.findViewById(R.id.rroitv);
                TextView v = (TextView)view.findViewById(R.id.maturityamount);
                TextView w = (TextView)view.findViewById(R.id.p_addtv);

                String x = r.getText().toString();
                String y = s.getText().toString();
                String z = t.getText().toString();
                String a = u.getText().toString();
                String b = v.getText().toString();
                String c = w.getText().toString();


                Intent intent = new Intent(nsc_list.this,nsc_modify.class);
                intent.putExtra("nscno",x);
                intent.putExtra("hname",y);
                intent.putExtra("amnt",z);
                intent.putExtra("rroi",a);
                intent.putExtra("mamt",b);
                intent.putExtra("padd",c);
                startActivity(intent);

            }
        });


    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.add_record) {
            Intent i = new Intent(this,nsc.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
