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

public class ListAdapter_td extends ArrayAdapter {

    ArrayList list11 = new ArrayList();
    public ListAdapter_td( Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler11
    {
        TextView nameholder,datestart,datedue,tdamt,roisss,maturityamtt;
    }

    @Override
    public void add( Object object) {
        super.add(object);
        list11.add(object);
    }

    @Override
    public int getCount() {
        return list11.size();
    }


    public Object getItem(int position) {
        return list11.get(position);
    }


    public View getView(int position,  View convertView,  ViewGroup parent) {
        View row12 = convertView;
        LayoutHandler11 layoutHandler11;

        if(row12==null)
        {
            LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            row12 = inflater.inflate(R.layout.row_layout_td,parent,false);
            layoutHandler11 = new LayoutHandler11();

            layoutHandler11.nameholder = (TextView)row12.findViewById(R.id.NAMEHOLDER_tv);
            layoutHandler11.datestart = (TextView)row12.findViewById(R.id.DATESTART_tv);
            layoutHandler11.datedue = (TextView)row12.findViewById(R.id.DATEDUE_tv);
            layoutHandler11.tdamt = (TextView)row12.findViewById(R.id.TDAMOUNT_tv);
            layoutHandler11.roisss = (TextView)row12.findViewById(R.id.RATEOFINTEREST_tv);
            layoutHandler11.maturityamtt = (TextView)row12.findViewById(R.id.MATURITYAMOUNT_tv);

            row12.setTag(layoutHandler11);
        }
        else {
            layoutHandler11 = (LayoutHandler11)row12.getTag();
        }

        Dataprovider_td dtd = (Dataprovider_td)this.getItem(position);

        layoutHandler11.nameholder.setText(dtd.getName_holder());
        layoutHandler11.datestart.setText(dtd.getDate_start());
        layoutHandler11.datedue.setText(dtd.getDate_due());
        layoutHandler11.tdamt.setText(dtd.getAmnt_t());
        layoutHandler11.roisss.setText(dtd.getRoiss());
        layoutHandler11.maturityamtt.setText(dtd.getMaturityamt());

        return row12;
    }
}

