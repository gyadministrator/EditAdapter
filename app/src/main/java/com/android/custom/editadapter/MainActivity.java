package com.android.custom.editadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.gyf.immersionbar.ImmersionBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ImmersionBar immersionBar=ImmersionBar.with(this);
        //immersionBar.navigationBarColor(R.color.white);
        //immersionBar.init();
    }
}
