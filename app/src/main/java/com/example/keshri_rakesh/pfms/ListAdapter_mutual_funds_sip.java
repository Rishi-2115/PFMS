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

public class ListAdapter_mutual_funds_sip extends ArrayAdapter {

    ArrayList list5 = new ArrayList();
    public ListAdapter_mutual_funds_sip( Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler
    {
        TextView comname,folionum,startdate,todate,amnt,frequency,holder,banknamee,noofunits,address,planname,nav,ratee;
    }

    @Override
    public void add( Object object) {
        list5.add(object);
    }

    @Override
    public int getCount() {
        return list5.size();
    }


    public Object getItem(int position) {
        return list5.get(position);
    }


    public View getView(int position,  View convertView,  ViewGroup parent) {
        View row = convertView;
        LayoutHandler layoutHandler;

        if(row==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout_mutual_funds_sip,parent,false);

            layoutHandler = new LayoutHandler();
            layoutHandler.comname = (TextView)row.findViewById(R.id.CNAME_tv);
            layoutHandler.folionum = (TextView)row.findViewById(R.id.FOLIO_tv);
            layoutHandler.startdate = (TextView)row.findViewById(R.id.starts_tv);
            layoutHandler.todate = (TextView)row.findViewById(R.id.TODATE_tv);
            layoutHandler.amnt = (TextView)row.findViewById(R.id.AM_tv);
            layoutHandler.frequency = (TextView)row.findViewById(R.id.FREQUENCY_tv);
            layoutHandler.holder = (TextView)row.findViewById(R.id.HOLDER_tv);
            layoutHandler.banknamee = (TextView)row.findViewById(R.id.BANKtv);
            layoutHandler.noofunits = (TextView)row.findViewById(R.id.noofunits_tv);
            layoutHandler.address = (TextView)row.findViewById(R.id.address_tv);
            layoutHandler.planname = (TextView)row.findViewById(R.id.planname_tv);
            layoutHandler.nav = (TextView)row.findViewById(R.id.NAV_tv);
            layoutHandler.ratee = (TextView)row.findViewById(R.id.ratee_tv);

            row.setTag(layoutHandler);

        }
        else {
            layoutHandler = (LayoutHandler)row.getTag();

        }

        Dataprovider_mutual_funds_sip dataprovider_mutual_funds_sip = (Dataprovider_mutual_funds_sip)this.getItem(position);

        layoutHandler.comname.setText(dataprovider_mutual_funds_sip.getComnane());
        layoutHandler.folionum.setText(dataprovider_mutual_funds_sip.getFolionum());
        layoutHandler.startdate.setText(dataprovider_mutual_funds_sip.getSdate());
        layoutHandler.todate.setText(dataprovider_mutual_funds_sip.getTodate());
        layoutHandler.amnt.setText(dataprovider_mutual_funds_sip.getAmt());
        layoutHandler.frequency.setText(dataprovider_mutual_funds_sip.getFreq());
        layoutHandler.holder.setText(dataprovider_mutual_funds_sip.getHold());
        layoutHandler.banknamee.setText(dataprovider_mutual_funds_sip.getBname());
        layoutHandler.noofunits.setText(dataprovider_mutual_funds_sip.getNoofunits());
        layoutHandler.address.setText(dataprovider_mutual_funds_sip.getAdd());
        layoutHandler.planname.setText(dataprovider_mutual_funds_sip.getPlan());
        layoutHandler.nav.setText(dataprovider_mutual_funds_sip.getNav());
        layoutHandler.ratee.setText(dataprovider_mutual_funds_sip.getRate());

        return row;
    }
}
