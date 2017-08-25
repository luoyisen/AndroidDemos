package com.example.i.observerpatterndemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.i.observerpatterndemo.Interreactcomponent.InterreactDecoration;
import com.example.i.observerpatterndemo.R;
import com.example.i.observerpatterndemo.adapter.BaseRVAdapter;

/**
 * Created by I on 2017/8/25.
 */

public abstract class BaseActivityWithRV extends BaseActivity {
    public RecyclerView rv_base;  //必须为public，公用的
    public RecyclerView.LayoutManager mLayoutManager;
    public BaseRVAdapter adapter;


    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_base;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rv_base = (RecyclerView) findViewById(R.id.rv_baseacwithrv);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv_base.setLayoutManager(mLayoutManager);//必须设置
        rv_base.addItemDecoration(new InterreactDecoration(this, LinearLayoutManager.VERTICAL));
    }
}
