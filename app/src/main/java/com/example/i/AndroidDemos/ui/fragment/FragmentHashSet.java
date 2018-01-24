package com.example.i.AndroidDemos.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.i.AndroidDemos.R;

import java.util.HashSet;
import java.util.Set;

/***
 * Created by I on 2017/10/26.
 */

public class FragmentHashSet extends Fragment {
    /**
     * HashSet底层使用的HashMap实现的，底层使用HashMap保存数据。
     */
    Set<String> set;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_set, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("a");//重复操作，不会添加，set集合中还是只有两个值
    }
}
