package com.example.i.AndroidDemos.datastructure.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.base.BaseFragment;

import java.util.LinkedList;

/***
 * Created by I on 2017/9/6.
 */


public class FragmentLinkedList extends BaseFragment {
    LinkedList<String> stringLinkedList;//LinkedList类是双向列表,列表中的每个节点都包含了对前一个和后一个元素的引用.

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_linkedlist;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        stringLinkedList = new LinkedList<>();
        stringLinkedList.add("a");
        stringLinkedList.add("b");
        stringLinkedList.add("c");
        stringLinkedList.add("d");
        stringLinkedList.add("e");
        //获取链表的第一个和最后一个元素
        Toast.makeText(getActivity(), stringLinkedList.getFirst(), Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity(), stringLinkedList.getLast(), Toast.LENGTH_SHORT).show();
        //获取链表元素
        for (String s : stringLinkedList) {
            Log.e("linkedlist", s);
        }
        //从链表生成子表

    }
}
