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

public class ListAdapter_vehicleinsurance extends ArrayAdapter {
    ArrayList list7 = new ArrayList();
    public ListAdapter_vehicleinsurance( Context context, int resource) {
        super(context, resource);
    }
    static class LayoutHandler1
    {
        TextView po,vehinno,vehitype,sd,ed,Ia,Dd;
    }

    @Override
    public void add( Object object) {
        super.add(object);
        list7.add(object);
    }

    @Override
    public int getCount() {
        return list7.size();
    }


    public Object getItem(int position) {
        return list7.get(position);
    }


    public View getView(int position,  View convertView,  ViewGroup parent) {
        View rows = convertView;
        LayoutHandler1 layoutHandler1;

        if(rows==null)
        {
            LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rows = inflater.inflate(R.layout.row_layout_vehicleinsurance,parent,false);

            layoutHandler1 = new LayoutHandler1();

            layoutHandler1.po = (TextView)rows.findViewById(R.id.po_tv);
            layoutHandler1.vehinno = (TextView)rows.findViewById(R.id.vehiclenum_tv);
            layoutHandler1.vehitype = (TextView)rows.findViewById(R.id.vehicletype_tv);
            layoutHandler1.sd = (TextView)rows.findViewById(R.id.SD_tv);
            layoutHandler1.ed = (TextView)rows.findViewById(R.id.EDATE_tv);
            layoutHandler1.Ia = (TextView)rows.findViewById(R.id.Iamount_tv);
            layoutHandler1.Dd = (TextView)rows.findViewById(R.id.Ddate_tv);

            rows.setTag(layoutHandler1);
        }
        else {
            layoutHandler1 = (LayoutHandler1)rows.getTag();

        }

        Dataprovider_vehicleinsurance dataprovider_vehicleinsurance = (Dataprovider_vehicleinsurance)this.getItem(position);

        layoutHandler1.po.setText(dataprovider_vehicleinsurance.getPolnum());
        layoutHandler1.vehinno.setText(dataprovider_vehicleinsurance.getVehiclenumber());
        layoutHandler1.vehitype.setText(dataprovider_vehicleinsurance.getVehicletype());
        layoutHandler1.sd.setText(dataprovider_vehicleinsurance.getSdate());
        layoutHandler1.ed.setText(dataprovider_vehicleinsurance.getEdate());
        layoutHandler1.Ia.setText(dataprovider_vehicleinsurance.getIamount());
        layoutHandler1.Dd.setText(dataprovider_vehicleinsurance.getDdate());

        return rows;
    }
}
