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

public class ListAdapter_mutual_funds_lumsum extends ArrayAdapter {

    ArrayList list3 = new ArrayList();
    public ListAdapter_mutual_funds_lumsum( Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler
    {
        TextView companyname,foliono,amt;
    }

    @Override
    public void add( Object object) {
        super.add(object);
        list3.add(object);
    }

    @Override
    public int getCount() {
        return list3.size();
    }


    @Override
    public Object getItem(int position) {
        return list3.get(position);
    }



    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View row = convertView;
        LayoutHandler layoutHandler;
        if(row==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout_mutual_funds_lumsum,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.companyname = (TextView)row.findViewById(R.id.COMPANYNAMETV);
            layoutHandler.foliono = (TextView)row.findViewById(R.id.FOLIONOTV);
            layoutHandler.amt = (TextView)row.findViewById(R.id.AMOUNTTV);

            row.setTag(layoutHandler);
        }
        else {
            layoutHandler = (LayoutHandler)row.getTag();
        }
        Dataprovider_mutual_funds_lumsum dataprovider_mutual_funds_lumsum = (Dataprovider_mutual_funds_lumsum) this.getItem(position);
        layoutHandler.companyname.setText(dataprovider_mutual_funds_lumsum.getCompanyname());
        layoutHandler.foliono.setText(dataprovider_mutual_funds_lumsum.getFoliono());
        layoutHandler.amt.setText(dataprovider_mutual_funds_lumsum.getAmount());
        return row;
    }
}
