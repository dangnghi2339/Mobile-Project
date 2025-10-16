package com.example.intentlab;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        super.onCreateOptionsMenu(menu);
    // get context menu of app
        MenuInflater inflater = getMenuInflater();
    // set menu
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Sử dụng if-else if thay cho switch
        if (item.getItemId() == R.id.clear) {
            AlertDialog.Builder message = new AlertDialog.Builder(this);
            message.setTitle(R.string.message_caption);
            message.setMessage(R.string.message_content);
            message.setNeutralButton(R.string.close, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    EditText et = (EditText) findViewById(R.id.editText1);
                    et.setText("");
                }
            }).show();
        } else
            if (item.getItemId() == R.id.setting) {
            // Xử lý sự kiện setting
        } else if (item.getItemId() == R.id.exit) {
            // Xử lý sự kiện exit
        }
        return super.onOptionsItemSelected(item);
    }
}