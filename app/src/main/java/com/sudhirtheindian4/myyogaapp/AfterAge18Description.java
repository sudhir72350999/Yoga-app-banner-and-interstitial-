package com.sudhirtheindian4.myyogaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AfterAge18Description extends AppCompatActivity {
    String buttonvalue;
    Button startbtn;
    private CountDownTimer countDownTimer;
    TextView stringtext;
    private  boolean timeRunning;
    private  long timeLeftInMilliseconds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_age18_description);
        Intent intent = getIntent();
        buttonvalue = intent.getStringExtra("value");
        int intvalue = Integer.valueOf(buttonvalue);


        switch (intvalue){

            case 1:
                setContentView(R.layout.activity_p1);
                break;

            case 2:
                setContentView(R.layout.activity_p2);
                break;

            case 3:
                setContentView(R.layout.activity_p3);
                break;

            case 4:
                setContentView(R.layout.activity_p4);
                break;

            case 5:
                setContentView(R.layout.activity_p5);
                break;

            case 6:
                setContentView(R.layout.activity_p6);
                break;

            case 7:
                setContentView(R.layout.activity_p7);
                break;

            case 8:
                setContentView(R.layout.activity_p8);
                break;

            case 9:
                setContentView(R.layout.activity_p9);
                break;

            case 10:
                setContentView(R.layout.activity_p10);
                break;

            case 11:
                setContentView(R.layout.activity_p11);
                break;

            case 12:
                setContentView(R.layout.activity_p12);
                break;

            case 13:
                setContentView(R.layout.activity_p13);
                break;

            case 14:
                setContentView(R.layout.activity_p14);
                break;

            case 15:
                setContentView(R.layout.activity_p15);
                break;


            case 16:
                setContentView(R.layout.activity_p16);
                break;
            case 17:
                setContentView(R.layout.activity_p17);
                break;
            case 18:
                setContentView(R.layout.activity_p18);
                break;
            case 19:
                setContentView(R.layout.activity_p19);
                break;
            case 20:
                setContentView(R.layout.activity_p20);
                break;

            case 21:
                setContentView(R.layout.activity_p21);
                break;

            case 22:
                setContentView(R.layout.activity_p22);
                break;
            case 23:
                setContentView(R.layout.activity_p23);
                break;
            case 24:
                setContentView(R.layout.activity_p24);
                break;
            case 25:
                setContentView(R.layout.activity_p25);
                break;
            case 26:
                setContentView(R.layout.activity_p26);
                break;
            case 27:
                setContentView(R.layout.activity_p27);
                break;
            case 28:
                setContentView(R.layout.activity_p28);
                break;
            case 29:
                setContentView(R.layout.activity_p29);
                break;
            case 30:
                setContentView(R.layout.activity_p30);
                break;





        }


        startbtn = findViewById(R.id.start);
        stringtext = findViewById(R.id.time);

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(timeRunning){
                    stopTimer();
                }
                else {

                    startTimer();

                }
            }
        });



    }

    private  void stopTimer(){
        countDownTimer.cancel();
        timeRunning =false;
        startbtn.setText("START");

    }

    private void  startTimer(){
        final  CharSequence value1 = stringtext.getText();
        String num1 = value1.toString();
        String num2 = num1.substring(0,2);
        String num3 = num1.substring(3,5);

//        final  int number = Integer.valueOf(num2)* 60+Integer.valueOf(num3);   /// we can chane 60 to 120  fo two minute
        final  int number = Integer.valueOf(num2)* 60+ Integer.valueOf(num3);   /// we can chane 60 to 120  fo two minute
        timeLeftInMilliseconds = number*1000;

        countDownTimer= new CountDownTimer(timeLeftInMilliseconds,1000) {
            @Override
            public void onTick(long millisunitsfinished) {
                timeLeftInMilliseconds=millisunitsfinished;
                updateTimer();

            }

            @Override
            public void onFinish() {
                int newvalue = Integer.valueOf(buttonvalue)+1;

                if(newvalue<=7){
                    Intent intent = new Intent(AfterAge18Description.this,AfterAge18Description.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);
                }
                else {
                    newvalue=1;
                    Intent intent = new Intent(AfterAge18Description.this,BeforeAge18Description.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);


                }


            }
        }.start();
        startbtn.setText("PAUSE");
        timeRunning =true;

    }

    private  void updateTimer(){
        int minutes = (int) timeLeftInMilliseconds/60000;
        int seconds = (int) timeLeftInMilliseconds%60000 /1000;

        String timeLeftText ="";
        if(minutes<10)
            timeLeftText="0";
        timeLeftText = timeLeftText+minutes+":";
        if(seconds<10)
            timeLeftText+="0";
//            timeLeftText= timeLeftText+ seconds;
        timeLeftText+= seconds;
        stringtext.setText(timeLeftText);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent = new Intent(AfterAge18Description.this,AfterAge18.class);
        startActivity(intent);
    }

}
