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


    //各タブのフラグメントの追加編集はここで
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return CheckInCardFragment.newInstance(position);
            case 1:
                return AnabaListCardFragment.newInstance(position);
            case 2:
                return CommunicationCardFragment.newInstance(position);
            case 3:
                return MyPageCardFragment.newInstance(position);
            default:
                return SettingCardFragment.newInstance(position);
        }
    }

    //タブの個数の変更はここで
    @Override
    public int getCount() {
        return 5;
    }

    //タブの名前の変更はここで
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0:
                return "Check-In";
            case 1:
                return "anaba List";
            case 2:
                return "通信";
            case 3:
                return "My page";
            default:
                return "設定";
        }
    }
}