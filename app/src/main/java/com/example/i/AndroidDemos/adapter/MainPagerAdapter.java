package com.example.i.AndroidDemos.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/***
 * Created by I on 2017/11/13.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {
    private String[] titles;
    private Fragment[] fragments;

    public MainPagerAdapter(FragmentManager fragmentManager, String[] titles, Fragment[] fragments) {
        super(fragmentManager);
        this.titles = titles;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        if (titles == null) return 0;
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}

