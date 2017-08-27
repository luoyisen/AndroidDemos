package com.example.i.AndroidDemos.network;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.example.i.AndroidDemos.adapter.BaseRVAdapter;
import com.example.i.AndroidDemos.base.BaseFragmentWithRV;
import com.example.i.AndroidDemos.network.Rxdemo.FragmentDoubanTop250;
import com.example.i.AndroidDemos.network.socketdemo.FragmentSocketChat;

import java.util.ArrayList;

/**
 * Created by I on 2017/8/26.
 */

public class FragmentNet extends BaseFragmentWithRV {
    ArrayList arrayList;
    public BaseRVAdapter adapter;

    FragmentSocketChat chat;
    FragmentDoubanTop250 doubanTop250;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        chat = new FragmentSocketChat();
        doubanTop250 = new FragmentDoubanTop250();
        arrayList = new ArrayList<>();
        arrayList.add("Socket Chat");
        arrayList.add("a");
        arrayList.add("a");
        adapter = new BaseRVAdapter(arrayList, getActivity().getClass().getSimpleName());
        rv_base_fragment.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseRVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        displayFragment(chat, this.toString());
                        if (myListener != null) {
                            myListener.sendContent(this.toString());
                        }
                        Log.e("hahahah", this.toString());
                        break;
                    case 1:
                        displayFragment(doubanTop250, this.toString());
                        if (myListener != null) {
                            myListener.sendContent(this.toString());
                        }
                        Log.e("hahahah", this.toString());
                        break;
                }
            }

            @Override
            public void onItemLongClick(View view, int pisition) {

            }
        });
    }
}
