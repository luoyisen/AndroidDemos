package com.example.i.observerpatterndemo.Interreactcomponent.FragmentToActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.i.observerpatterndemo.adapter.BaseRVAdapter;
import com.example.i.observerpatterndemo.base.BaseFragmentWithRV;

import java.util.ArrayList;

/**
 * Created by I on 2017/8/26.
 */

public class FragmentInterreact extends BaseFragmentWithRV {
    private boolean isfirstclickback;
    ArrayList arrayList;
    public BaseRVAdapter adapter;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        arrayList = new ArrayList();
        arrayList.add("接口实现Fragment和包含该Fragment的Activity通信 \n" +
                "(仅限于该Fragment和包含它的Activity之间)");
        arrayList.add("Activity之间通过startActivityForResult()方法通信");
        arrayList.add("Csfasfsfasdf");
        adapter = new BaseRVAdapter(arrayList, getActivity().getClass().getSimpleName());
        rv_base_fragment.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseRVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }

            @Override
            public void onItemLongClick(View view, int pisition) {

            }
        });
//        adapter.setOnItemClickListener(new BaseRVAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                isfirstclickback = true;
//                switch (position) {
//                    case 0:
//                        // TODO: 2017/8/24  为什么transaction不能共用
//
//                        break;
//                    case 1:
//                        break;
//                }
//            }
////
//////            @Override
//////            public void onItemLongClick(View view, int pisition) {
//////                Toast.makeText(ComponentIntereactActivity.this, "触发长按", Toast.LENGTH_SHORT).show();
//////            }
//        });
    }
}
