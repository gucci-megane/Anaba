package com.example.anaba.app;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;

/**
 * Created by gucci on 2014/11/08.
 */
public class TestFragmentPagerAdapter extends FragmentPagerAdapter {

    public TestFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new SampleFragment();
            case 1:
                return new SampleFragment();
            default:
                return new SampleFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + (position+1);
    }
}