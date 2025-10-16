package com.example.lab1b_2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.MonthDisplayHelper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.MonthDay;

public class MainActivity extends AppCompatActivity {

    EditText editTextMonth, editTextYear;
    Button buttonCheck;
    TextView textViewResult;

    @SuppressLint("MissingInflatedId")
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
        editTextMonth = findViewById(R.id.editTextMonth);
        editTextYear = findViewById(R.id.editTextYear);
        buttonCheck = findViewById(R.id.buttonCheck);
        textViewResult = findViewById(R.id.textViewResult);

        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monthStr = editTextMonth.getText().toString();
                String yearStr = editTextYear.getText().toString();

                if (monthStr.isEmpty() || yearStr.isEmpty()) {
                    textViewResult.setText("Vui lòng nhập đầy đủ tháng và năm.");
                    return;
                }

                int month = Integer.parseInt(monthStr);
                int year = Integer.parseInt(yearStr);

                if (month < 1 || month > 12) {
                    textViewResult.setText("Tháng không hợp lệ. Nhập từ 1 đến 12.");
                    return;
                }

                int days = getDaysInMonth(month, year);
                textViewResult.setText("Tháng " + month + " năm " + year + " có " + days + " ngày.");
            }
        });
    }
    private int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                // Kiểm tra năm nhuận
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
                    return 29;
                else
                    return 28;
            default:
                return 0; // Không thể xảy ra
        }
    }
}