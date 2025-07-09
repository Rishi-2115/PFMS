package com.example.keshri_rakesh.pfms;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class SearchTransactions extends AppCompatActivity {

    private EditText editFromDate,editToDate,editFromAmount,editToAmount;
    private int fromDay, fromMonth, fromYear;
    private int toDay, toMonth, toYear;
    private final int FROM_DATE_DIALOG = 1;
    private final int TO_DATE_DIALOG = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_transactions);

        editFromDate = (EditText) this.findViewById(R.id.editFromDate);
        editToDate = (EditText) this.findViewById(R.id.editToDate);

        editFromAmount = (EditText) this.findViewById(R.id.editFromAmount);
        editToAmount = (EditText) this.findViewById(R.id.editToAmount);

        // get the current date
        final Calendar c = Calendar.getInstance();
        fromYear = toYear = c.get(Calendar.YEAR);
        fromMonth  = toMonth = c.get(Calendar.MONTH);
        toDay = c.get(Calendar.DAY_OF_MONTH);

        fromDay  = 1;  // from is set to 1st of the current month

        updateToDateDisplay();
        updateFromDateDisplay();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return Utils.inflateMenu(this,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return  Utils.handleMenuOption(this,item);
    }

    private DatePickerDialog.OnDateSetListener fromDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int pYear, int pMonth, int pDay) {
            fromYear = pYear;
            fromMonth = pMonth;
            fromDay = pDay;

            updateFromDateDisplay();

        }
    };

    private DatePickerDialog.OnDateSetListener toDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int pYear, int pMonth, int pDay) {
            toYear = pYear;
            toMonth = pMonth;
            toDay = pDay;
            updateToDateDisplay();
        }
    };


    public void showFromDateDialog(View view) {

        showDialog(FROM_DATE_DIALOG);
    }

    public void showToDateDialog(View view) {

        showDialog(TO_DATE_DIALOG);
    }

    @Override
    protected Dialog onCreateDialog(int id)
    {
        switch (id)
        {
            case FROM_DATE_DIALOG:

                return new DatePickerDialog(this,fromDateSetListener,fromYear,fromMonth,fromDay);
            case TO_DATE_DIALOG:
                return new DatePickerDialog(this,toDateSetListener,toYear,toMonth,toDay);
        }
        return null;
    }

    private void updateToDateDisplay() {

        editToDate.setText( String.format("%d-%d-%d",toYear,toMonth + 1,toDay));
    }

    private void updateFromDateDisplay() {
        editFromDate.setText( String.format("%d-%d-%d",fromYear,fromMonth + 1,fromDay));
    }


    public void searchTransactions(View view) {

        Intent intent = new Intent(this, ListTransactions.class);
        intent.putExtra("fromdate", editFromDate.getText().toString());
        intent.putExtra("todate", editToDate.getText().toString());
        intent.putExtra("fromamount", editFromAmount.getText().toString());
        intent.putExtra("toamount", editToAmount.getText().toString());
        startActivity(intent);
    }

    public void clearFields(View view) {

        editFromDate.setText("");
        editToDate.setText("");
        editFromAmount.setText("");
        editToAmount.setText("");
    }
}
