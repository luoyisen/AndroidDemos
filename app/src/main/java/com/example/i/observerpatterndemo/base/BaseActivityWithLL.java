package com.example.i.observerpatterndemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.i.observerpatterndemo.R;

/**
 * Created by I on 2017/8/26.
 *
 */

public class BaseActivityWithLL extends BaseActivity {

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_base_withll;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
