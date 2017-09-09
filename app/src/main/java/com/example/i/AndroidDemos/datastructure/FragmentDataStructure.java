package com.example.i.AndroidDemos.datastructure;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.i.AndroidDemos.adapter.BaseRVAdapter;
import com.example.i.AndroidDemos.base.BaseFragmentWithRV;
import com.example.i.AndroidDemos.datastructure.fragmentlinkedlist.FragmentLinkedList;

import java.util.ArrayList;

/**
 * Created by I on 2017/9/6.
 */

public class FragmentDataStructure extends BaseFragmentWithRV {
    ArrayList arrayList;
    FragmentLinkedList fragmentLinkedList;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentLinkedList = new FragmentLinkedList();
        arrayList = new ArrayList();
        arrayList.add("LinkedList");
        adapter = new BaseRVAdapter(arrayList, getActivity().getClass().getSimpleName());
        rv_base_fragment.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseRVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        displayFragment(fragmentLinkedList, "fragmentLinkedList0");
                        if (myListener != null) {
                            myListener.sendContent("fragmentLinkedList0");
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
