package com.example.keshri_rakesh.pfms;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class ListAccounts extends AppCompatActivity {
    ListView listAccountss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listaccounts);

        listAccountss = (ListView) this.findViewById(R.id.listAccounts);

        listAccountss.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textAccountId = (TextView) view.findViewById(R.id.textAccountId);
                Log.d("Accounts", "Selected Account Id : " + textAccountId.getText().toString());
                Intent intent = new Intent(ListAccounts.this, UpdateAccount.class);
                intent.putExtra("accountid", textAccountId.getText().toString());
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
            Cursor accounts = db.query(Database.ACCOUNTS_TABLE_NAME,null,null,null,null,null,null);

            String from [] = { Database.ACCOUNTS_ID, Database.ACCOUNTS_BANK, Database.ACCOUNTS_HOLDERS, Database.ACCOUNTS_BALANCE};
            int to [] = { R.id.textAccountId, R.id.textBank, R.id.textHolder, R.id.textBalance};

            SimpleCursorAdapter ca = new SimpleCursorAdapter(this,R.layout.account, accounts, from,to);


            ListView listAccounts = (ListView)this.findViewById(R.id.listAccounts);
            listAccounts.setAdapter(ca);
            dbHelper.close();
        }
        catch (Exception ex)
        {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void addAccount(View view) {
        Intent intent = new Intent(this,AddAccount.class);
        startActivity(intent);
    }

    public void addTransaction(View view) {

        Intent intent = new Intent(this,AddTransaction.class);
        startActivity(intent);
    }

    public void recentTransactions(View view) {
        Intent intent = new Intent(this,ListRecentTransactions.class);
        startActivity(intent);
    }
}
