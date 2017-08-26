package com.example.i.observerpatterndemo.network;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.i.observerpatterndemo.R;
import com.example.i.observerpatterndemo.base.BaseActivityWithLL;

/**
 * Created by I on 2017/8/25.
 */

public class NetWorkActivity extends BaseActivityWithLL {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NetFragment netFragment = new NetFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container_ll, netFragment).commit();
    }
}
