package com.example.lab06;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FrameActivity extends AppCompatActivity implements View.OnClickListener {
    Button mybt;
    FrameLayout fl;
    int card_array[]={

            R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,

            R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,
            R.drawable.cj,R.drawable.cq,R.drawable.ck,

            R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,

            R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,
            R.drawable.dj,R.drawable.dq,R.drawable.dk,

            R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,

            R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,
            R.drawable.hj,R.drawable.hq,R.drawable.hk,
            R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,

            R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,
            R.drawable.sj,R.drawable.sq,R.drawable.sk
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        mybt = (Button) findViewById(R.id.buttonBackFrame);
        mybt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        fl=(FrameLayout)findViewById(R.id.FrameLayoutDemo);
        for(int i=0;i<13;i++)
        {
            ImageView iv1=new ImageView(this);
            iv1.setImageResource(card_array[i]);
            FrameLayout.LayoutParams lay1=new
                    FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT);
            lay1.setMargins(30+(i*40), 200, 100, 200);
            iv1.setLayoutParams(lay1);
            iv1.setOnClickListener(this);
            fl.addView(iv1);
        }
    }
    @Override
    public void onClick(View view) {
        // TODO Auto-generated method stub
        ImageView iv=(ImageView)view;
        FrameLayout.LayoutParams l=(FrameLayout.LayoutParams)
                iv.getLayoutParams();
        l.setMargins(l.leftMargin, l.topMargin-10, l.rightMargin,
                l.bottomMargin);
        iv.setLayoutParams(l);
    }
}