package com.example.lab03_ex2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    private TextView perimeterTextView, areaTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        perimeterTextView = findViewById(R.id.perimeter_text_view);
        areaTextView = findViewById(R.id.area_text_view);
        // Lấy kết quả từ Intent
        Intent intent = getIntent();
        double perimeter = intent.getDoubleExtra("perimeter", 0);
        double area = intent.getDoubleExtra("area", 0);
        // Hiển thị kết quả lên màn hình
        perimeterTextView.setText("Perimeter: " + perimeter);
        areaTextView.setText("Area: " + area);
    }
}
