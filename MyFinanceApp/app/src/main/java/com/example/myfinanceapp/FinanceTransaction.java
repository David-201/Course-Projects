package com.example.myfinanceapp;

public class FinanceTransaction {

    // Attributes of a financial transaction
    private int id;
    private double amount;
    private String category;
    private String date;
    private String type; // "Income" or "Expense"


    // No-argument constructor – used when creating an empty object
    public FinanceTransaction() {
    }

    // Full-argument constructor – used to create a transaction with all details
    public FinanceTransaction(int id, double amount, String category, String date, String type) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
