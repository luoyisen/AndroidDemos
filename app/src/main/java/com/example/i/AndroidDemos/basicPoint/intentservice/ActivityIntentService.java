package com.example.i.AndroidDemos.basicPoint.intentservice;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by HHX on 2018/3/13.
 */

public class ActivityIntentService extends BaseActivity {
    @BindView(R.id.showtext)
    TextView showtext;

    @Override
    protected void initView() {
        Intent intent1 = new Intent("com.yincheng.intentservice");
        intent1.setPackage("com.example.i.gitclub");
        Bundle bundle1 = new Bundle();
        bundle1.putString("taskName", "task1");
        intent1.putExtras(bundle1);
        startService(intent1);//第一次启动intent1

        Intent intent2 = new Intent("com.yincheng.intentservice");
        intent2.setPackage("com.example.i.gitclub");
        Bundle bundle2 = new Bundle();
        bundle2.putString("taskName", "task2");
        intent2.putExtras(bundle2);
        startService(intent2);//第一次启动intent2

        Intent intent3 = new Intent(this, MyIntentService.class);
        Bundle bundle3 = new Bundle();
        bundle3.putString("taskName", "task3");
        intent3.putExtras(bundle3);
        startService(intent3);//第一次启动intent3

        startService(intent1);//第二次启动intent1
    }

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_intentservice;
    }
}
