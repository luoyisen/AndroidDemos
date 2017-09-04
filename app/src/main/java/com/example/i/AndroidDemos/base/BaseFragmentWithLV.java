package com.example.i.AndroidDemos.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;

import com.example.i.AndroidDemos.R;

/**
 * Created by I on 2017/9/3.
 */

public class BaseFragmentWithLV extends BaseFragment {
    public ListView listView;
    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_base_withlv;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = (ListView) view.findViewById(R.id.lv_basefragment);
    }
}
