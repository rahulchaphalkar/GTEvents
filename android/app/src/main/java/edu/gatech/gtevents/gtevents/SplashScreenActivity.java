package edu.gatech.gtevents.gtevents;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import edu.gatech.gtevents.gtevents.feedscreen.FeedScreenActivity;

/**
 * Simple splash screen activity.
 */
public class SplashScreenActivity extends AppCompatActivity {

    private static final int TIME_DELAY = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, FeedScreenActivity.class);
                SplashScreenActivity.this.startActivity(intent);
                SplashScreenActivity.this.finish();
            }
        }, TIME_DELAY);
    }
}
