package com.example.infotech.ifwallpaper;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;


public class splash1 extends Activity {
    MediaPlayer SplashSound1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        SplashSound1=MediaPlayer.create(getApplicationContext(),R.raw.splash_sound);
        SplashSound1.start();
        Thread chrono = new Thread() {
            public void run() {
                try {
                    sleep(9000);

                } catch (InterruptedException e) {
                    e.printStackTrace();

                } finally {
                    Intent i=new Intent("com.example.infotech.ifwallpaper.app");
                    startActivity(i);


                }
            }
        };
        chrono.start();
    }
    protected void onPause() {
        super.onPause();
        SplashSound1.release();
        finish();
    }
}
