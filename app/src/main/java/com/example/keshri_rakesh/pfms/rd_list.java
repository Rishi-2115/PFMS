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

public class rd_list extends AppCompatActivity {

    ListView lrd;
    SQLiteDatabase se;
    SQLHelper sr;
    Cursor x;

    ListAdapter_rd lrd1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rd_list);

        lrd = (ListView)findViewById(R.id.lv_rd);
        lrd1 = new ListAdapter_rd(getApplicationContext(),R.layout.row_layout_rd);
        lrd.setAdapter(lrd1);


        sr = new SQLHelper(this);
        se = sr.getReadableDatabase();
        x = sr.getdrd(se);

        if(x.moveToFirst())
        {
            do {


            String ano,hold,roisss,monthly,sd,ed,postadd;

                    ano = x.getString(0);
                    hold = x.getString(1);
                    roisss = x.getString(2);
                    monthly = x.getString(3);
                    sd = x.getString(4);
                    ed = x.getString(5);
                    postadd = x.getString(6);

                    Dataprovider_rd dr = new Dataprovider_rd(ano,hold,roisss,monthly,sd,ed,postadd);
                    lrd1.add(dr);
            }while (x.moveToNext());
        }

        lrd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView a = (TextView)view.findViewById(R.id.AC_tv);
                TextView b = (TextView)view.findViewById(R.id.H_tv);
                TextView c = (TextView)view.findViewById(R.id.RI_tv);
                TextView d = (TextView)view.findViewById(R.id.MONTHLY_tv);
                TextView e = (TextView)view.findViewById(R.id.SE_tv);
                TextView f = (TextView)view.findViewById(R.id.EE_tv);
                TextView g = (TextView)view.findViewById(R.id.POSTADD_tv);


                String ab1 = a.getText().toString();
                String ab2 = b.getText().toString();
                String ab3 = c.getText().toString();
                String ab4 = d.getText().toString();
                String ab5 = e.getText().toString();
                String ab6 = f.getText().toString();
                String ab7 = g.getText().toString();


                Intent intent = new Intent(rd_list.this,rd_modify.class);

                intent.putExtra("acno",ab1);
                intent.putExtra("holder",ab2);
                intent.putExtra("roi",ab3);
                intent.putExtra("monthly",ab4);
                intent.putExtra("sdate",ab5);
                intent.putExtra("edate",ab6);
                intent.putExtra("postadd",ab7);

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
            Intent i = new Intent(this,rd.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
