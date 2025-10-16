package com.example.demolab5ex2;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demolab5ex2.ExpenseAdapter;
import com.example.demolab5ex2.DatabaseHelper;
import com.example.demolab5ex2.Expense;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;
    private ListView expenseListView;
    private TextView totalToday, totalWeek, totalMonth;
    private Button addExpenseButton;
    private ExpenseAdapter adapter;
    private List<Expense> expenseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);
        expenseListView = findViewById(R.id.expense_list_view);
        totalToday = findViewById(R.id.total_today_tv);
        totalWeek = findViewById(R.id.total_week_tv);
        totalMonth = findViewById(R.id.total_month_tv);
        addExpenseButton = findViewById(R.id.add_expense_btn);

        addExpenseButton.setOnClickListener(v -> showAddExpenseDialog());

        loadData();
    }

    private void loadData() {
        expenseList = dbHelper.getAllExpenses();
        adapter = new ExpenseAdapter(this, expenseList);
        expenseListView.setAdapter(adapter);

        updateStatistics();
    }

    private void updateStatistics() {
        Calendar cal = Calendar.getInstance();
        long now = cal.getTimeInMillis();

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        long startOfDay = cal.getTimeInMillis();
        double totalDay = dbHelper.getTotalExpenses(startOfDay, now);
        totalToday.setText(String.format("Hôm nay: %.2f", totalDay));

        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        long startOfWeek = cal.getTimeInMillis();
        double totalWk = dbHelper.getTotalExpenses(startOfWeek, now);
        totalWeek.setText(String.format("Tuần này: %.2f", totalWk));

        cal.set(Calendar.DAY_OF_MONTH, 1);
        long startOfMonth = cal.getTimeInMillis();
        double totalMon = dbHelper.getTotalExpenses(startOfMonth, now);
        totalMonth.setText(String.format("Tháng này: %.2f", totalMon));
    }

    private void showAddExpenseDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.dialog_add_expense, null);
        builder.setView(dialogView);

        final EditText nameInput = dialogView.findViewById(R.id.expense_name_input);
        final EditText amountInput = dialogView.findViewById(R.id.expense_amount_input);
        Button saveBtn = dialogView.findViewById(R.id.save_expense_btn);

        final AlertDialog dialog = builder.create();

        saveBtn.setOnClickListener(v -> {
            String name = nameInput.getText().toString().trim();
            String amountStr = amountInput.getText().toString().trim();

            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(amountStr)) {
                Toast.makeText(MainActivity.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                double amount = Double.parseDouble(amountStr);
                long timestamp = System.currentTimeMillis();

                Expense newExpense = new Expense(name, amount, timestamp);
                dbHelper.addExpense(newExpense);
                Toast.makeText(MainActivity.this, "Đã thêm chi tiêu!", Toast.LENGTH_SHORT).show();

                loadData();
                dialog.dismiss();

            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Số tiền không hợp lệ", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
    }
}