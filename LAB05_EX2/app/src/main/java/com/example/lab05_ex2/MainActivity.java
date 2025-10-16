package com.example.lab05_ex2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText expenseNameEditText;
    private EditText expenseAmountEditText;
    private EditText expenseDateEditText;
    private Button addButton;
    private TextView totalExpensesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        expenseNameEditText = findViewById(R.id.expenseNameEditText);
        expenseAmountEditText = findViewById(R.id.expenseAmountEditText);
        expenseDateEditText = findViewById(R.id.expenseDateEditText);
        addButton = findViewById(R.id.addButton);
        totalExpensesTextView = findViewById(R.id.totalExpensesTextView);
        addButton.setOnClickListener(view -> {
            String name = expenseNameEditText.getText().toString();
            double amount = Double.parseDouble(expenseAmountEditText.getText().toString());
            String date = expenseDateEditText.getText().toString();
            Expense expense = new Expense(name, amount, date);
            // Call controller to add expense to the model
            ExpenseController.addExpense(expense);
        });
        // Display statistics
        List<Expense> expenses = ExpenseController.getAllExpenses();
        double totalExpenses = 0;
        for (Expense expense : expenses) {
            totalExpenses += expense.getAmount();
        }
        // Display total expenses in UI

        totalExpensesTextView.setText(String.valueOf(totalExpenses));
        // Display other statistics as needed
    }
}