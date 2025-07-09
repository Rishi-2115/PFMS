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

public class ListAdapter_rd extends ArrayAdapter {
    ArrayList list12 = new ArrayList();
    public ListAdapter_rd( Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler13
    {
        TextView accno,holder,raoi,monthlyamt,startdate,enddate,postadd;
    }

    @Override
    public void add( Object object) {
        super.add(object);
        list12.add(object);
    }

    @Override
    public int getCount() {
        return list12.size();
    }


    public Object getItem(int position) {
        return list12.get(position);
    }


    public View getView(int position,  View convertView, ViewGroup parent) {
       View row13 = convertView;

       LayoutHandler13 layoutHandler13;

       if (row13==null)
       {
           LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

           row13 = inflater.inflate(R.layout.row_layout_rd,parent,false);

           layoutHandler13 = new LayoutHandler13();


           layoutHandler13.accno = (TextView)row13.findViewById(R.id.AC_tv);
           layoutHandler13.holder = (TextView)row13.findViewById(R.id.H_tv);
           layoutHandler13.raoi = (TextView)row13.findViewById(R.id.RI_tv);
           layoutHandler13.monthlyamt = (TextView)row13.findViewById(R.id.MONTHLY_tv);
           layoutHandler13.startdate = (TextView)row13.findViewById(R.id.SE_tv);
           layoutHandler13.enddate = (TextView)row13.findViewById(R.id.EE_tv);
           layoutHandler13.postadd = (TextView)row13.findViewById(R.id.POSTADD_tv);

           row13.setTag(layoutHandler13);
       }

       else {
           layoutHandler13 = (LayoutHandler13)row13.getTag();
       }

       Dataprovider_rd drd = (Dataprovider_rd)this.getItem(position);

       layoutHandler13.accno.setText(drd.getAccno1());
       layoutHandler13.holder.setText(drd.getNameholder1());
       layoutHandler13.raoi.setText(drd.getRoi1());
       layoutHandler13.monthlyamt.setText(drd.getMonthlyamt1());
       layoutHandler13.startdate.setText(drd.getSdate1());
       layoutHandler13.enddate.setText(drd.getEdate1());
       layoutHandler13.postadd.setText(drd.getPostadd1());

       return row13;

    }
}
