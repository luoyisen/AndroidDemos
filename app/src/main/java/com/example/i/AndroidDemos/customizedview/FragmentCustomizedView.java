package com.example.i.AndroidDemos.customizedview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.i.AndroidDemos.adapter.BaseRVAdapter;
import com.example.i.AndroidDemos.base.BaseFragmentWithRV;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/***
 * Created by I on 2017/8/29.
 */

public class FragmentCustomizedView extends BaseFragmentWithRV {
    ArrayList<String> arrayList = new ArrayList<>();

    private static class MyHandler extends Handler {
        private final WeakReference<FragmentCustomizedView> fragmentCustomizedViewWeakReference;

        MyHandler(FragmentCustomizedView fragmentCustomizedView) {
            fragmentCustomizedViewWeakReference = new WeakReference<FragmentCustomizedView>(fragmentCustomizedView);
        }

        @Override
        public void handleMessage(Message msg) {
            FragmentCustomizedView fragmentCustomizedView = fragmentCustomizedViewWeakReference.get();
            if (fragmentCustomizedView != null) {
                switch (msg.what) {
                    case 0:
                        break;
                }
            }
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        arrayList.add("随机生成一个四位数");
        arrayList.add("扇形进度盘");
        arrayList.add("时钟");
        arrayList.add("时钟2");
        arrayList.add("旋转的专辑封面");
        arrayList.add("Material进度条");
        arrayList.add("带数字的进度条");
        arrayList.add("倒计时");

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
                                .setCancelAble(false)
                                .create()
                                .show();
                        break;
                    case 1:
                        new DialogShowCustomizedView.Builder(getActivity())
                                .setTitle("试着用canvas.rotate()实现这个功能")
                                .setSpecifiedView(1)
                                .setCancelAble(false)
                                .create()
                                .show();
                        break;
                    case 2:
                        new DialogShowCustomizedView.Builder(getActivity())
                                .setTitle("根据系统时间显示在表盘上")
                                .setSpecifiedView(2)
                                .setCancelAble(false)
                                .create()
                                .show();
                        break;
                    case 3:
                        new DialogShowCustomizedView.Builder(getActivity())
                                .setTitle("根据系统时间显示在表盘上")
                                .setSpecifiedView(3)
                                .setCancelAble(false)
                                .create()
                                .show();
                        break;
                    case 4:
                        new DialogShowCustomizedView.Builder(getActivity())
                                .setTitle("旋转的专辑封面")
                                .setSpecifiedView(4)
                                .setCancelAble(false)
                                .create()
                                .show();
                        break;
                    case 5:
                        new DialogShowCustomizedView.Builder(getActivity())
                                .setTitle("Material进度条")
                                .setSpecifiedView(5)
                                .setCancelAble(false)
                                .create()
                                .show();
                        break;
                    case 6:
                        new DialogShowCustomizedView.Builder(getActivity())
                                .setTitle("带数字的进度条")
                                .setSpecifiedView(6)
                                .setCancelAble(false)
                                .create()
                                .show();
                        break;
                    case 7:
                        new DialogShowCustomizedView.Builder(getActivity())
                                .setTitle("数字倒计时")
                                .setSpecifiedView(7)
                                .setCancelAble(false)
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
