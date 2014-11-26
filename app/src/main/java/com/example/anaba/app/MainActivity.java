package com.example.anaba.app;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.astuetz.PagerSlidingTabStrip;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        FragmentManager manager = getSupportFragmentManager();

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        final MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(manager);
        pager.setAdapter(adapter);

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setIndicatorColor(Color.parseColor("#fe884b"));
        tabs.setViewPager(pager);
    }


}


