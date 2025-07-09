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

public class electronicinsurance_list extends AppCompatActivity {

    ListView lve;
    SQLiteDatabase se;
    SQLHelper sr;
    Cursor x;
    ListAdapter_electronicinsurance lei;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronicinsurance_list);

        lve = (ListView)findViewById(R.id.lv_elec);

        lei = new ListAdapter_electronicinsurance(getApplicationContext(),R.layout.row_layout_electronicinsurance);
        lve.setAdapter(lei);

        sr = new SQLHelper(this);
        se = sr.getReadableDatabase();
        x = sr.getDelectronicinsurance(se);

        if(x.moveToFirst())
        {
            do {
                String l,m,n,o,p,q;

                l = x.getString(0);
                m = x.getString(1);
                n = x.getString(2);
                o = x.getString(3);
                p = x.getString(4);
                q = x.getString(5);

                Dataprovider_electronicinsurance dei = new Dataprovider_electronicinsurance(l,m,n,o,p,q);

                lei.add(dei);
            }while (x.moveToNext());
        }

        lve.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView a = (TextView)view.findViewById(R.id.A1_tv);
                TextView b = (TextView)view.findViewById(R.id.B1_tv);
                TextView c = (TextView)view.findViewById(R.id.C1_tv);
                TextView d = (TextView)view.findViewById(R.id.D1_tv);
                TextView e = (TextView)view.findViewById(R.id.E1_tv);
                TextView f = (TextView)view.findViewById(R.id.F1_tv);

                String pno = a.getText().toString();
                String electype = b.getText().toString();
                String sdate = c.getText().toString();
                String edate = d.getText().toString();
                String iamt = e.getText().toString();
                String ddate = f.getText().toString();

                Intent intent = new Intent(electronicinsurance_list.this,electronic_modify.class);
                intent.putExtra("policynum",pno);
                intent.putExtra("electronictype",electype);
                intent.putExtra("startdate",sdate);
                intent.putExtra("enddate",edate);
                intent.putExtra("intamt",iamt);
                intent.putExtra("duedate",ddate);

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
            Intent i = new Intent(this,electronicinsurance.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }


}
