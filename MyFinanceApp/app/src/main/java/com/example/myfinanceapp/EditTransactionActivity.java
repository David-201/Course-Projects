package com.example.myfinanceapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EditTransactionActivity extends AppCompatActivity {

    DBHelper dbHelper;
    int transactionId; // ID of the transaction to edit
    FinanceTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction); // Reuse the layout from AddTransactionActivity

        // Link UI components from the layout
        EditText edit_Amount = (EditText) findViewById(R.id.edit_Amount);
        EditText edit_Category = (EditText) findViewById(R.id.edit_Category);
        EditText edit_Date = (EditText) findViewById(R.id.edit_Date);
        RadioGroup radio_Group = (RadioGroup) findViewById(R.id.radio_Group);
        Button bt_Save = (Button) findViewById(R.id.bt_Save);
        bt_Save.setText("Update"); // Change button text from "Save" to "Update"

        dbHelper = new DBHelper(this);

        // Get transaction ID passed from Intent
        transactionId = getIntent().getIntExtra("id", -1);
        transaction = dbHelper.getTransactionById(transactionId);

        // If transaction is found, populate form with its data
        if (transaction != null){
            edit_Amount.setText(String.valueOf(transaction.getAmount()));
            edit_Category.setText(transaction.getCategory());
            edit_Date.setText(transaction.getDate());

            // Set the correct radio button based on transaction type
            if (transaction.getType().equals("Income")) {
                radio_Group.check(R.id.rbIncome);
            } else {
                radio_Group.check(R.id.rbExpense);
            }
        }

        // Handle click on Update button
        bt_Save.setOnClickListener(v -> {
            // Get selected transaction type from RadioGroup
            transaction.setAmount(Double.parseDouble(edit_Amount.getText().toString()));
            transaction.setCategory(edit_Category.getText().toString());
            transaction.setDate(edit_Date.getText().toString());
            transaction.setType(((RadioButton) findViewById(radio_Group.getCheckedRadioButtonId())).getText().toString());

            dbHelper.updateTransaction(transaction); // Call DB helper to update transaction in database
            Toast.makeText(this, "Transaction updated!", Toast.LENGTH_SHORT).show();
            finish();
        });

    }
}