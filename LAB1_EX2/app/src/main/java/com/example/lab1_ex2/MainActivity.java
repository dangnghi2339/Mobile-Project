package com.example.lab1_ex2;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView txt_Time;
    private TextView txt_Num1;
    private TextView txt_Num2;
    private TextView txt_Result;
    private Button btn_false;
    private Button btn_true;
    private TextView txt_Status;

    private CountDownTimer countDownTimer;
    private int score = 0;
    private boolean isCorrectAnswer;
    private final Random random = new Random();
    private final Handler handler = new Handler(Looper.getMainLooper());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        txt_Time = (TextView) findViewById(R.id.txt_Time);
        txt_Num1 = (TextView) findViewById(R.id.txt_Num1);
        txt_Num2 = (TextView) findViewById(R.id.txt_Num2);
        txt_Result = (TextView) findViewById(R.id.txt_Result);
        btn_false = (Button) findViewById(R.id.btn_false);
        btn_true = (Button) findViewById(R.id.btn_true);
        txt_Status = (TextView) findViewById(R.id.txt_Status);

        btn_true.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(true);
            }
        });
        btn_false.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        startNewRound();
    }
    private void generateQuestion() {
        int num1 = random.nextInt(50);
        int num2 = random.nextInt(50);
        int realSum = num1 + num2;

        if (random.nextBoolean()) {
            txt_Result.setText("= " + realSum);
            isCorrectAnswer = true;
        } else {
            int fakeSum = realSum + random.nextInt(10) - 5;
            if (fakeSum == realSum) {
                fakeSum++;
            }
            txt_Result.setText("= " + fakeSum);
            isCorrectAnswer = false;
        }

        txt_Num1.setText(String.valueOf(num1));
        txt_Num2.setText(String.valueOf(num2));
    }
    private void startTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        countDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                txt_Time.setText("Time: " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                gameOver("Lose");
            }
        }.start();
    }
    private void startNewRound() {
        txt_Status.setVisibility(View.INVISIBLE); // Ẩn thông báo trạng thái
        btn_true.setEnabled(true); // Bật lại các nút
        btn_false.setEnabled(true);
        score = 0;
        generateQuestion();
        startTimer();
    }

    private void checkAnswer(boolean userAnswer) {
        countDownTimer.cancel();

        if (userAnswer == isCorrectAnswer) {
            score++;
            if (score >= 10) {
                gameOver("Win");
            } else {
                generateQuestion();
                startTimer();
            }
        } else {
            gameOver("Fail");
        }
    }
    private void gameOver(String status) {
        txt_Status.setText(status);
        txt_Status.setVisibility(View.VISIBLE);

        btn_true.setEnabled(false);
        btn_false.setEnabled(false);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startNewRound();
            }
        }, 2000);
    }
}