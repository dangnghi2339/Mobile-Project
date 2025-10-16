package com.example.lab03_ex2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Spinner shapeSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shapeSpinner = findViewById(R.id.shape_spinner);

        // Create an ArrayAdapter from a string array data source
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.shapes_array, android.R.layout.simple_spinner_item);
        // Assign layout to spinner

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Assign adapter to spinner
        shapeSpinner.setAdapter(adapter);

        // Handling events when the user selects an image
        shapeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               // Retrieve the selected image
               String selectedShape = parent.getItemAtPosition(position).toString();
               // Switch to the screen for calculating perimeter andarea."
               Intent intent = new Intent(MainActivity.this, CalculateActivity.class);
               intent.putExtra("shape", selectedShape);
               startActivity(intent);
           }
           @Override
           public void onNothingSelected(AdapterView<?> parent) {
               // Do nothing
           }
        });
    }
}