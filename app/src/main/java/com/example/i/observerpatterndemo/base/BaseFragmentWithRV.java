package com.example.i.observerpatterndemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.i.observerpatterndemo.Interreactcomponent.InterreactDecoration;
import com.example.i.observerpatterndemo.R;
import com.example.i.observerpatterndemo.adapter.BaseRVAdapter;

/**
 * Created by I on 2017/8/26.
 */

public class BaseFragmentWithRV extends BaseFragment {
    public RecyclerView rv_base_fragment;  //必须为public，公用的
    public RecyclerView.LayoutManager mLayoutManager;
    public BaseRVAdapter adapter;

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_base_withrv;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv_base_fragment = (RecyclerView) getActivity().findViewById(R.id.rv_basefragment);
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv_base_fragment.setLayoutManager(mLayoutManager);//必须设置
        rv_base_fragment.addItemDecoration(new InterreactDecoration(getActivity(), LinearLayoutManager.VERTICAL));
    }
}
