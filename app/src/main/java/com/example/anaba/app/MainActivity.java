package com.example.anaba.app;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();

        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);

        final TestFragmentPagerAdapter adapter =
                new TestFragmentPagerAdapter(manager);
        viewPager.setAdapter(adapter);
    }


}


