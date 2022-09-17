package com.sudhirtheindian4.myyogaapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class BeforeAge18Description extends AppCompatActivity {

    String buttonvalue;
    Button startbtn;
    private CountDownTimer countDownTimer;
    TextView stringtext;
    private  boolean timeRunning;
    private  long timeLeftInMilliseconds;

    private InterstitialAd mInterstitialAd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_age18_description);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });

        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i(TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.d(TAG, loadAdError.toString());
                        mInterstitialAd = null;
                    }
                });


        Intent intent = getIntent();
        buttonvalue = intent.getStringExtra("value");
        int intvalue = Integer.valueOf(buttonvalue);


        switch (intvalue){

            case 1:
                setContentView(R.layout.activity_pose1);
                break;

            case 2:
                setContentView(R.layout.activity_pose2);
                break;

            case 3:
                setContentView(R.layout.activity_pose3);
                break;

            case 4:
                setContentView(R.layout.activity_pose4);
                break;

            case 5:
                setContentView(R.layout.activity_pose5);
                break;

            case 6:
                setContentView(R.layout.activity_pose6);
                break;

            case 7:
                setContentView(R.layout.activity_pose7);
                break;

            case 8:
                setContentView(R.layout.activity_pose8);
                break;

            case 9:
                setContentView(R.layout.activity_pose9);
                break;

            case 10:
                setContentView(R.layout.activity_pose10);
                break;

            case 11:
                setContentView(R.layout.activity_pose11);
                break;

            case 12:
                setContentView(R.layout.activity_pose12);
                break;

            case 13:
                setContentView(R.layout.activity_pose13);
                break;

            case 14:
                setContentView(R.layout.activity_pose14);
                break;

            case 15:
                setContentView(R.layout.activity_pose15);
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
                    Intent intent = new Intent(BeforeAge18Description.this,BeforeAge18Description.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);
                }
                else {
                    newvalue=1;
                    Intent intent = new Intent(BeforeAge18Description.this,BeforeAge18Description.class);
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
        Intent intent = new Intent(BeforeAge18Description.this,BeforeAge18.class);
        startActivity(intent);
        finish();

        if (mInterstitialAd != null) {

            mInterstitialAd.show(BeforeAge18Description.this);
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
        }
    }
}