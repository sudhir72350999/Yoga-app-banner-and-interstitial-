package com.sudhirtheindian4.myyogaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.MobileAds;
//import com.google.android.gms.ads.initialization.InitializationStatus;
//import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class AfterAge18 extends AppCompatActivity {
    int[] newArray;

//    private AdView mAdView, mAdView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_age18);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        newArray = new int[]{
                R.id.pose1,
                R.id.pose2,
                R.id.pose3,
                R.id.pose4,
                R.id.pose5,
                R.id.pose6,
                R.id.pose7,
                R.id.pose8,
                R.id.pose9,
                R.id.pose10,
                R.id.pose11,
                R.id.pose12,
                R.id.pose13,
                R.id.pose14,
                R.id.pose15,
                R.id.pose16,
                R.id.pose17,
                R.id.pose18,
                R.id.pose19,
                R.id.pose20,
                R.id.pose21,
                R.id.pose22,
                R.id.pose23,
                R.id.pose24,
                R.id.pose25,
                R.id.pose26,
                R.id.pose27,
                R.id.pose28,
                R.id.pose29,
                R.id.pose30
        };

/*
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView2 = findViewById(R.id.adView2);
        AdRequest adRequest2 = new AdRequest.Builder().build();
        mAdView2.loadAd(adRequest2);

*/
    }

    public void imagebuttonclicked(View view) {

        for (int i = 0; i < newArray.length; i++) {
            if (view.getId() == newArray[i]) {
                int value = i + 1;
                Log.i("FIRST", String.valueOf(value));
                Intent intent = new Intent(AfterAge18.this, AfterAge18Description.class);
                intent.putExtra("value", String.valueOf(value));
                startActivity(intent);
            }

        }
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AfterAge18.this,MainActivity.class);
        startActivity(intent);
//        super.onBackPressed();
    }

}
