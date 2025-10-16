package com.example.lab1b_5;

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

    EditText editTextA, editTextB;
    Button buttonSolve;
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

        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        buttonSolve = findViewById(R.id.buttonSolve);
        textViewResult = findViewById(R.id.textViewResult);

        buttonSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(editTextA.getText().toString());
                double b = Double.parseDouble(editTextB.getText().toString());
                if (a == 0) {
                    if (b == 0) {
                        textViewResult.setText("Phương trình có vô số nghiệm.");
                    } else {
                        textViewResult.setText("Phương trình vô nghiệm.");
                    }
                } else {
                    double x = -b / a;
                    textViewResult.setText("Nghiệm của phương trình là: x = " + x);
                }
            }
        });
    }
}