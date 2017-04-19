package com.vonchenchen.usbmuxd_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lidechen on 3/24/17.
 */

public class SplashActivity extends FragmentActivity {

    private Timer mTimer = new Timer();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }

    @Override
    protected void onStop() {
        super.onStop();

        if(mTimer != null){
            mTimer.cancel();
            mTimer = null;
        }
    }
}
