package com.example.i.AndroidDemos.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.base.BaseActivityWithLL;
import com.example.i.AndroidDemos.ui.fragment.FragmentNet;

/**
 * Created by I on 2017/8/25.
 */

public class ActivityNet extends BaseActivityWithLL {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentNet fragmentNet = new FragmentNet();
        getSupportFragmentManager().beginTransaction().add(R.id.container_ll, fragmentNet, "fragment_root").commit();
    }
}
