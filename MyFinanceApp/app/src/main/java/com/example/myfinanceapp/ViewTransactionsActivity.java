package com.example.myfinanceapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ViewTransactionsActivity extends AppCompatActivity {

    ListView list_View; // ListView to display transactions
    DBHelper dbHelper;
    ArrayList<FinanceTransaction> transactionList; // List of all transactions
    ArrayAdapter<String> adapter; // Adapter for displaying strings in the list
    int selectedIndex = -1;  // Index of selected transaction

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_transactions);

        // Bind UI elements
        list_View = (ListView) findViewById(R.id.list_View);
        Button bt_Delete = (Button) findViewById(R.id.bt_Delete);
        Button bt_Edit = (Button) findViewById(R.id.bt_Edit);
        dbHelper = new DBHelper(this);

        loadTransactions(); // Load and display the list of transactions

        // Handle selection when a list item is clicked
        list_View.setOnItemClickListener((parent, view, position, id) -> {
            selectedIndex = position;
            list_View.setItemChecked(position,true);
        });

        // Handle delete button click
        bt_Delete.setOnClickListener(v -> {
            if (selectedIndex != -1) {
                // Confirmation dialog
                new AlertDialog.Builder(this)
                        .setTitle("Delete")
                        .setMessage("Are you sure you want to delete this transaction?")
                        .setPositiveButton("Yes", (dialog, which) -> {

                            // Delete from DB and reload list
                            dbHelper.deleteTransaction(transactionList.get(selectedIndex).getId());
                            loadTransactions();
                            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
                        })
                        .setNegativeButton("No", null) // Do nothing on "No"
                        .show();
            }
        });

        // Handle edit button click
        bt_Edit.setOnClickListener(v -> {
            // Open EditTransactionActivity and pass the selected transaction ID
            if (selectedIndex != -1) {
                Intent intent = new Intent(this, EditTransactionActivity.class);
                intent.putExtra("id", transactionList.get(selectedIndex).getId());
                startActivity(intent);
            }
        });
    }

    // Load transactions from DB and update the ListView
    private void loadTransactions() {
        transactionList = dbHelper.getAllTransactions();
        ArrayList<String> displayList = new ArrayList<>(); // List to show in UI

        // Format each transaction for display
        for (FinanceTransaction t : transactionList) {
            displayList.add(t.getDate() + " - " + t.getType() + ": $" + t.getAmount() + " - " + t.getCategory());
        }

        // Set adapter and update list
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, displayList);
        list_View.setAdapter(adapter);
        list_View.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        Log.d("DEBUG", "Total transactions: " + transactionList.size());

    }

    // Reload list when returning to this activity
    @Override
    protected void onResume() {
        super.onResume();
        loadTransactions(); // Reload data in case something was edited or deleted
    }
}