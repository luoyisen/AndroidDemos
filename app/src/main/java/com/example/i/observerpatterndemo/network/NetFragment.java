package com.example.i.observerpatterndemo.network;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.i.observerpatterndemo.adapter.BaseRVAdapter;
import com.example.i.observerpatterndemo.base.BaseFragmentWithRV;
import com.example.i.observerpatterndemo.network.socketdemo.SocketDemoActivity;

import java.util.ArrayList;

/**
 * Created by I on 2017/8/26.
 */

public class NetFragment extends BaseFragmentWithRV {
    ArrayList arrayList;
    public BaseRVAdapter adapter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("a");
        arrayList.add("a");
        adapter = new BaseRVAdapter(arrayList, getActivity().getClass().getSimpleName());
        rv_base_fragment.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseRVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(getActivity(), SocketDemoActivity.class));
                        break;
                }
            }

            @Override
            public void onItemLongClick(View view, int pisition) {

            }
        });
    }
}
