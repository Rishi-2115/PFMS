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

public class officeinsurance_list extends AppCompatActivity {

    ListView ls;
    SQLiteDatabase lbase;
    SQLHelper H;
    Cursor y;

    ListAdapter_officeinsurance lof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_officeinsurance_list);

        ls = (ListView)findViewById(R.id.lv_office);

        lof = new ListAdapter_officeinsurance(getApplicationContext(),R.layout.row_layout_officeinsurance);
        ls.setAdapter(lof);


        H = new SQLHelper(this);
        lbase = H.getReadableDatabase();
        y = H.getDofficeinsurance(lbase);

        if(y.moveToFirst())
        {
            do {
                String m,n,o,p,q;

                m = y.getString(0);
                n = y.getString(1);
                o = y.getString(2);
                p = y.getString(3);
                q = y.getString(4);

                Dataprovider_officeinsurance doff = new Dataprovider_officeinsurance(m,n,o,p,q);
                lof.add(doff);
            }while (y.moveToNext());
        }

        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView r = (TextView)view.findViewById(R.id.p1_tv);
                TextView s = (TextView)view.findViewById(R.id.br_tv);
                TextView t = (TextView)view.findViewById(R.id.Im_tv);

                String pnum = r.getText().toString();
                String branch = s.getText().toString();
                String amount = t.getText().toString();

                Intent intent = new Intent(officeinsurance_list.this,officeinsurance_modify.class);
                intent.putExtra("pnum",pnum);
                intent.putExtra("branch",branch);
                intent.putExtra("amount",amount);
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
            Intent i = new Intent(this, OfficeInsurance.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

}
