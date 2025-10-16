package com.example.lab02_ex2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button rutbai;
    ImageView labai1;
    ImageView labai2;
    ImageView labai3;
    TextView thongbao;
    int sonut = 0;
    int darut = 0;
    boolean batay = true;
    String chuoithongbao = "";
    ArrayList<String> cacladarut = new ArrayList<String>();
    int manghinhbai[][] = {
            {
                    R.drawable.b2fv,R.drawable.ace_of_hearts,R.drawable.two_of_hearts,R.drawable.three_of_hearts,
                    R.drawable.four_of_hearts,R.drawable.five_of_hearts,R.drawable.six_of_hearts,R.drawable.seven_of_hearts,R.drawable.eight_of_hearts,
                    R.drawable.nine_of_hearts,R.drawable.ten_of_hearts,R.drawable.jack_of_hearts2,R.drawable.queen_of_hearts2,R.drawable.king_of_hearts2
            },
            {
                    R.drawable.b2fv,R.drawable.ace_of_diamonds,R.drawable.two_of_diamonds,R.drawable.three_of_diamonds,R.drawable.four_of_diamonds,
                    R.drawable.five_of_diamonds,R.drawable.six_of_diamonds,R.drawable.seven_of_diamonds,R.drawable.eight_of_diamonds,R.drawable.nine_of_diamonds,
                    R.drawable.ten_of_diamonds, R.drawable.jack_of_diamonds2,R.drawable.queen_of_diamonds2,R.drawable.king_of_diamonds2
            },
            {
                    R.drawable.b2fv,R.drawable.ace_of_clubs,R.drawable.two_of_clubs,R.drawable.three_of_clubs,R.drawable.four_of_clubs,
                    R.drawable.five_of_clubs,R.drawable.six_of_clubs,R.drawable.seven_of_clubs,R.drawable.eight_of_clubs,R.drawable.nine_of_clubs,
                    R.drawable.ten_of_clubs, R.drawable.jack_of_clubs2,R.drawable.queen_of_clubs2,R.drawable.king_of_clubs2
            },
            {
                    R.drawable.b2fv,R.drawable.ace_of_spades,R.drawable.two_of_spades,R.drawable.three_of_spades,R.drawable.four_of_spades,
                    R.drawable.five_of_spades,R.drawable.six_of_spades,R.drawable.seven_of_spades,R.drawable.eight_of_spades,R.drawable.nine_of_spades,
                    R.drawable.ten_of_spades,R.drawable.jack_of_spades2,R.drawable.queen_of_spades2,R.drawable.king_of_spades2
            }};
    String mangtenbai[][]={
            {
                    "rong","ach chuon","hai chuon","ba chuon","bon chuon","nam chuon",
                    "sau chuon","bay chuon","tam chuon","chin chuon","muoi chuon","boi chuon",
                    "dam chuon","gia chuon"
            },
            {
                    "rong","ach ro","hai ro","ba ro","bon ro","nam ro","sau ro","bay ro",
                    "tam ro","chin ro","muoi ro","boi ro","dam ro","gia ro"
            },
            {
                    "rong","ach co","hai co","ba co","bon co","nam co","sau co","bay co",
                    "tam co","chin co","muoi co", "boi co","dam co","gia co"
            },
            {
                    "rong","ach bich","hai bich","ba bich","bon bich","nam bich",
                    "sau bich","bay bich","tam bich","chin bich","muoi bich",
                    "boi bich","dam bich","gia bich"
            }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rutbai = (Button)findViewById(R.id.rutbai);
        labai1 = (ImageView)findViewById(R.id.ivlabai1);
        labai2 = (ImageView)findViewById(R.id.ivlabai2);
        labai3 = (ImageView)findViewById(R.id.ivlabai3);
        thongbao = (TextView)findViewById(R.id.txtthongbao);
        rutbai.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(darut==0)
                {
                    darut = 0;sonut = 0;
                    batay=true; chuoithongbao="";
                    labai1.setImageResource(R.drawable.b2fv);
                    labai2.setImageResource(R.drawable.b2fv);
                    labai3.setImageResource(R.drawable.b2fv);
                    cacladarut.clear();
                }
                darut++;
                Random rd=new Random();
                int x,y;
                while(true)
                {
                    x=rd.nextInt(4);//0->3 (b-a+1)+a;
                    y=rd.nextInt(13)+1;//1->13
                    if(cacladarut.contains(mangtenbai[x][y]) == false)
                    {
                        cacladarut.add(mangtenbai[x][y]);
                        break;
                    }
                }
                if(y<11)
                    batay=false;
                if(darut==1)
                {
                    sonut+=(y<10)?y:0;
                    labai1.setImageResource(manghinhbai[x][y]);
                }
                else if(darut==2)
                {
                    sonut+=(y<10)?y:0;
                    labai2.setImageResource(manghinhbai[x][y]);
                }
                else if(darut==3)
                {
                    sonut+=(y<10)?y:0; int kq=sonut%10; darut=0;
                    labai3.setImageResource(manghinhbai[x][y]);
                    chuoithongbao+=" so nut la "+ kq;
                    //rutbai.setEnabled(false);
                }
                thongbao.setText("Cac la da rut" + cacladarut.toString() + chuoithongbao + "ba tay" + batay);
            }
        });
    }
}