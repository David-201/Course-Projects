package com.example.myfinanceapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "FinanceDB.db"; // Database file name
    private static final int DB_VERSION = 2; // Database version
    private static final String TABLE_NAME = "Transactions"; // Table name

    // Constructor to initialize the DBHelper
    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // Called when database is created for the first time
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "amount REAL, " +
                "category TEXT, " +
                "date TEXT, " +
                "type TEXT)";
        db.execSQL(createTable); // Execute table creation
    }


    // Called when DB version is upgraded
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Insert a transaction into the database
    public long insertTransaction(FinanceTransaction transaction) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("amount", transaction.getAmount());
        values.put("category", transaction.getCategory());
        values.put("date", transaction.getDate());
        values.put("type", transaction.getType());
        long result = db.insert(TABLE_NAME, null, values);
        db.close();
        return result;
    }

    // Update an existing transaction by ID
    public int updateTransaction(FinanceTransaction transaction) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("amount", transaction.getAmount());
        values.put("category", transaction.getCategory());
        values.put("date", transaction.getDate());
        values.put("type", transaction.getType());
        int result = db.update(TABLE_NAME, values, "id = ?", new String[]{String.valueOf(transaction.getId())});
        db.close();
        return result;
    }

    // Delete a transaction by ID
    public int deleteTransaction(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TABLE_NAME, "id = ?", new String[]{String.valueOf(id)});
        db.close();
        return result;
    }

    // Get all transactions from the table
    public ArrayList<FinanceTransaction> getAllTransactions() {
        ArrayList<FinanceTransaction> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                FinanceTransaction t = new FinanceTransaction();
                t.setId(cursor.getInt(0));
                t.setAmount(cursor.getDouble(1));
                t.setCategory(cursor.getString(2));
                t.setDate(cursor.getString(3));
                t.setType(cursor.getString(4));
                list.add(t);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }

    // Get a transaction by its ID
    public FinanceTransaction getTransactionById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE id = ?", new String[]{String.valueOf(id)});
        if (cursor.moveToFirst()) {
            FinanceTransaction t = new FinanceTransaction();
            t.setId(cursor.getInt(0));
            t.setAmount(cursor.getDouble(1));
            t.setCategory(cursor.getString(2));
            t.setDate(cursor.getString(3));
            t.setType(cursor.getString(4));
            cursor.close();
            db.close();
            return t;
        }
        cursor.close();
        db.close();
        return null;
    }

    // Internal method to get total amount by type
    private double getTotalByType(String type) {
        double total = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT SUM(amount) FROM Transactions WHERE type = ?",
                new String[]{type}
        );
        if (cursor.moveToFirst()) {
            if (!cursor.isNull(0)) {
                total = cursor.getDouble(0);
            }
        }
        cursor.close();
        db.close();
        return total;
    }

    // Get total income
    public double getTotalIncome() {
        return getTotalByType("Income");
    }

    // Get total expense
    public double getTotalExpense() {
        return getTotalByType("Expense");
    }
}
