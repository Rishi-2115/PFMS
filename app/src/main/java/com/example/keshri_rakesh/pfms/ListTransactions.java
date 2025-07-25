package com.example.keshri_rakesh.pfms;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class ListTransactions extends AppCompatActivity {

    ListView listTransactionssss;
    String  fromDate,toDate,fromAmount,toAmount;
    String  condition = " 1 = 1 ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_transactions);

        fromDate = this.getIntent().getStringExtra("fromdate");
        toDate = this.getIntent().getStringExtra("todate");
        fromAmount = this.getIntent().getStringExtra("fromamount");
        toAmount = this.getIntent().getStringExtra("toamount");
        listTransactionssss = (ListView) this.findViewById(R.id.listTransactions);

        if ( fromDate.length() > 0)
            condition += " and  " + Database.TRANSACTIONS_TRANSDATE + " >= '" + fromDate + "'";

        if ( toDate.length() > 0)
            condition += " and  " + Database.TRANSACTIONS_TRANSDATE + " <= '" + toDate + "'";

        if ( fromAmount.length() > 0)
            condition += " and  " + Database.TRANSACTIONS_TRANSAMOUNT + " >= " + fromAmount;

        if ( toAmount.length() > 0)
            condition += " and  " + Database.TRANSACTIONS_TRANSAMOUNT + " <= " + toAmount;


        listTransactionssss.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textTransId = (TextView) view.findViewById(R.id.textTransId);
                Intent intent = new Intent(ListTransactions.this, TransactionDetails.class);
                intent.putExtra("transid", textTransId.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return Utils.inflateMenu(this,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return  Utils.handleMenuOption(this,item);
    }

    @Override
    protected void onStart() {
        super.onStart();

        try {
            DBHelper dbHelper = new DBHelper(this);
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            Cursor trans = db.rawQuery("select t._id, acno, bank, transdate,transamount,transtype,cheque_no,cheque_party,cheque_details, t.remarks from transactions t inner join accounts a  on ( a._id = t.account_id) where " + condition,null);
            if ( trans.getCount() == 0 )
                this.findViewById(R.id.textError).setVisibility(View.VISIBLE);
            else
                this.findViewById(R.id.textError).setVisibility(View.INVISIBLE);

            ArrayList<Map<String,String>> listTrans = new ArrayList<Map<String,String>>();

            while ( trans.moveToNext())
            {
                LinkedHashMap<String,String> tran = new LinkedHashMap<String,String>();
                tran.put("transid", trans.getString(trans.getColumnIndex(Database.TRANSACTIONS_ID)));
                tran.put("acno",  trans.getString(trans.getColumnIndex(Database.ACCOUNTS_ACNO)) + " - " +   trans.getString(trans.getColumnIndex(Database.ACCOUNTS_BANK)));
                tran.put("transdate",trans.getString(trans.getColumnIndex(Database.TRANSACTIONS_TRANSDATE)));
                tran.put("transtype",trans.getString(trans.getColumnIndex(Database.TRANSACTIONS_TRANSTYPE)));
                tran.put("transamount",trans.getString(trans.getColumnIndex(Database.TRANSACTIONS_TRANSAMOUNT)));
                tran.put("transremarks",trans.getString(trans.getColumnIndex(Database.TRANSACTIONS_REMARKS)));

                String chequeno = trans.getString(trans.getColumnIndex(Database.TRANSACTIONS_CHEQUE_NO));
                String transDetails = "Cash";
                if (! chequeno.trim().equals(""))
                    transDetails = "Cheque No: " + chequeno;

                tran.put("transdetails",transDetails);
                listTrans.add(tran);
            }
            trans.close();
            db.close();
            dbHelper.close();

            SimpleAdapter adapter = new SimpleAdapter(this,
                    listTrans,
                    R.layout.transaction,
                    new String [] {"transid", "acno", "transdate", "transdetails", "transtype", "transamount" ,"transremarks"},
                    new  int [] {  R.id.textTransId, R.id.textAcno,  R.id.textTransDate, R.id.textTransDetails, R.id.textTransType, R.id.textTransAmount, R.id.textTransRemarks});

            listTransactionssss.setAdapter(adapter);
        }
        catch (Exception ex)
        {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
