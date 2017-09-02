package com.example.i.AndroidDemos.network;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.i.AndroidDemos.adapter.BaseRVAdapter;
import com.example.i.AndroidDemos.base.BaseFragmentWithRV;
import com.example.i.AndroidDemos.network.Rxdemo.FragmentDoubanTop250;
import com.example.i.AndroidDemos.network.socketdemo.FragmentSocketChat;
import com.example.i.AndroidDemos.network.wallpaper.FragmentCateroryWallpaper;
import com.example.i.AndroidDemos.network.wallpaper.FragmentWallpapersByCategory;

import java.util.ArrayList;

/**
 * Created by I on 2017/8/26.
 */

public class FragmentNet extends BaseFragmentWithRV {
    ArrayList arrayList;
    public BaseRVAdapter adapter;

    FragmentSocketChat chat;
    FragmentDoubanTop250 doubanTop250;
    FragmentHttp fragmentHttp;
    FragmentWallpapersByCategory fragmentWallpapersByCategory;
    FragmentCateroryWallpaper fragmentCateroryWallpaper;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        chat = new FragmentSocketChat();
        doubanTop250 = new FragmentDoubanTop250();
        fragmentHttp = new FragmentHttp();
        fragmentWallpapersByCategory = new FragmentWallpapersByCategory();
        fragmentCateroryWallpaper = new FragmentCateroryWallpaper();
        arrayList = new ArrayList<>();
        arrayList.add("Socket--ChatWithService");
        arrayList.add("Http--demo");
        arrayList.add("Http--doubanTop250");
        arrayList.add("Http--wallpapers");
        adapter = new BaseRVAdapter(arrayList, getActivity().getClass().getSimpleName());
        rv_base_fragment.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseRVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        displayFragment(chat, "FragmentNet0");
                        if (myListener != null) {
                            myListener.sendContent("FragmentNet0");
                        }
                        break;
                    case 1:
                        displayFragment(doubanTop250, "FragmentNet1");
                        if (myListener != null) {
                            myListener.sendContent("FragmentNet1");
                        }
                        break;
                    case 2:
                        displayFragment(fragmentHttp, "FragmentNet2");
                        if (myListener != null) {
                            myListener.sendContent("FragmentNet2");
                        }
                        break;
                    case 3:
                        displayFragment(fragmentCateroryWallpaper, "FragmentNet3");
                        if (myListener != null) {
                            myListener.sendContent("FragmentNet3");
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
