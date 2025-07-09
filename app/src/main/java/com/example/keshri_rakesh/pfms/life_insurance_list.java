package com.example.keshri_rakesh.pfms;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class life_insurance_list extends AppCompatActivity {

    ListView listViewl;

    SQLiteDatabase se;
    SQLHelper sr;
    Cursor hr;

    ListAdapter_life lif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_insurance_list);

        listViewl = (ListView)findViewById(R.id.lv_life);

        lif = new ListAdapter_life(getApplicationContext(),R.layout.row_layout_lifeinsurance);
        listViewl.setAdapter(lif);

        sr = new SQLHelper(this);
        se = sr.getReadableDatabase();
        hr = sr.getdllife(se);

        if(hr.moveToFirst())
        {
            do {
                String q,w,e,r,t,y,u,i,o;

                q = hr.getString(0);
                w = hr.getString(1);
                e = hr.getString(2);
                r = hr.getString(3);
                t = hr.getString(4);
                y = hr.getString(5);
                u = hr.getString(6);
                i = hr.getString(7);
                o = hr.getString(8);

                Dataprovide_life dlf = new Dataprovide_life(q,w,e,r,t,y,u,i,o);

                lif.add(dlf);

            }while (hr.moveToNext());
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.add_record) {
            Intent i = new Intent(this,Lifeinsurance.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
