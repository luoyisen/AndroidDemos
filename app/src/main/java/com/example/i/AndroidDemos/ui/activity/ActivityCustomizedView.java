package com.example.i.AndroidDemos.ui.activity;

import android.os.Bundle;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.base.BaseActivity;
import com.example.i.AndroidDemos.base.BaseActivityWithLL;
import com.example.i.AndroidDemos.view.widget.FragmentCustomizedView;

import org.jetbrains.annotations.Nullable;

/***
 * Created by I on 2017/8/29.
 */

public class ActivityCustomizedView extends BaseActivity {
    FragmentCustomizedView fragmentCustomizedView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentCustomizedView = new FragmentCustomizedView();
//        fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().add(R.id.container_ll, fragmentCustomizedView, "fragment_root").commit();
    }

    @Override
    protected void initView() {

    }

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_customizedview;
    }
}
