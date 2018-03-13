package com.example.i.AndroidDemos.ui.activity;


import android.content.Intent;
import android.view.View;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.base.BaseActivity;
import com.example.i.AndroidDemos.view.widget.FontTextView;

import butterknife.BindView;
import butterknife.OnClick;

/***
 * Created by I on 2017/9/6.
 */

public class ActivityDataStructure extends BaseActivity {


    @Override
    protected void initView() {
    }

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_datastructure;
    }

    @OnClick({R.id.hashmap})
    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.hashmap:
                startActivity(new Intent(this,ActivityHashMapTest.class));
                break;
        }
    }
}
