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

public class mutual_funds_lumsum_list extends AppCompatActivity {

    ListView lvlumsum;
    SQLiteDatabase liteDatabase;
    SQLHelper shelper;
    Cursor cur;
    ListAdapter_mutual_funds_lumsum listAdapter_mutual_funds_lumsum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutual_funds_lumsum_list);

        lvlumsum = (ListView)findViewById(R.id.lv_lumsum);

        listAdapter_mutual_funds_lumsum = new ListAdapter_mutual_funds_lumsum(getApplicationContext(),R.layout.row_layout_mutual_funds_lumsum);
        lvlumsum.setAdapter(listAdapter_mutual_funds_lumsum);

        shelper = new SQLHelper(getApplicationContext());
        liteDatabase = shelper.getReadableDatabase();
        cur = shelper.getDatalumsum(liteDatabase);

        if(cur.moveToFirst())
        {
            do {
                String cname,foliono,amt;

                cname = cur.getString(0);
                foliono = cur.getString(1);
                amt = cur.getString(2);

                Dataprovider_mutual_funds_lumsum dataprovider_mutual_funds_lumsum = new Dataprovider_mutual_funds_lumsum(cname,foliono,amt);
                listAdapter_mutual_funds_lumsum.add(dataprovider_mutual_funds_lumsum);
            }while (cur.moveToNext());
        }

        lvlumsum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView cname = (TextView)view.findViewById(R.id.COMPANYNAMETV);
                TextView foliono = (TextView)view.findViewById(R.id.FOLIONOTV);
                TextView amr = (TextView)view.findViewById(R.id.AMOUNTTV);


                String comname = cname.getText().toString();
                String folionum = foliono.getText().toString();
                String amt = amr.getText().toString();


                Intent in = new Intent(mutual_funds_lumsum_list.this,mutual_funds_lumsum_modify.class);
                in.putExtra("comname",comname);
                in.putExtra("folionum",folionum);
                in.putExtra("amt",amt);
                startActivity(in);
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
            Intent i = new Intent(this, mutual_funds_lumsum_add.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
