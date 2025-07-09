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

public class share_list extends AppCompatActivity {

    ListView lv;
    SQLiteDatabase liteDatabase;
    SQLHelper shelper;
    Cursor cur;
    ListAdpater_shares listAdpater_shares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_list);

        lv = (ListView)findViewById(R.id.l_shares);
        listAdpater_shares = new ListAdpater_shares(getApplicationContext(),R.layout.row_layout_shares);
        lv.setAdapter(listAdpater_shares);

        shelper = new SQLHelper(getApplicationContext());
        liteDatabase = shelper.getReadableDatabase();
        cur = shelper.getDatashares(liteDatabase);

        if(cur.moveToFirst())
        {
            do{
                String sid,cname,hname,pdate,noofshares,total,bname;

                sid = cur.getString(0);
                cname = cur.getString(1);
                hname = cur.getString(2);
                pdate = cur.getString(3);
                noofshares = cur.getString(4);
                total = cur.getString(5);
                bname = cur.getString(6);

                Dataprovider_shares dataprovider_shares = new Dataprovider_shares(sid,cname,hname,pdate,noofshares,total,bname);

                listAdpater_shares.add(dataprovider_shares);
            }while (cur.moveToNext());
        }
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView shareid = (TextView)view.findViewById(R.id.shareid_tv);
                TextView companyname = (TextView)view.findViewById(R.id.com_tv);
                TextView holdername = (TextView)view.findViewById(R.id.holdernamee_tv);
                //TextView purchasedate = (TextView)view.findViewById(R.id.purchase_tv);
                TextView numberofshares = (TextView)view.findViewById(R.id.noofshares_tv);
                TextView totalamt = (TextView)view.findViewById(R.id.totalamt_tv);
                TextView bankname = (TextView)view.findViewById(R.id.BANKNAME_tv);


                String sid = shareid.getText().toString();
                String cname = companyname.getText().toString();
                String hname = holdername.getText().toString();
                //String pdate = purchasedate.getText().toString();
                String noofshares = numberofshares.getText().toString();
                String total = totalamt.getText().toString();
                String bname = bankname.getText().toString();

                Intent intent = new Intent(share_list.this,shares_modify.class);
                intent.putExtra("sid",sid);
                intent.putExtra("cname",cname);
                intent.putExtra("hname",hname);
                //intent.putExtra("pdate",pdate);
                intent.putExtra("noofshares",noofshares);
                intent.putExtra("totalamt",total);
                intent.putExtra("bname",bname);

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
            Intent i = new Intent(this, shares.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
