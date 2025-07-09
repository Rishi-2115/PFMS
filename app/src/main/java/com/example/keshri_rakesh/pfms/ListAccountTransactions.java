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

public class ListAccountTransactions extends AppCompatActivity {
    ListView listTransactionss;
    String accountId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_account_transactions);

        accountId = this.getIntent().getStringExtra("accountid");
        listTransactionss = (ListView) this.findViewById(R.id.listTransactions);

        listTransactionss.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textTransId = (TextView) view
                        .findViewById(R.id.textTransId);
                Intent intent = new Intent(ListAccountTransactions.this,
                        TransactionDetails.class);
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
        return Utils.handleMenuOption(this,item);
    }



    @Override
    protected void onStart() {
        super.onStart();

        try {
            DBHelper dbHelper = new DBHelper(this);
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            Cursor trans = db.query(Database.TRANSACTIONS_TABLE_NAME, null, Database.TRANSACTIONS_ACCOUNT_ID + " =?",
                    new String[] { accountId }, null, null,
                    Database.TRANSACTIONS_TRANSDATE + " desc");

            if (trans.getCount() == 0)
            {
                this.findViewById(R.id.heading).setVisibility(View.INVISIBLE);
                this.findViewById(R.id.textError).setVisibility(View.VISIBLE);
            }
            else {
                this.findViewById(R.id.heading).setVisibility(View.VISIBLE);
                this.findViewById(R.id.textError).setVisibility(View.INVISIBLE);
            }

            ArrayList<Map<String, String>> listTrans = new ArrayList<Map<String, String>>();
            while (trans.moveToNext())
            {
                LinkedHashMap<String, String> tran = new LinkedHashMap<String, String>();
                tran.put("transid", trans.getString(trans
                        .getColumnIndex(Database.TRANSACTIONS_ID)));
                tran.put("transdate", trans.getString(trans
                        .getColumnIndex(Database.TRANSACTIONS_TRANSDATE)));
                String transType = trans.getString(trans
                        .getColumnIndex(Database.TRANSACTIONS_TRANSTYPE));
                String transAmount = trans.getString(trans
                        .getColumnIndex(Database.TRANSACTIONS_TRANSAMOUNT));
                String chequeno = trans.getString(trans
                        .getColumnIndex(Database.TRANSACTIONS_CHEQUE_NO));
                String transDetails = "Cash";
                if (!chequeno.trim().equals(""))
                    transDetails = "Cheque No: " + chequeno;
                tran.put("transdetails", transDetails);
                tran.put("transtype", transType);
                tran.put("transamount", transAmount);
                listTrans.add(tran);
            }
            trans.close();
            db.close();
            dbHelper.close();

            SimpleAdapter adapter = new SimpleAdapter(this, listTrans, R.layout.account_transaction, new String[] { "transid","transdate", "transdetails", "transtype","transamount"}
                    , new int[] { R.id.textTransId,
                    R.id.textTransDate, R.id.textTransDetails,
                    R.id.textTransType, R.id.textAmount });

            listTransactionss.setAdapter(adapter);
        }
        catch (Exception ex)
        {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
