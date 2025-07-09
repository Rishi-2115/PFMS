package com.example.keshri_rakesh.pfms;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class fd extends AppCompatActivity {
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    SQLHelper sqlHelper;
    Cursor cursor;
    ListAdapter listAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fd);
        listView = (ListView)findViewById(R.id.listview);
        listAdapter = new ListAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(listAdapter);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.show();

        //getActionBar().show();

        //ActionBar actionBar = getActionBar();
        //actionBar.show();
        /*ActionBar actionBar = getActionBar();
        actionBar.show();*/
        sqlHelper = new SQLHelper(getApplicationContext());
        sqLiteDatabase = sqlHelper.getReadableDatabase();
        cursor = sqlHelper.getData(sqLiteDatabase);
        if(cursor.moveToFirst())
        {
            do
            {
                String id,bank,name,scheme,amount,starts,inttype,roi,mdate;
                id = cursor.getString(0);
                bank = cursor.getString(1);
                name = cursor.getString(2);
                scheme = cursor.getString(3);
                amount = cursor.getString(4);
                starts = cursor.getString(5);
                inttype = cursor.getString(6);
                roi = cursor.getString(7);
                mdate = cursor.getString(8);

                Dataprovider dataprovider = new Dataprovider(id,bank,name,scheme,amount,starts,inttype,roi,mdate);
                listAdapter.add(dataprovider);

            }while(cursor.moveToNext());
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView id = (TextView)view.findViewById(R.id.tv1);
                TextView sch = (TextView)view.findViewById(R.id.tv4);
                TextView amt = (TextView)view.findViewById(R.id.amount);
                TextView sta = (TextView)view.findViewById(R.id.tv5);
                TextView inty = (TextView)view.findViewById(R.id.tv6);
                TextView ro = (TextView)view.findViewById(R.id.tv7);
                TextView md = (TextView)view.findViewById(R.id.tv8);

                String bid = id.getText().toString();
                String scheme = sch.getText().toString();
                String amtt = amt.getText().toString();
                String starts = sta.getText().toString();
                String inttype = inty.getText().toString();
                String roi = ro.getText().toString();
                String mdate = md.getText().toString();


                Intent intent = new Intent(fd.this,Modify.class);
                intent.putExtra("bid",bid);
                intent.putExtra("scheme",scheme);
                intent.putExtra("amount",amtt);
                intent.putExtra("starts",starts);
                intent.putExtra("inttype",inttype);
                intent.putExtra("roi",roi);
                intent.putExtra("mdate",mdate);

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
            Intent i = new Intent(this, Insertion.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
