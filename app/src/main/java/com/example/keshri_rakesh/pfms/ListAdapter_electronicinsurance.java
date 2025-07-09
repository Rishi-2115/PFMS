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

public class ListAdapter_electronicinsurance extends ArrayAdapter {

    ArrayList list9 = new ArrayList();
    public ListAdapter_electronicinsurance( Context context, int resource) {
        super(context, resource);
    }
    static class LayoutHandler3
    {
        TextView po,etype,sde,ede,iat,dte;
    }

    @Override
    public void add( Object object) {
        super.add(object);
        list9.add(object);
    }

    @Override
    public int getCount() {
        return list9.size();
    }


    public Object getItem(int position) {
        return list9.get(position);
    }


    public View getView(int position,  View convertView,  ViewGroup parent) {
        View rows3 = convertView;
        LayoutHandler3 layoutHandler3;

        if(rows3==null)
        {
            LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rows3 = inflater.inflate(R.layout.row_layout_electronicinsurance,parent,false);
            layoutHandler3 = new LayoutHandler3();

            layoutHandler3.po = (TextView)rows3.findViewById(R.id.A1_tv);
            layoutHandler3.etype = (TextView)rows3.findViewById(R.id.B1_tv);
            layoutHandler3.sde = (TextView)rows3.findViewById(R.id.C1_tv);
            layoutHandler3.ede = (TextView)rows3.findViewById(R.id.D1_tv);
            layoutHandler3.iat = (TextView)rows3.findViewById(R.id.E1_tv);
            layoutHandler3.dte = (TextView)rows3.findViewById(R.id.F1_tv);

            rows3.setTag(layoutHandler3);
        }
        else {
            layoutHandler3 = (LayoutHandler3)rows3.getTag();
        }

        Dataprovider_electronicinsurance dei = (Dataprovider_electronicinsurance)this.getItem(position);

        layoutHandler3.po.setText(dei.getPn());
        layoutHandler3.etype.setText(dei.getElectype());
        layoutHandler3.sde.setText(dei.getSe());
        layoutHandler3.ede.setText(dei.getEe());
        layoutHandler3.iat.setText(dei.getIt());
        layoutHandler3.dte.setText(dei.getDe());

        return rows3;
    }
}
