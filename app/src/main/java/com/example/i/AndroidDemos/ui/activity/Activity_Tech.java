package com.example.i.AndroidDemos.ui.activity;

import android.content.Intent;
import android.view.View;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.base.BaseActivity;
import com.example.i.AndroidDemos.basicPoint.intentservice.ActivityIntentService;
import com.example.i.AndroidDemos.view.widget.AutoTypefaceTextView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by HHX on 2018/3/13.
 */

public class Activity_Tech extends BaseActivity {
    @BindView(R.id.intentservice)
    AutoTypefaceTextView intentservice;

    @Override
    protected void initView() {

    }

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_tech;
    }

    @OnClick({R.id.intentservice})
    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.intentservice:
                startActivity(new Intent(this, ActivityIntentService.class));
                break;
        }
    }
}
