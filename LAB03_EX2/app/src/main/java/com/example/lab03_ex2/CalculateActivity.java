package com.example.lab03_ex2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculateActivity extends AppCompatActivity {
    private TextView shapeLabel;
    private EditText input1, input2;
    private Button calculateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        shapeLabel = findViewById(R.id.shape_label);
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        calculateButton = findViewById(R.id.calculate_button);
        // Retrieve image data from Intent
        Intent intent = getIntent();
        String selectedShape = intent.getStringExtra("shape");
        // Set the title of the image on the screen
        shapeLabel.setText("Calculate " + selectedShape);
        // Handling events when the user presses the calculate button
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve input value from user
                double value1 = Double.parseDouble(input1.getText().toString());
                double value2 = Double.parseDouble(input2.getText().toString());

                // Calculate perimeter and area based on the selected shape
                double perimeter = 0, area = 0;
                if (selectedShape.equals("Square")) {
                    perimeter = 4 * value1;
                    area = value1 * value1;
                } else if (selectedShape.equals("Rectangle")) {
                    perimeter = 2 * (value1 + value2);
                    area = value1 * value2;
                } else if (selectedShape.equals("Triangle")) {
                    perimeter = value1 + 2 * Math.sqrt(Math.pow(value1 / 2, 2) + Math.pow(value2, 2));
                    area = 0.5 * value1 * value2;
                } else if (selectedShape.equals("Circle")) {
                    perimeter = 2 * Math.PI * value1;
                    area = Math.PI * Math.pow(value1, 2);
                }

                Intent resultIntent = new Intent(CalculateActivity.this, ResultActivity.class);
                resultIntent.putExtra("perimeter", perimeter);
                resultIntent.putExtra("area", area);
                startActivity(resultIntent);
            }
        });
    }
}
