package com.example.keshri_rakesh.pfms;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListAdapter_life extends ArrayAdapter {

    ArrayList list20 = new ArrayList();

    public ListAdapter_life( Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler
    {
        TextView polno,holder,poliname,comyname,stardate,dueedate,periodd,premm,summ;
    }

    @Override
    public void add( Object object) {
        super.add(object);
        list20.add(object);
    }

    @Override
    public int getCount() {
        return list20.size();
    }


    public Object getItem(int position) {
        return list20.get(position);
    }


    public View getView(int position,  View convertView,  ViewGroup parent) {

       View rows = convertView;
       LayoutHandler layoutHandler;

       if(rows==null)
       {
           LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           rows = inflater.inflate(R.layout.row_layout_lifeinsurance,parent,false);

           layoutHandler = new LayoutHandler();

           layoutHandler.polno = (TextView)rows.findViewById(R.id.policynol_tv);
           layoutHandler.holder = (TextView)rows.findViewById(R.id.Holderl_tv);
           layoutHandler.poliname = (TextView)rows.findViewById(R.id.policynamel_tv);
           layoutHandler.comyname = (TextView)rows.findViewById(R.id.COMNAMEl_tv);
           layoutHandler.stardate = (TextView)rows.findViewById(R.id.SDATEl_tv);
           layoutHandler.dueedate = (TextView)rows.findViewById(R.id.DUEDATEl_tv);
           layoutHandler.periodd = (TextView)rows.findViewById(R.id.PERIOIDl_tv);
           layoutHandler.premm = (TextView)rows.findViewById(R.id.PREMIUMAMOUNTl_tv);
           layoutHandler.summ = (TextView)rows.findViewById(R.id.SUMASSUREDl_tv);

           rows.setTag(layoutHandler);

       }

       else {
           layoutHandler = (LayoutHandler)rows.getTag();
       }

       Dataprovide_life dataprovide_life = (Dataprovide_life)this.getItem(position);

       layoutHandler.polno.setText(dataprovide_life.getPlnol());
       layoutHandler.holder.setText(dataprovide_life.getHoldl());
       layoutHandler.poliname.setText(dataprovide_life.getPolnamel());
       layoutHandler.comyname.setText(dataprovide_life.getComnamel());
       layoutHandler.stardate.setText(dataprovide_life.getStadatel());
       layoutHandler.dueedate.setText(dataprovide_life.getDuedatel());
       layoutHandler.periodd.setText(dataprovide_life.getPeriodl());
       layoutHandler.premm.setText(dataprovide_life.getPreml());
       layoutHandler.summ.setText(dataprovide_life.getSuml());

       return rows;


    }
}
