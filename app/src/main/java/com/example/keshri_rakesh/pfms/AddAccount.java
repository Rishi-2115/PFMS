package com.example.keshri_rakesh.pfms;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addaccount);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return Utils.inflateMenu(this,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return Utils.handleMenuOption(this,item);
    }

    public void addAccount(View view) {

        EditText editAcno = (EditText) this.findViewById(R.id.editAcno);
        EditText editCno = (EditText) this.findViewById(R.id.editCno);
        EditText editHolders = (EditText) this.findViewById(R.id.editHolders);
        EditText editBankName = (EditText) this.findViewById(R.id.editBankName);
        EditText editBranchName = (EditText) this.findViewById(R.id.editBranchName);
        EditText editAddress = (EditText) this.findViewById(R.id.editAddress);
        EditText editIFSC = (EditText) this.findViewById(R.id.editIFSC);
        EditText editMICR = (EditText) this.findViewById(R.id.editMICR);
        EditText editBalance = (EditText) this.findViewById(R.id.editBalance);
        EditText editRemarks = (EditText) this.findViewById(R.id.editRemarks);

        try {
            DBHelper dbHelper = new DBHelper(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            Log.d("Account","Got writable database");

            ContentValues values = new ContentValues();
            values.put( Database.ACCOUNTS_ACNO, editAcno.getText().toString());
            values.put( Database.ACCOUNTS_CNO, editCno.getText().toString());
            values.put( Database.ACCOUNTS_HOLDERS, editHolders.getText().toString());
            values.put( Database.ACCOUNTS_BANK, editBankName.getText().toString());
            values.put( Database.ACCOUNTS_BRANCH, editBranchName.getText().toString());
            values.put( Database.ACCOUNTS_ADDRESS, editAddress.getText().toString());
            values.put( Database.ACCOUNTS_IFSC, editIFSC.getText().toString());
            values.put( Database.ACCOUNTS_MICR, editMICR.getText().toString());
            values.put( Database.ACCOUNTS_BALANCE, editBalance.getText().toString());
            values.put( Database.ACCOUNTS_REMARKS, editRemarks.getText().toString());

            long rows = db.insert(Database.ACCOUNTS_TABLE_NAME,null,values);
            db.close();

            if( rows >0 )
            {
                Toast.makeText(this, "Account Added Successfully", Toast.LENGTH_SHORT).show();
                this.finish();
            }
            else
                Toast.makeText(this, "Sorry! Couldn't add the account", Toast.LENGTH_SHORT).show();
        }
        catch (Exception ex)
        {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
