package com.example.myfinanceapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link buttons from the layout
        Button bt_Add = (Button) findViewById(R.id.bt_Add);
        Button bt_View = (Button) findViewById(R.id.bt_View);
        Button bt_Report = (Button) findViewById(R.id.bt_Report);

        // On "Add" button click, navigate to AddTransactionActivity
        bt_Add.setOnClickListener(v -> startActivity(new Intent(this, AddTransactionActivity.class)));

        // On "View" button click, navigate to ViewTransactionsActivity
        bt_View.setOnClickListener(v -> startActivity(new Intent(this, ViewTransactionsActivity.class)));

        // On "Report" button click, navigate to GenerateReportActivity
        bt_Report.setOnClickListener(v -> startActivity(new Intent(this, GenerateReportActivity.class)));
    }
}