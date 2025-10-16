package com.example.demolab5ex2;

public class Expense {
    private int id;
    private String name;
    private double amount;
    private long timestamp;

    public Expense(int id, String name, double amount, long timestamp) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public Expense(String name, double amount, long timestamp) {
        this.name = name;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public long getTimestamp() {
        return timestamp;
    }

    // Setter (chỉ để cập nhật ID nếu cần)
    public void setId(int id) {
        this.id = id;
    }

    public String getFormattedDate() {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy", java.util.Locale.getDefault());
        return sdf.format(new java.util.Date(timestamp));
    }
}