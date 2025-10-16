package com.example.hello;

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

    private EditText InputA;
    private EditText InputB;
    private Button btn_calc;
    private TextView result;
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
        InputA = (EditText) findViewById(R.id.InputA);
        InputB = (EditText) findViewById(R.id.InputB);
        result = (TextView) findViewById(R.id.result);
        btn_calc = (Button) findViewById(R.id.btn_calc);
        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a= Integer.parseInt(InputA.getText().toString());
                int b= Integer.parseInt(InputB.getText().toString());
                int area = a * b;
                int perimeter = (a + b) * 2;
                result.setText("Area: "+ area + " " + "Perimeter: "+perimeter);
            }
        });
    }
}