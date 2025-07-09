package com.example.keshri_rakesh.pfms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter {
    ArrayList list = new ArrayList();
    public ListAdapter(Context context, int resource) {

        super(context, resource);
    }
    static class LayoutHandler
    {
        TextView id,bank,name,scheme,starts,inttype,roi,mdate,amount;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);

    }

    @Override
    public int getCount() {

        return list.size();
    }


    @Override
    public Object getItem(int position) {
        return list.get(position);
    }


    @Override
    public View getView(int position,View convertView,ViewGroup parent) {

        View row = convertView;
        LayoutHandler layoutHandler;
        if(row==null)
        {
            LayoutInflater layoutInflater =  (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.id = (TextView)row.findViewById(R.id.tv1);
            layoutHandler.bank = (TextView)row.findViewById(R.id.tv2);
            layoutHandler.name = (TextView)row.findViewById(R.id.tv3);
            layoutHandler.scheme = (TextView)row.findViewById(R.id.tv4);
            layoutHandler.amount = (TextView)row.findViewById(R.id.amount);
            layoutHandler.starts = (TextView)row.findViewById(R.id.tv5);
            layoutHandler.inttype = (TextView)row.findViewById(R.id.tv6);
            layoutHandler.roi = (TextView)row.findViewById(R.id.tv7);
            layoutHandler.mdate = (TextView)row.findViewById(R.id.tv8);
            row.setTag(layoutHandler);
        }
        else {
            layoutHandler = (LayoutHandler)row.getTag();

        }
        Dataprovider dataprovider = (Dataprovider)this.getItem(position);
        layoutHandler.id.setText(dataprovider.getBankid());
        layoutHandler.bank.setText(dataprovider.getB_name());
        layoutHandler.name.setText(dataprovider.getH_name());
        layoutHandler.scheme.setText(dataprovider.getScheme());
        layoutHandler.amount.setText(dataprovider.getAmount());
        layoutHandler.starts.setText(dataprovider.getStarts());
        layoutHandler.inttype.setText(dataprovider.getIntttype());
        layoutHandler.roi.setText(dataprovider.getRoi());
        layoutHandler.mdate.setText(dataprovider.getMdate());
        return row;
    }
}
