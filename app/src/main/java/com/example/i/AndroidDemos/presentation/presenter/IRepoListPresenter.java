package com.example.i.AndroidDemos.presentation.presenter;

import com.example.i.AndroidDemos.bean.RepositoryInfo;
import com.tellh.nolistadapter.adapter.RecyclerViewAdapter;

/***
 * Created by I on 2017/9/24.
 */

public interface IRepoListPresenter {
    interface OnGetRepoCallback {
        void onGet(RepositoryInfo repositoryInfo);
    }

    void checkState(int position, RecyclerViewAdapter adapter);

    void starRepo(int position, RecyclerViewAdapter adapter, boolean toggle);

    void watchRepo(int position, RecyclerViewAdapter adapter, boolean toggle);

    void forkRepo(int position, RecyclerViewAdapter adapter);

    void getRepoInfo(String owner, String name, OnGetRepoCallback callback);
}