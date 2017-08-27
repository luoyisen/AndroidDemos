package com.example.i.observerpatterndemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;

import com.example.i.observerpatterndemo.R;

/**
 * Created by I on 2017/8/26.
 */

public class BaseActivityWithLL extends BaseActivity {
    public FragmentManager fragmentManager;
    public static String currentItemTag = null;

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_base_withll;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().findFragmentByTag("fragment_root").getUserVisibleHint() == true) {
            finish();
        } else {
            getSupportFragmentManager().beginTransaction().hide(getSupportFragmentManager().findFragmentByTag(currentItemTag)).show(getSupportFragmentManager().findFragmentByTag("fragment_root")).commit();
            getSupportFragmentManager().findFragmentByTag("fragment_root").setUserVisibleHint(true);//因为show()和hide()方法不走Fragment的生命周期，所以需要手动设置
        }
    }
}
