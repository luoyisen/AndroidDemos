package com.example.i.AndroidDemos.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/***
 * Created by I on 2017/8/23.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(setLayoutResourceId());
        getWindow().setBackgroundDrawable(null);
        ButterKnife.bind(this);
        initView();

    }

    public void init() {
    }

    protected abstract void initView();

    public abstract int setLayoutResourceId();
}
