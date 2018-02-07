package com.example.i.AndroidDemos.ui.activity;

import android.content.Intent;
import android.view.View;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.base.BaseActivity;

import butterknife.OnClick;

/**
 * Created by HHX on 2018/2/6.
 */

public class ActivityUtilDemo extends BaseActivity {

    @Override
    protected void initView() {

    }

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_util_demo;
    }

    @OnClick({R.id.search_history})
    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.search_history:
                startActivity(new Intent(this,ActivitySearchHistoryDemo.class));
                break;
        }
    }
}
