package com.example.i.AndroidDemos.presentation.presenter;

import com.tellh.nolistadapter.adapter.RecyclerViewAdapter;

/***
 * Created by I on 2017/9/24.
 */

public interface IUserListPresenter {
    void getUserInfo(int position, RecyclerViewAdapter adapter);

    void followUser(int position, RecyclerViewAdapter adapter, boolean toggle);

}