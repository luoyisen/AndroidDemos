package com.example.i.observerpatterndemo.network;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.i.observerpatterndemo.Interreactcomponent.FragmentToActivity.MyListener;
import com.example.i.observerpatterndemo.R;
import com.example.i.observerpatterndemo.base.BaseActivityWithLL;

/**
 * Created by I on 2017/8/25.
 */

public class ActivityNet extends BaseActivityWithLL implements MyListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentNet fragmentNet = new FragmentNet();
        getSupportFragmentManager().beginTransaction().add(R.id.container_ll, fragmentNet, "fragment_root").commit();
    }

    @Override
    public void sendContent(String tag) {
        if (tag != null && !("".equals(tag))) {
            currentItemTag = tag;//// TODO: 2017/8/27  所有的共同维护这个String值
            Toast.makeText(this, tag, Toast.LENGTH_SHORT).show();//TODO: 2017/8/26 用log查看sendContent是怎样调用的
        } else {
            Toast.makeText(this, "内容为空", Toast.LENGTH_SHORT).show();
        }
    }
}
