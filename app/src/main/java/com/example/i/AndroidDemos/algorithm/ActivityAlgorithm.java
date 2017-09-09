package com.example.i.AndroidDemos.algorithm;

import android.os.Bundle;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.base.BaseActivityWithLL;

import org.jetbrains.annotations.Nullable;

/***
 * Created by I on 2017/9/7.
 */

public class ActivityAlgorithm extends BaseActivityWithLL {
    FragmentAlgorithm fragmentAlgorithm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentAlgorithm = new FragmentAlgorithm();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.container_ll, fragmentAlgorithm, "fragment_root").commit();
    }
}
