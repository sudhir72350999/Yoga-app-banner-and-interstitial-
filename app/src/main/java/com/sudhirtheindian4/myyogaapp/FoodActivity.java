package com.sudhirtheindian4.myyogaapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;
public class FoodActivity extends AppCompatActivity {
    ListView listView;
//    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
//        mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
        listView = findViewById(R.id.list);
        String[] story_name = getResources().getStringArray(R.array.title_story);
        final String[] dstory = getResources().getStringArray(R.array.details_story);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.text_item,story_name);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String t = dstory[i];
                Intent intent = new Intent(FoodActivity.this,FoodActivityDetails.class);
                intent.putExtra("story",t);
                startActivity(intent);
            }
        });
//        String[] tstory = getResources().getStringArray(R.array.title_story);
//        final String[] dstory = getResources().getStringArray(R.array.details_story);
//
//        listView = findViewById(R.id.list);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.row,tstory);
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
////                String t = dstory[position];
//                Intent intent = new Intent(FoodActivity.this,FoodActivityDetails.class);
//                intent.putExtra("story",position);
//                startActivity(intent);
//            }
//        });
    }
    public void foodgoback(View view) {
        Intent intent = new Intent(FoodActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(FoodActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}