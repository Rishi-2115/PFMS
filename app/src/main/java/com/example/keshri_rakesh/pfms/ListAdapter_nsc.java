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

public class ListAdapter_nsc extends ArrayAdapter {

    ArrayList list10 = new ArrayList();
    public ListAdapter_nsc( Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler
    {
        TextView nscno,hname,startdate,enddate,amnt,rroi,mamt,padd;
    }

    @Override
    public void add( Object object) {
        super.add(object);
        list10.add(object);
    }

    @Override
    public int getCount() {
        return list10.size();
    }


    public Object getItem(int position) {
        return list10.get(position);
    }


    public View getView(int position,  View convertView,  ViewGroup parent) {
        View row = convertView;
        LayoutHandler layoutHandler;

        if(row==null)
        {
            LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row_layout_nsc,parent,false);
            layoutHandler = new LayoutHandler();

            layoutHandler.nscno = (TextView)row.findViewById(R.id.nscnotv);
            layoutHandler.hname = (TextView)row.findViewById(R.id.h_name_tv);
                layoutHandler.startdate = (TextView)row.findViewById(R.id.startdatetv);
                layoutHandler.enddate = (TextView)row.findViewById(R.id.enddatetv);
                layoutHandler.amnt = (TextView)row.findViewById(R.id.amnttv);
                layoutHandler.rroi = (TextView)row.findViewById(R.id.rroitv);
                layoutHandler.mamt = (TextView)row.findViewById(R.id.maturityamount);
                layoutHandler.padd = (TextView)row.findViewById(R.id.p_addtv);

                row.setTag(layoutHandler);
        }
        else {
            layoutHandler = (LayoutHandler) row.getTag();
        }

        Dataprovider_nsc dpnsc = (Dataprovider_nsc)this.getItem(position);

        layoutHandler.nscno.setText(dpnsc.getNscno());
        layoutHandler.hname.setText(dpnsc.getHname());
        layoutHandler.startdate.setText(dpnsc.getStartdate());
        layoutHandler.enddate.setText(dpnsc.getEnddate());
        layoutHandler.amnt.setText(dpnsc.getAmnt());
        layoutHandler.rroi.setText(dpnsc.getRroi());
        layoutHandler.mamt.setText(dpnsc.getMamt());
        layoutHandler.padd.setText(dpnsc.getPadd());

        return row;


    }
}
