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

public class AddTransactionActivity extends AppCompatActivity {

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);

//        Initializing layout elements
        EditText edit_Amount = (EditText) findViewById(R.id.edit_Amount);
        EditText edit_Category = (EditText) findViewById(R.id.edit_Category);
        EditText edit_Date = (EditText) findViewById(R.id.edit_Date);
        RadioGroup radio_Group = (RadioGroup) findViewById(R.id.radio_Group);
        RadioButton rbIncome = (RadioButton) findViewById(R.id.rbIncome);
        RadioButton rbExpense = (RadioButton) findViewById(R.id.rbExpense);
        Button bt_Save = (Button) findViewById(R.id.bt_Save);
        dbHelper = new DBHelper(this); // Database connection

//        Save button functionality
        bt_Save.setOnClickListener(v -> {
            // Get user input from the fields
            String amountStr = edit_Amount.getText().toString();
            String category = edit_Category.getText().toString();
            String date = edit_Date.getText().toString();
            String type = rbIncome.isChecked() ? "Income" : rbExpense.isChecked() ? "Expense" : "";

            // Check if any field is empty
            if (amountStr.isEmpty() || category.isEmpty() || date.isEmpty() || type.isEmpty()) {
                Toast.makeText(this, "Please fill all fields.", Toast.LENGTH_SHORT).show();
                return;
            }

            // Convert amount string to double
            double amount = Double.parseDouble(amountStr);

            // Create a transaction object from user input
            FinanceTransaction transaction = new FinanceTransaction(0, amount, category, date, type);

            // Insert transaction into the database
            long result = dbHelper.insertTransaction(transaction);

            if (result > 0) { // If successful, show message and clear fields for next input
                Toast.makeText(this, "Transaction saved.", Toast.LENGTH_SHORT).show();

                //  DELETE DATA AFTER SAVING
                edit_Amount.setText("");
                edit_Category.setText("");
                edit_Date.setText("");
                rbIncome.setChecked(false);
                rbExpense.setChecked(false);
            } else { // If saving failed, show error message
                Toast.makeText(this, "Save failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}