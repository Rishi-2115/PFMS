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

import org.w3c.dom.Text;

public class td_list extends AppCompatActivity {
    ListView lv_td;
    SQLiteDatabase liteDatabase;
    SQLHelper shelper;
    Cursor cur;

    ListAdapter_td ltd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td_list);


        lv_td = (ListView)findViewById(R.id.lv_td);

        ltd = new ListAdapter_td(getApplicationContext(),R.layout.row_layout_td);
        lv_td.setAdapter(ltd);


        shelper = new SQLHelper(getApplicationContext());
        liteDatabase = shelper.getReadableDatabase();
        cur = shelper.getdtd(liteDatabase);


        if(cur.moveToFirst())
        {
            do {
                String a,b,c,d,e,f;

                a = cur.getString(0);
                b = cur.getString(1);
                c = cur.getString(2);
                d = cur.getString(3);
                e = cur.getString(4);
                f = cur.getString(5);

                Dataprovider_td dt = new Dataprovider_td(a,b,c,d,e,f);
                ltd.add(dt);
            }while (cur.moveToNext());
        }

        lv_td.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView a = (TextView)view.findViewById(R.id.NAMEHOLDER_tv);
                TextView b = (TextView)view.findViewById(R.id.DATESTART_tv);
                TextView c = (TextView)view.findViewById(R.id.DATEDUE_tv);
                TextView d = (TextView)view.findViewById(R.id.TDAMOUNT_tv);
                TextView e = (TextView)view.findViewById(R.id.RATEOFINTEREST_tv);
                TextView f = (TextView)view.findViewById(R.id.MATURITYAMOUNT_tv);

                String g = a.getText().toString();
                String h = b.getText().toString();
                String j = c.getText().toString();
                String k = d.getText().toString();
                String m = e.getText().toString();
                String n = f.getText().toString();

                Intent intent = new Intent(td_list.this,modify_td.class);

                intent.putExtra("name",g);
                intent.putExtra("datestart",h);
                intent.putExtra("datedue",j);
                intent.putExtra("tdamount",k);
                intent.putExtra("rateofinterest",m);
                intent.putExtra("maturityamount",n);

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
            Intent i = new Intent(this, td.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
