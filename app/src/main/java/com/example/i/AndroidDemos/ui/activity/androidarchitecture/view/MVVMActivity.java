package com.example.i.AndroidDemos.ui.activity.androidarchitecture.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.i.AndroidDemos.R;


/**
 * Created by HHX on 2018/3/9.
 */

public class MVVMActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_mvvm_main);
    }
}
