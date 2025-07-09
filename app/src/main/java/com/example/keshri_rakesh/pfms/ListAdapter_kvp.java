package com.example.keshri_rakesh.pfms;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter_kvp extends ArrayAdapter {

    ArrayList list15 = new ArrayList();
    public ListAdapter_kvp( Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler
    {
        TextView kvno,namek,amtk,mamtk,sdatek,edatek,postaddk;
    }

    @Override
    public void add( Object object) {
        super.add(object);
        list15.add(object);
    }

    @Override
    public int getCount() {
        return list15.size();
    }


    public Object getItem(int position) {
        return list15.get(position);
    }


    public View getView(int position,  View convertView,  ViewGroup parent) {
        View rows = convertView;
        LayoutHandler layoutHandler;

        if (rows==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            rows = layoutInflater.inflate(R.layout.row_layout_kvp,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.kvno = (TextView)rows.findViewById(R.id.KVPNOTV);
            layoutHandler.namek = (TextView)rows.findViewById(R.id.HOLDERNAMEKTV);
            layoutHandler.amtk = (TextView)rows.findViewById(R.id.AMOUNTKTV);
            layoutHandler.mamtk = (TextView)rows.findViewById(R.id.MATURITYKAMOUNTTV);
            layoutHandler.sdatek = (TextView)rows.findViewById(R.id.STARTDATEKTV);
            layoutHandler.edatek = (TextView)rows.findViewById(R.id.ENDDATEKTV);
            layoutHandler.postaddk = (TextView)rows.findViewById(R.id.POSTADDRESSKTV);

            rows.setTag(layoutHandler);

        }
        else {
            layoutHandler = (LayoutHandler)rows.getTag();
        }

        Dataprovider_kvp dataprovider_kvp = (Dataprovider_kvp)this.getItem(position);
        layoutHandler.kvno.setText(dataprovider_kvp.getKnum());
        layoutHandler.namek.setText(dataprovider_kvp.getHnamekvp());
        layoutHandler.amtk.setText(dataprovider_kvp.getAmt_kvp());
        layoutHandler.mamtk.setText(dataprovider_kvp.getMamt_kvp());
        layoutHandler.sdatek.setText(dataprovider_kvp.getStdatekvp());
        layoutHandler.edatek.setText(dataprovider_kvp.getEndatekvp());
        layoutHandler.postaddk.setText(dataprovider_kvp.getPostaddkvp());

        return rows;
    }
}
