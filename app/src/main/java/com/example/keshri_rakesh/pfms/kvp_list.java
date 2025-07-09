package com.example.keshri_rakesh.pfms;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class kvp_list extends AppCompatActivity {
    ListView listViewkvp;
    SQLiteDatabase sbe;
    SQLHelper shl;
    Cursor j;

    ListAdapter_kvp lkvp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kvp_list);

        listViewkvp = (ListView)findViewById(R.id.lv_kvp);

        lkvp = new ListAdapter_kvp(getApplicationContext(),R.layout.row_layout_kvp);
        listViewkvp.setAdapter(lkvp);

        shl = new SQLHelper(this);
        sbe = shl.getReadableDatabase();
        j = shl.getdkvp(sbe);

        if (j.moveToFirst())
        {
            do {
                String k1,h1,a1,m1,s1,e1,p1;

                k1 = j.getString(0);
                h1 = j.getString(1);
                a1 = j.getString(2);
                m1 = j.getString(3);
                s1 = j.getString(4);
                e1 = j.getString(5);
                p1 = j.getString(6);

                Dataprovider_kvp dkvp = new Dataprovider_kvp(k1,h1,a1,m1,s1,e1,p1);

                lkvp.add(dkvp);

            }while (j.moveToNext());
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.add_record) {
            Intent i = new Intent(this, KVP.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
