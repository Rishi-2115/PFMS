package com.example.keshri_rakesh.pfms;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class AddTransaction extends AppCompatActivity {

    private Spinner spinnerAccounts;
    private TextView textTransDate;
    private int day, month, year;
    private final int DATE_DIALOG = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_transaction);

        spinnerAccounts = (Spinner) this.findViewById(R.id.spinnerAccounts);
        Database.populateAccounts(spinnerAccounts);
        textTransDate = (TextView) this.findViewById(R.id.textTransDate);

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        updateDateDisplay();
    }
    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int pYear, int pMonth, int pDay) {
            year = pYear;
            month = pMonth;
            day = pDay;
            updateDateDisplay();
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void showDateDialog(View view) {
        showDialog(DATE_DIALOG);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        super.onCreateDialog(id);

        switch (id){
            case DATE_DIALOG:
                return new DatePickerDialog(this,dateSetListener,year,month,day);
        }
        return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return Utils.inflateMenu(this,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return Utils.handleMenuOption(this,item);
    }

    private void updateDateDisplay()
    {
        textTransDate.setText(String.format("%d-%d-%d",year,month + 1,day));
    }



    public void addTransaction(View view) {

        String accountId = Database.getAccountId(spinnerAccounts);
        RadioButton radioDeposit = (RadioButton) this.findViewById(R.id.radioDeposit);

        EditText editTransAmount = (EditText) this.findViewById(R.id.editTransAmount);
        EditText editChequeNo = (EditText) this.findViewById(R.id.editChequeNo);
        EditText editChequeParty = (EditText) this.findViewById(R.id.editChequeParty);
        EditText editChequeDetails = (EditText) this.findViewById(R.id.editChequeDetails);
        EditText editRemarks = (EditText) this.findViewById(R.id.editRemarks);


        boolean done = Database.addTransaction(this,
                accountId,
                radioDeposit.isChecked() ? "d" : "w",
                textTransDate.getText().toString(),
                editTransAmount.getText().toString(),
                editChequeNo.getText().toString(),
                editChequeParty.getText().toString(),
                editChequeDetails.getText().toString(),
                editRemarks.getText().toString());

        if (done)
            Toast.makeText(this, "Added Transaction Successfully", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Sorry! Transaction couldn't be added", Toast.LENGTH_SHORT).show();
    }
}
