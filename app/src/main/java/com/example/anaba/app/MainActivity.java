package com.example.anaba.app;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.squareup.otto.Subscribe;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_layout);

        FragmentManager manager = getSupportFragmentManager();

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        final MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(manager);
        pager.setAdapter(adapter);

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setIndicatorColor(Color.parseColor("#fe884b"));
        tabs.setViewPager(pager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Subscriberとして登録する
        BusHolder.get().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Subscriberの登録を解除する
        BusHolder.get().unregister(this);
    }

    @Subscribe
    public void subscribe(CheckInButtonClickEvent event) {
        Toast.makeText(this, event.message, Toast.LENGTH_LONG).show();
    }


}


