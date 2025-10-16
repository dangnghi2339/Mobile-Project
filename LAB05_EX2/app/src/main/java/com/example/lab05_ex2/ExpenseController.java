package com.example.lab05_ex2;

import java.util.ArrayList;
import java.util.List;

public class ExpenseController {
    private static List<Expense> expenses = new ArrayList<>();
    public static void addExpense(Expense expense) {
        expenses.add(expense);
        // Update view to reflect the changes
    }
    public static List<Expense> getAllExpenses() {
        return expenses;
    }
}
