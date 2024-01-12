package com.sudhirtheindian4.myyogaapp;
import static com.sudhirtheindian4.myyogaapp.R.*;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

//import com.google.android.gms.ads.AdListener;
//import com.google.android.gms.ads.AdLoader;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.MobileAds;
//import com.google.android.gms.ads.formats.UnifiedNativeAd;
//import com.google.android.gms.ads.formats.NativeAd;
//import com.google.android.gms.ads.initialization.InitializationStatus;
//import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
//import com.google.android.gms.ads.nativead.MediaView;
//import com.google.android.gms.ads.nativead.NativeAd;
//import com.google.android.gms.ads.nativead.NativeAdOptions;
//import com.google.android.gms.ads.nativead.NativeAdView;

public class BeforeAge18 extends AppCompatActivity {
    int[] newArray;

//    private AdView mAdView, mAdView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_before_age18);
        Toolbar toolbar = findViewById(id.toolbar);

        setSupportActionBar(toolbar);
        newArray = new int[]{
                id.pose1,
                id.pose2,
                id.pose3,
                id.pose4,
                id.pose5,
                id.pose6,
                id.pose7,
                id.pose8,
                id.pose9,
                id.pose10,
                id.pose11,
                id.pose12,
                id.pose13,
                id.pose14,
                id.pose15
        };

/*
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView2 = findViewById(id.adView2);
        AdRequest adRequest2 = new AdRequest.Builder().build();
        mAdView2.loadAd(adRequest2);



*/
    }

    public void imagebuttonclicked(View view) {

        for (int i = 0; i < newArray.length; i++) {
            if (view.getId() == newArray[i]) {
                int value = i + 1;
                Log.i("FIRST", String.valueOf(value));
                Intent intent = new Intent(BeforeAge18.this, BeforeAge18Description.class);
                intent.putExtra("value", String.valueOf(value));
                startActivity(intent);
            }

        }
    }

        @Override
        public void onBackPressed () {
            Intent intent = new Intent(BeforeAge18.this, MainActivity.class);
            startActivity(intent);
//        super.onBackPressed();
        }
    }
