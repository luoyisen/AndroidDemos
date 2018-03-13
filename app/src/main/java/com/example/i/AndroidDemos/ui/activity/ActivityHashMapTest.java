package com.example.i.AndroidDemos.ui.activity;

import android.view.View;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.base.BaseActivity;
import com.example.i.AndroidDemos.constant.bean.User;
import com.example.i.AndroidDemos.fundamental.datastructure.HashMapTest;
import com.example.i.AndroidDemos.util.Note;

import java.util.HashMap;

import butterknife.OnClick;

/**
 * Created by HHX on 2018/3/13.
 */

public class ActivityHashMapTest extends BaseActivity {
    HashMap<Integer, User> users = new HashMap<>();

    @Override
    public void init() {
        users.put(1, new User(21, "张三"));
        users.put(2, new User(24, "李四"));
        users.put(3, new User(23, "王五"));
    }

    @Override
    protected void initView() {

    }

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_hashmaptest;
    }

    @OnClick({R.id.hashmapsort})
    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.hashmapsort:
                HashMap<Integer, User> sortedHashMap = HashMapTest.sortUserByAge(users);
                Note.show(sortedHashMap.toString());
                break;
        }
    }
}
