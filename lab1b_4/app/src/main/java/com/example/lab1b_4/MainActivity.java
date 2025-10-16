package com.example.lab1b_4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editTextNum1, editTextNum2, editTextNum3;
    Button buttonFindMax;
    TextView textViewResult;

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

        editTextNum1 = findViewById(R.id.editTextNum1);
        editTextNum2 = findViewById(R.id.editTextNum2);
        editTextNum3 = findViewById(R.id.editTextNum3);
        buttonFindMax = findViewById(R.id.buttonFindMax);
        textViewResult = findViewById(R.id.textViewResult);

        buttonFindMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(editTextNum1.getText().toString());
                int num2 = Integer.parseInt(editTextNum2.getText().toString());
                int num3 = 0;

                if (!editTextNum3.getText().toString().isEmpty()) {
                    num3 = Integer.parseInt(editTextNum3.getText().toString());
                    int max = Math.max(num1, Math.max(num2, num3));
                    textViewResult.setText("Số lớn nhất là: " + max);
                } else {
                    int max = Math.max(num1, num2);
                    textViewResult.setText("Số lớn nhất là: " + max);
                }
            }
        });
    }
}