package com.vonchenchen.usbmuxd_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends FragmentActivity {

    private static final String  TAG = "MainActivity";

    private Button mStartBtn;
    private Button mStopBtn;
    private Button mTestActivityBtn;

    private long mCurrentTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStartBtn = (Button) findViewById(R.id.btn_start);
        mStopBtn = (Button) findViewById(R.id.btn_stop);
        mTestActivityBtn = (Button) findViewById(R.id.btn_testActivity);

        mTestActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TestActivity.class);
                startActivity(intent);
            }
        });
    }

}
