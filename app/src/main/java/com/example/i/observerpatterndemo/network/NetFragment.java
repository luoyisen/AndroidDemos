package com.example.i.observerpatterndemo.network;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.example.i.observerpatterndemo.adapter.BaseRVAdapter;
import com.example.i.observerpatterndemo.base.BaseFragmentWithRV;

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
        Toast.makeText(getActivity(), getActivity().getClass().getSimpleName(), Toast.LENGTH_SHORT).show();
        rv_base_fragment.setAdapter(adapter);
    }
}
