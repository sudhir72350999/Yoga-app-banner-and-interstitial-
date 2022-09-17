package com.sudhirtheindian4.myyogaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Button getstarted1,getstarted2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getstarted1 = findViewById(R.id.getstarted1);
        getstarted2 = findViewById(R.id.getstarted2);

        getstarted1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,BeforeAge18.class));
                finish();
            }
        });

        getstarted2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AfterAge18.class));
                finish();
            }
        });


    }


    public void food(View view) {
        startActivity(new Intent(MainActivity.this,FoodActivity.class));
        finish();
    }

    public void beforeage18(View view) {
        startActivity(new Intent(MainActivity.this,BeforeAge18.class));
        finish();
    }

    public void afterage18(View view) {
        startActivity(new Intent(MainActivity.this,AfterAge18.class));
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.navigation_drawer, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.rate:
                Uri uri = Uri.parse("https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(this, "Unable to open \n " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.privacy_policy:
//                Intent intent1 = new Intent(MainActivity.this, PrivacyPolicy.class);
//                startActivity(intent1);
                Intent intent1 = new Intent(Intent.ACTION_VIEW,Uri.parse("https://pages.flycricket.io/all-gk-and-gs-fact/privacy.html"));
                startActivity(intent1);
                break;

            case R.id.share_me:
                Intent intent2 = new Intent(Intent.ACTION_SEND);
                intent2.setType("text/plain");
//                String value = "Download this Application Now : https://play.google.com/store/apps/details?id=com.sudhirtheindian4.class9mathncertsolution"; //here add &hl=en after play store link
                String value = "Download this Application Now : https://play.google.com/store/apps/details?id=com.sudhirtheindian4.class9thncertenglishsolutionoffline"; //here add &hl=en after play store link
//                String value = "Download this Application Now : https://play.google.com/store/apps/details?id=com.sudhirtheindian1.hindienglish"; //here add &hl=en after play store link
                intent2.putExtra(Intent.EXTRA_TEXT, value);
                startActivity(Intent.createChooser(intent2, "share me"));

                break;

            case R.id.more_useful_app:
                Uri uri1 = Uri.parse("https://play.google.com/store/apps/details?id=com.sudhirtheindian.allgkandgsfact");
//                Uri uri1 = Uri.parse("https://play.google.com/store/apps/details?id=com.sudhirtheindian1.hindienglish");
//                Uri uri1 = Uri.parse("https://play.google.com/store/apps/details?id=c"+getApplicationContext().getPackageName());
                Intent intent3 = new Intent(Intent.ACTION_VIEW, uri1);

                try {
                    startActivity(intent3);
                } catch (Exception e) {
                    Toast.makeText(this, "Unable to open \n " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.update_app:
//                Uri uri2 = Uri.parse("https://play.google.com/store/apps/details?id=com.sudhirtheindian4.class9mathncertsolution");
                Uri uri2 = Uri.parse("https://play.google.com/store/apps/details?id=com.sudhirtheindian4.class9thncertenglishsolutionoffline");

                Intent intent4 = new Intent(Intent.ACTION_VIEW, uri2);

                try {
                    startActivity(intent4);
                } catch (Exception e) {
                    Toast.makeText(this, "Unable to open \n " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.more_app:
//                Intent intent1 = new Intent(MainActivity.this, PrivacyPolicy.class);
//                startActivity(intent1);
                Intent intent5 = new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/developer?id=sudhir+prajapati"));
                startActivity(intent5);
                break;

//            https://play.google.com/store/apps/developer?id=sudhir+prajapati    /// all play store app  link


        }
        return true;

    }




    @Override
    public void onBackPressed() {


        new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.drawable.ic_baseline_warning_24)
                .setTitle("Exit")
                .setMessage("Are you sure you want to exit this app")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                }).setNeutralButton("Rate Us This App", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Uri uri = Uri.parse("https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        try {
                            startActivity(intent);
                        } catch (Exception e) {
                            Toast.makeText(MainActivity.this, "Unable to open \n " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
//                        Toast.makeText(MainActivity.this, "Rate Us This app", Toast.LENGTH_SHORT).show();
                    }



                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                }).show();
    }
}