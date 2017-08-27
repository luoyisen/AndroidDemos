package com.example.i.AndroidDemos.noteandtools.tools;

import android.os.Bundle;

import com.example.i.AndroidDemos.base.BaseActivityWithLL;

import org.jetbrains.annotations.Nullable;

/**
 * Created by I on 2017/8/27.
 */

public class ActivityTools extends BaseActivityWithLL {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //因为baseActivityWithRecyclerView已经设置了布局文件，不用再次setcontentview
//        fragmentInterreact = new FragmentInterreact();
//        fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().add(R.id.container_ll, fragmentInterreact, "fragment_root").commit();//// TODO: 2017/8/26 通过tag来识别是哪个fragment
    }
}
