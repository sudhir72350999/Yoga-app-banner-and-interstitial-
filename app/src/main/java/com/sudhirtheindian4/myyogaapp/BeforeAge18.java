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

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
//import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeAdView;

public class BeforeAge18 extends AppCompatActivity {
    int[] newArray;

    private AdView mAdView, mAdView2;
//    private UnifiedNativeAd nativeAd;
//    private NativeAd nativeAd;

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

//
//        MobileAds.initialize(this, getString(string.ADMOB_ADS_UNIT_ID));
//        refreshAd();


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

//    private void populateUnifiedNativeAdView(UnifiedNativeAd nativeAd, NativeAdView adView) {
//        adView.setMediaView((MediaView) adView.findViewById(id.ad_media));
//        adView.setHeadlineView(adView.findViewById(id.ad_headline));
//        adView.setBodyView(adView.findViewById(id.ad_body));
//        adView.setCallToActionView(adView.findViewById(id.ad_call_to_action));
//        adView.setIconView(adView.findViewById(id.ad_app_icon));
//        adView.setPriceView(adView.findViewById(id.ad_price));
//        adView.setAdvertiserView(adView.findViewById(id.ad_advertiser));
//        adView.setStoreView(adView.findViewById(id.ad_store));
//        adView.setStarRatingView(adView.findViewById(id.ad_stars));
//        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());
//        adView.getMediaView().setMediaContent(nativeAd.getMediaContent());
//        if (nativeAd.getBody() == null) {
//            adView.getBodyView().setVisibility(View.INVISIBLE);
//        } else {
//            adView.getBodyView().setVisibility(View.VISIBLE);
//            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
//        }
//        if (nativeAd.getCallToAction() == null) {
//            adView.getCallToActionView().setVisibility(View.INVISIBLE);
//        } else {
//            adView.getCallToActionView().setVisibility(View.VISIBLE);
//            ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
//        }
//        if (nativeAd.getIcon() == null) {
//            adView.getIconView().setVisibility(View.GONE);
//        } else {
//            ((ImageView) adView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
//            adView.getIconView().setVisibility(View.VISIBLE);
//        }
//        if (nativeAd.getPrice() == null) {
//            adView.getPriceView().setVisibility(View.INVISIBLE);
//        } else {
//            adView.getPriceView().setVisibility(View.VISIBLE);
//            ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
//        }
//        if (nativeAd.getStore() == null) {
//            adView.getStoreView().setVisibility(View.INVISIBLE);
//        } else {
//            adView.getStoreView().setVisibility(View.VISIBLE);
//            ((TextView) adView.getStoreView()).setText(nativeAd.getStore());
//        }
//        if (nativeAd.getStarRating() == null) {
//            adView.getStarRatingView().setVisibility(View.INVISIBLE);
//        } else {
//            ((RatingBar) adView.getStarRatingView()).setRating(nativeAd.getStarRating().floatValue());
//            adView.getStarRatingView().setVisibility(View.VISIBLE);
//        }
//        if (nativeAd.getAdvertiser() == null) {
//            adView.getAdvertiserView().setVisibility(View.INVISIBLE);
//        } else {
//            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
//            adView.getAdvertiserView().setVisibility(View.VISIBLE);
//        }
//        adView.setNativeAd(nativeAd);
//    }


//    private void refreshAd() {
//        AdLoader.Builder builder = new AdLoader.Builder(this, getString(string.ADMOB_ADS_UNIT_ID));
//        builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
//            @Override
//            public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
//                if (nativeAd != null) {
//                    nativeAd.destroy();
//                }
//                nativeAd = NativeAd;
//                FrameLayout frameLayout = findViewById(id.fl_adplaceholder);
//                NativeAdView adView = (NativeAdView) getLayoutInflater().inflate(layout.ad_unified, null);
//                populateUnifiedNativeAdView(unifiedNativeAd, adView);
//                frameLayout.removeAllViews();
//                frameLayout.addView(adView);
//            }
//        });
//        NativeAdOptions adOptions = new NativeAdOptions.Builder().build();
//        builder.withNativeAdOptions(adOptions);
//        AdLoader adLoader = builder.withAdListener(new AdListener() {
//            @Override
//            public void onAdFailedToLoad(int i) {
//            }
//        }).build();
//        adLoader.loadAd(new AdRequest.Builder().build());
//    }

        @Override
        public void onBackPressed () {
            Intent intent = new Intent(BeforeAge18.this, MainActivity.class);
            startActivity(intent);
//        super.onBackPressed();
        }
    }
