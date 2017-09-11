package com.example.i.AndroidDemos.customizedview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.i.AndroidDemos.adapter.BaseRVAdapter;
import com.example.i.AndroidDemos.base.BaseFragmentWithRV;

import java.util.ArrayList;

/***
 * Created by I on 2017/8/29.
 */

public class FragmentCustomizedView extends BaseFragmentWithRV {
    ArrayList<String> arrayList = new ArrayList<>();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        arrayList.add("随机生成一个四位数");
        arrayList.add("扇形进度盘");
        arrayList.add("时钟");
        arrayList.add("时钟2");
        adapter = new BaseRVAdapter(arrayList, getActivity().getClass().getSimpleName());
        rv_base_fragment.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseRVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        new DialogShowCustomizedView.Builder(getActivity())
                                .setTitle("点击就生成随机数，点击dialog外部可取消显示")
                                .setSpecifiedView(0)
                                .setCancelAble(true)
                                .create()
                                .show();
                        break;
                    case 1:
                        new DialogShowCustomizedView.Builder(getActivity())
                                .setTitle("试着用canvas.rotate()实现这个功能")
                                .setSpecifiedView(1)
                                .setCancelAble(true)
                                .create()
                                .show();
                        break;
                    case 2:
                        new DialogShowCustomizedView.Builder(getActivity())
                                .setTitle("根据系统时间显示在表盘上")
                                .setSpecifiedView(2)
                                .setCancelAble(true)
                                .create()
                                .show();
                        break;
                    case 3:
                        new DialogShowCustomizedView.Builder(getActivity())
                                .setTitle("根据系统时间显示在表盘上")
                                .setSpecifiedView(3)
                                .setCancelAble(true)
                                .create()
                                .show();
                        break;
                }
            }

            @Override
            public void onItemLongClick(View view, int pisition) {

            }
        });
    }
}
