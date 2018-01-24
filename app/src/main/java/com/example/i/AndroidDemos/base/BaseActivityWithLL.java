package com.example.i.AndroidDemos.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.widget.Toast;

import com.example.i.AndroidDemos.base.listener.MyListener;
import com.example.i.AndroidDemos.ui.activity.MainActivity;
import com.example.i.AndroidDemos.R;

/***
 * Created by I on 2017/8/26.
 */

public class BaseActivityWithLL extends BaseActivity implements MyListener {
    public FragmentManager fragmentManager;
    public static String currentItemTag = null;
    public Toolbar toolbar_base;

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_base_withll;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar_base = (Toolbar) findViewById(R.id.toolbar_base);
        setSupportActionBar(toolbar_base);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getClass().getSimpleName());
        }
        getSupportActionBar().setElevation(50.5f);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().findFragmentByTag("fragment_root").getUserVisibleHint()) {
            finish();
        } else {
            getSupportFragmentManager().beginTransaction().hide(getSupportFragmentManager().findFragmentByTag(currentItemTag)).show(getSupportFragmentManager().findFragmentByTag("fragment_root")).commit();
            getSupportFragmentManager().findFragmentByTag("fragment_root").setUserVisibleHint(true);//因为show()和hide()方法不走Fragment的生命周期，所以需要手动设置
        }
    }

    @Override
    public void sendContent(String tag) {
        if (tag != null && !("".equals(tag))) {
            currentItemTag = tag;//// TODO: 2017/8/27  所有的共同维护这个String值
        } else {
            Toast.makeText(this, "内容为空", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MainActivity.drawerLayout.openDrawer(Gravity.START);
    }
}
