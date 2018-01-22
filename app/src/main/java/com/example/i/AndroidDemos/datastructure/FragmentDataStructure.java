package com.example.i.AndroidDemos.datastructure;

import android.app.AlertDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.adapter.BaseRVAdapter;
import com.example.i.AndroidDemos.base.BaseFragmentWithRV;
import com.example.i.AndroidDemos.datastructure.fragments.FragmentHashMap;
import com.example.i.AndroidDemos.datastructure.fragments.FragmentHashSet;
import com.example.i.AndroidDemos.datastructure.fragments.FragmentLinkedList;

import java.util.ArrayList;

/***
 * Created by I on 2017/9/6.
 */

public class FragmentDataStructure extends BaseFragmentWithRV {
    private FragmentLinkedList fragmentLinkedList;
    private FragmentHashSet fragmentHashSet;
    private FragmentHashMap fragmentHashMap;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentLinkedList = new FragmentLinkedList();
        fragmentHashSet = new FragmentHashSet();
        fragmentHashMap = new FragmentHashMap();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Set");
        arrayList.add("HashSet");
        arrayList.add("list");
        arrayList.add("arraylist");
        arrayList.add("LinkedList");
        arrayList.add("LinkedArrayList");
        arrayList.add("map");
        arrayList.add("hashmap");
        arrayList.add("LinkedHashmap");
        adapter = new BaseRVAdapter(arrayList, getActivity().getClass().getSimpleName());
        rv_base_fragment.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseRVAdapter.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        AlertDialog.Builder builder0 = new AlertDialog.Builder(getActivity());
                        builder0.setIcon(R.drawable.leak_canary_icon)
                                .setTitle("Set")
                                .setMessage("Set是一个接口\n" +
                                        "在Alertdialog中如果不设置settitle，那么seticon不会生效")
                                .create()
                                .show();
                        break;
                    case 1:
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                        builder1.setView(R.layout.dialog_hashset)
                                .create()
                                .show();
                        displayFragment(fragmentHashSet, "fragmentset0");
                        if (myListener != null) {
                            myListener.sendContent("fragmentset0");
                        }
                        break;

                    case 3:
                        displayFragment(fragmentLinkedList, "fragmentLinkedList0");
                        if (myListener != null) {
                            myListener.sendContent("fragmentLinkedList0");
                        }
                        break;
                    case 6:
                        AlertDialog.Builder builder6 = new AlertDialog.Builder(getActivity());
                        builder6.setIcon(R.drawable.leak_canary_icon)
                                .setTitle("Map")
                                .setMessage("Map跟Set一样，也是一个接口")
                                .create()
                                .show();
                        break;
                    case 7:
                        displayFragment(fragmentHashMap, "fragmenthashmap0");
                        if (myListener != null) {
                            myListener.sendContent("fragmenthashmap0");
                        }
                        break;
                }
            }

            @Override
            public void onItemLongClick(View view, int pisition) {
            }
        });

    }
}
