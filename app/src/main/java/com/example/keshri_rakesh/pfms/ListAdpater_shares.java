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

public class ListAdpater_shares extends ArrayAdapter {

    ArrayList listsh = new ArrayList();
    public ListAdpater_shares( Context context, int resource) {
        super(context, resource);
    }

    static class layouth
    {
        TextView sid,cname,hname,pdate,noofshares,total,bankname;
    }

    @Override
    public void add( Object object) {
        super.add(object);
        listsh.add(object);
    }

    @Override
    public int getCount() {
        return listsh.size();
    }


    public Object getItem(int position) {
        return listsh.get(position);
    }


    public View getView(int position,  View convertView,  ViewGroup parent) {
        View row1 = convertView;
        layouth l;
        if(row1==null)
        {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row1 = inflater.inflate(R.layout.row_layout_shares,parent,false);
            l = new layouth();
            l.sid = (TextView)row1.findViewById(R.id.shareid_tv);
            l.cname = (TextView)row1.findViewById(R.id.com_tv);
            l.hname = (TextView)row1.findViewById(R.id.holdernamee_tv);
            l.pdate = (TextView)row1.findViewById(R.id.purchase_tv);
            l.noofshares = (TextView)row1.findViewById(R.id.noofshares_tv);
            l.total = (TextView)row1.findViewById(R.id.totalamt_tv);
            l.bankname = (TextView)row1.findViewById(R.id.BANKNAME_tv);

            row1.setTag(l);

        }
        else {
            l = (layouth)row1.getTag();
        }
        Dataprovider_shares dataprovider_shares = (Dataprovider_shares)this.getItem(position);
        l.sid.setText(dataprovider_shares.getSid());
        l.cname.setText(dataprovider_shares.getCompanyname());
        l.hname.setText(dataprovider_shares.getHoldname());
        l.pdate.setText(dataprovider_shares.getPurchasedate());
        l.noofshares.setText(dataprovider_shares.getNo_of_shares());
        l.total.setText(dataprovider_shares.getTotalamount());
        l.bankname.setText(dataprovider_shares.getB_name());

        return row1;
    }
}
