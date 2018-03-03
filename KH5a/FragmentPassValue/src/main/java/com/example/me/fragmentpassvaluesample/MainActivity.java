package com.example.me.fragmentpassvaluesample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements BottomFragment.OnBottomSelectedListener{
   TopFragment mTf;
    BottomFragment mBf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTf=(TopFragment)getSupportFragmentManager().findFragmentById(R.id.topfragment);
        mBf=(BottomFragment)getSupportFragmentManager().findFragmentById(R.id.bottomfragment);
    }

    @Override
    public void onBottomSelected(String str) {
       mTf.setTv(str);
    }
}
