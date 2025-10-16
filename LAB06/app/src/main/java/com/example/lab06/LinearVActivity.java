package com.example.lab06;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LinearVActivity extends AppCompatActivity {

    EditText myEditText;
    Button myButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_vactivity);
        myEditText = (EditText) findViewById(R.id.editTextName);
        myButton = (Button) findViewById(R.id.buttonSend);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // give data for previous activity
                Intent intent = new Intent();
                Bundle bundle = new Bundle();

                bundle.putString("YourName",myEditText.getText().toString() ); // getName value
                intent.putExtras(bundle); //send with data
                setResult(RESULT_OK, intent); // return result
                finish(); // close activity2 and back to Activity1
            }
        });
    }
}