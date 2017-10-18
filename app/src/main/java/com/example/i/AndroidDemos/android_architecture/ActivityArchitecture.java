package com.example.i.AndroidDemos.android_architecture;

import android.os.Bundle;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.base.BaseActivityWithLL;

/***
 * Created by I on 2017/9/1.
 */

public class ActivityArchitecture extends BaseActivityWithLL {
    FragmentArchitecture fragmentArchitecture;

    @Override
    protected void onCreate(@org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //因为baseActivityWithRecyclerView已经设置了布局文件，不用再次setcontentview
        fragmentArchitecture = new FragmentArchitecture();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.container_ll, fragmentArchitecture, "fragment_root").commit();//// TODO: 2017/8/26 通过tag来识别是哪个fragment
    }
}
