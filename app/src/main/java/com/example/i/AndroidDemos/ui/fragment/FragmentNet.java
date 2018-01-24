package com.example.i.AndroidDemos.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.i.AndroidDemos.adapter.BaseRVAdapter;
import com.example.i.AndroidDemos.base.BaseFragmentWithRV;

import java.util.ArrayList;

/**
 * Created by I on 2017/8/26.
 *
 */

public class FragmentNet extends BaseFragmentWithRV {
    ArrayList<String> arrayList;
    public BaseRVAdapter adapter;

    FragmentSocketChat chat;
    FragmentDoubanTop250 doubanTop250;
    FragmentHttp fragmentHttp;
    FragmentWallpapersByCategory fragmentWallpapersByCategory;
    FragmentCateroryWallpaper fragmentCateroryWallpaper;
    FragmentReposFromUser fragmentReposFromUser;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        chat = new FragmentSocketChat();
        doubanTop250 = new FragmentDoubanTop250();
        fragmentHttp = new FragmentHttp();
        fragmentWallpapersByCategory = new FragmentWallpapersByCategory();
        fragmentCateroryWallpaper = new FragmentCateroryWallpaper();
        fragmentReposFromUser = new FragmentReposFromUser();

        arrayList = new ArrayList<>();
        arrayList.add("Socket--ChatWithService");
        arrayList.add("Http--demo");
        arrayList.add("Http--doubanTop250");
        arrayList.add("Http--wallpapers");
        arrayList.add("retrofit--githubReposFromUser");
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
                    case 4:
                        displayFragment(fragmentReposFromUser, "FragmentNet4");
                        if (myListener != null) {
                            myListener.sendContent("FragmentNet4");
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
