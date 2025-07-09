package com.example.keshri_rakesh.pfms;


import android.annotation.TargetApi;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

//import android.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Overview extends android.support.v4.app.Fragment {

    private ListView listView;
    List<Overview_ListView> listOverview;
    Overview_List_Adapter adapterOverview;
    TextView total;

    public Overview() {
        // Required empty public constructor
    }


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_overview, container, false);

        listView = (ListView) view.findViewById(R.id.list_viewAll);
        total = (TextView)view.findViewById(R.id.txtAmountOverview);
        getTotal();

         DBHelper1 db = new DBHelper1(getContext());
        listOverview = db.getOverviewList();
        adapterOverview = new Overview_List_Adapter(getContext(), listOverview);
        listView.setAdapter(adapterOverview);
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public Cursor getTotal() {
        DBHelper1 db = new DBHelper1(getContext());
        SQLiteDatabase sql = db.getReadableDatabase();
        String query = "SELECT SUM(amount) AS total FROM Add_Expense";
        Cursor c = sql.rawQuery(query, null);
        c.moveToFirst();
        c.getInt(0);

        DecimalFormat precision = new DecimalFormat("0 ₹");
        total.setText(precision.format(c.getInt(0)));
        return c;
    }



}