package com.example.mangsonguyen;

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

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText et_day;
    TextView tv_kq;
    Button taoday,xuatxuoi,xuatnguoc,minmax;
    int myArray[] =new int[10];
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
        et_day=(EditText)findViewById(R.id.editText);
        tv_kq=(TextView)findViewById(R.id.textView2);
        taoday=(Button)findViewById(R.id.button);
        xuatxuoi=(Button)findViewById(R.id.button2);
        xuatnguoc=(Button)findViewById(R.id.button3);
        minmax=(Button)findViewById(R.id.button4);



        taoday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rd=new Random();
                String chuoi="";
                for(int i=0;i<10;i++){
                    myArray[i]=rd.nextInt(50-10+1)+10; //10->50
                }
                ArraytoEditText();
            }
        });

        xuatxuoi.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                ArraytoEditText();
            }
        });

        xuatnguoc.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String chuoi="";
                for(int i=9;i>=0;i--){
                    chuoi+= myArray[i]+ " ";
                }
                et_day.setText(chuoi);
            }
        });

        minmax.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int min=myArray[0];
                int max=myArray[0];
                for(int i=0;i<10;i++) {
                    if(myArray[i]<min) min=myArray[i];
                    if(myArray[i]>max) max=myArray[i];
                }
                tv_kq.setText("Min: "+min + " max: "+max);
            }
        });

    }
    public void ArraytoEditText()
    {
        String chuoi="";
        for(int i=0;i<10; i++)
        {
            chuoi +=myArray[i]+ " ";
        }
        et_day.setText(chuoi);
    }
}