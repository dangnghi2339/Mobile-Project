package com.example.demolab5ex2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.demolab5ex2.R;
import com.example.demolab5ex2.Expense;

import java.util.List;

public class ExpenseAdapter extends ArrayAdapter<Expense> {

    public ExpenseAdapter(Context context, List<Expense> expenses) {
        super(context, 0, expenses);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Expense expense = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.expense_item, parent, false);
        }

        TextView tvName = convertView.findViewById(R.id.expense_name_tv);
        TextView tvAmount = convertView.findViewById(R.id.expense_amount_tv);
        TextView tvDate = convertView.findViewById(R.id.expense_date_tv);

        if (expense != null) {
            tvName.setText(expense.getName());
            tvAmount.setText(String.format("%,.2f VND", expense.getAmount()));
            tvDate.setText(expense.getFormattedDate());
        }

        return convertView;
    }
}