package com.example.i.observerpatterndemo.network;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.i.observerpatterndemo.adapter.BaseRVAdapter;
import com.example.i.observerpatterndemo.base.BaseActivityWithRV;

import java.util.ArrayList;

/**
 * Created by I on 2017/8/25.
 */

public class NetWorkActivity extends BaseActivityWithRV {
    ArrayList arrayList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("a");
        arrayList.add("a");
        adapter = new BaseRVAdapter(arrayList, getClass().getSimpleName());
        rv_base.setAdapter(adapter);
    }

}
