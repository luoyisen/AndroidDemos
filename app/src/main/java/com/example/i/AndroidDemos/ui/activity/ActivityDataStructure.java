package com.example.i.AndroidDemos.ui.activity;

import android.os.Bundle;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.base.BaseActivityWithLL;
import com.example.i.AndroidDemos.ui.fragment.FragmentDataStructure;

import org.jetbrains.annotations.Nullable;

/***
 * Created by I on 2017/9/6.
 */

public class ActivityDataStructure extends BaseActivityWithLL {
    FragmentDataStructure fragmentDataStructure;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //因为baseActivityWithRecyclerView已经设置了布局文件，不用再次setcontentview
        fragmentDataStructure = new FragmentDataStructure();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.container_ll, fragmentDataStructure, "fragment_root").commit();//// TODO: 2017/8/26 通过tag来识别是哪个fragment
    }
}
