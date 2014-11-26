package com.example.anaba.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by gucci on 2014/11/08.
 */
public class MyFragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return CardFragment.newInstance(position);
            case 1:
                return CardFragment.newInstance(position);
            default:
                return CardFragment.newInstance(position);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0:
                return "Page " + (position+1);
            case 1:
                return "Page " + (position+1);
            default:
                return "Page " + (position+1);
        }
    }
}