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

public class Vehicleinsurance_list extends AppCompatActivity {

    ListView lview;
    SQLiteDatabase dbs;
    SQLHelper h;
    Cursor z;
    ListAdapter_vehicleinsurance lvi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicleinsurance_list);

        lview = (ListView)findViewById(R.id.lv_vehicle);
        lvi = new ListAdapter_vehicleinsurance(getApplicationContext(),R.layout.row_layout_vehicleinsurance);
        lview.setAdapter(lvi);

        h = new SQLHelper(this);
        dbs = h.getReadableDatabase();
        z = h.getDvehicleinsurance(dbs);

        if (z.moveToFirst()) {
            do {
                String pono, vehino, vehitype, sdat, edate, Iamt, Ddate;

                pono = z.getString(0);
                vehino = z.getString(1);
                vehitype = z.getString(2);
                sdat = z.getString(3);
                edate = z.getString(4);
                Iamt = z.getString(5);
                Ddate = z.getString(6);

                Dataprovider_vehicleinsurance dvi = new Dataprovider_vehicleinsurance(pono, vehino, vehitype, sdat, edate, Iamt, Ddate);
                lvi.add(dvi);
            } while (z.moveToNext());
        }
        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView pno = (TextView)view.findViewById(R.id.po_tv);
                TextView vehin = (TextView)view.findViewById(R.id.vehiclenum_tv);
                TextView vehit = (TextView)view.findViewById(R.id.vehicletype_tv);
                TextView amt = (TextView)view.findViewById(R.id.Iamount_tv);

                String pnum = pno.getText().toString();
                String vehinum = vehin.getText().toString();
                String vehitype = vehit.getText().toString();
                String amnt = amt.getText().toString();

                Intent intent1 = new Intent(Vehicleinsurance_list.this,vehicleinsurance_modify.class);
                intent1.putExtra("pnum",pnum);
                intent1.putExtra("vehinum",vehinum);
                intent1.putExtra("vehitype",vehitype);
                intent1.putExtra("amnt",amnt);
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
            Intent i = new Intent(this, Vehicle.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
