package com.example.i.AndroidDemos.noteandtools;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.i.AndroidDemos.Interreactcomponent.FragmentToActivity.MyListener;
import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.base.BaseActivityWithLL;

/**
 * Created by I on 2017/8/26.
 */

public class ActivityNoteAndTools extends BaseActivityWithLL implements MyListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentNoteAndTools fragmentNoteAndTools = new FragmentNoteAndTools();
        getSupportFragmentManager().beginTransaction().add(R.id.container_ll, fragmentNoteAndTools, "fragment_root").commit();
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
