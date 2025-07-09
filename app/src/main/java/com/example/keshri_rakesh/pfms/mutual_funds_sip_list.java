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

public class mutual_funds_sip_list extends AppCompatActivity {

    ListView listView;
    SQLiteDatabase sbase;
    SQLHelper hl;
    Cursor cc;
    ListAdapter_mutual_funds_sip listAdapter_mutual_funds_sip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutual_funds_sip_list);


        listView = (ListView)findViewById(R.id.lv_sip);

        listAdapter_mutual_funds_sip = new ListAdapter_mutual_funds_sip(getApplicationContext(),R.layout.row_layout_mutual_funds_sip);
        listView.setAdapter(listAdapter_mutual_funds_sip);

        hl = new SQLHelper(getApplicationContext());
        sbase = hl.getReadableDatabase();
        cc = hl.getDatasip(sbase);

        if(cc.moveToFirst())
        {
            do
            {
                String cname,folio,starts,todate,amt,frq,hold,bank,noofunits,address,planname,nav,ratee;

                cname = cc.getString(0);
                folio = cc.getString(1);
                starts = cc.getString(2);
                todate = cc.getString(3);
                amt = cc.getString(4);
                frq  = cc.getString(5);
                hold = cc.getString(6);
                bank = cc.getString(7);
                noofunits = cc.getString(8);
                address = cc.getString(9);
                planname = cc.getString(10);
                nav = cc.getString(11);
                ratee = cc.getString(12);


                Dataprovider_mutual_funds_sip dataprovider_mutual_funds_sip = new Dataprovider_mutual_funds_sip(cname,folio,starts,todate,amt,frq,hold,bank,noofunits,address,planname,nav,ratee);
                listAdapter_mutual_funds_sip.add(dataprovider_mutual_funds_sip);
            }while (cc.moveToNext());
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView cname = (TextView)view.findViewById(R.id.CNAME_tv);
                TextView folio = (TextView)view.findViewById(R.id.FOLIO_tv);

                TextView amt = (TextView)view.findViewById(R.id.AM_tv);
                TextView frq = (TextView)view.findViewById(R.id.FREQUENCY_tv);
                TextView hold = (TextView)view.findViewById(R.id.HOLDER_tv);
                TextView bank = (TextView)view.findViewById(R.id.BANKtv);
                TextView noofunits = (TextView)view.findViewById(R.id.noofunits_tv);
                TextView address = (TextView)view.findViewById(R.id.address_tv);
                TextView nav = (TextView)view.findViewById(R.id.NAV_tv);
                TextView rate = (TextView)view.findViewById(R.id.ratee_tv);

                String comname = cname.getText().toString();
                String folionum = folio.getText().toString();
                String amount = amt.getText().toString();
                String freq = frq.getText().toString();
                String holder = hold.getText().toString();
                String bankname = bank.getText().toString();
                String noofunit = noofunits.getText().toString();
                String add = address.getText().toString();
                String navv = nav.getText().toString();
                String ratee = rate.getText().toString();

                Intent intent1 = new Intent(mutual_funds_sip_list.this,mutual_funds_sip_modify.class);
                intent1.putExtra("comname",comname);
                intent1.putExtra("folionum",folionum);
                intent1.putExtra("amount",amount);
                intent1.putExtra("frequency",freq);
                intent1.putExtra("holder",holder);
                intent1.putExtra("bankname",bankname);
                intent1.putExtra("noofunit",noofunit);
                intent1.putExtra("add",add);
                intent1.putExtra("navv",navv);
                intent1.putExtra("ratee",ratee);
                startActivity(intent1);


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
            Intent i = new Intent(this, mutual_funds_sip_add.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
