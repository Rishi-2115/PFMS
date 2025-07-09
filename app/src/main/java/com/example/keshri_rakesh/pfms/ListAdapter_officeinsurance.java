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

public class ListAdapter_officeinsurance extends ArrayAdapter {
    ArrayList list8 = new ArrayList();
    public ListAdapter_officeinsurance( Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler2
    {
        TextView pno,brnch,st,dt,Im;
    }

    @Override
    public void add( Object object) {
        super.add(object);
        list8.add(object);
    }

    @Override
    public int getCount() {
        return list8.size();
    }


    public Object getItem(int position) {
        return list8.get(position);
    }



    public View getView(int position,  View convertView,  ViewGroup parent) {
        View rows2 = convertView;
        LayoutHandler2 layoutHandler2;

        if(rows2==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rows2 = layoutInflater.inflate(R.layout.row_layout_officeinsurance,parent,false);

            layoutHandler2 = new LayoutHandler2();
            layoutHandler2.pno = (TextView)rows2.findViewById(R.id.p1_tv);
            layoutHandler2.brnch = (TextView)rows2.findViewById(R.id.br_tv);
            layoutHandler2.st = (TextView)rows2.findViewById(R.id.S_tv);
            layoutHandler2.dt = (TextView)rows2.findViewById(R.id.D_tv);
            layoutHandler2.Im = (TextView)rows2.findViewById(R.id.Im_tv);

            rows2.setTag(layoutHandler2);
        }
        else {
            layoutHandler2 = (LayoutHandler2)rows2.getTag();
        }

        Dataprovider_officeinsurance dof = (Dataprovider_officeinsurance)this.getItem(position);

        layoutHandler2.pno.setText(dof.getPol_no());
        layoutHandler2.brnch.setText(dof.getBranch());
        layoutHandler2.st.setText(dof.getS());
        layoutHandler2.dt.setText(dof.getD());
        layoutHandler2.Im.setText(dof.getI());

        return rows2;
    }
}
