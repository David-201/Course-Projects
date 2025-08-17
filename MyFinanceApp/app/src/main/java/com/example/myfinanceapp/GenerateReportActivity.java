package com.example.myfinanceapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GenerateReportActivity extends AppCompatActivity {

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_report);

        // Link UI components from the layout
        TextView text_Income = (TextView) findViewById(R.id.text_Income);
        TextView text_Expense = (TextView) findViewById(R.id.text_Expense);
        TextView text_Balance = (TextView) findViewById(R.id.text_Balance);
        Button bt_Back = (Button) findViewById(R.id.bt_Back);

        dbHelper = new DBHelper(this);

        try {
            // Fetch total income and expense from database
            double income = dbHelper.getTotalIncome();
            double expense = dbHelper.getTotalExpense();
            double balance = income - expense; // Calculate balance

            // Display results in TextViews
            text_Income.setText("Income: $" + income);
            text_Expense.setText("Expense: $" + expense);
            text_Balance.setText("Balance: $" + balance);
        } catch (Exception e){
            // If error occurs, show toast and display "Error" in views
            Toast.makeText(this, "Error calculating report: " + e.getMessage(), Toast.LENGTH_LONG).show();
            text_Income.setText("Income: Error");
            text_Expense.setText("Expense: Error");
            text_Balance.setText("Balance: Error");
        }

        // When the "Back" button is clicked, close this activity
        bt_Back.setOnClickListener(v -> finish());

    }
}