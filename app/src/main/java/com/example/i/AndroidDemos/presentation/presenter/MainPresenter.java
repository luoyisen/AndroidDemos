package com.example.i.AndroidDemos.presentation.presenter;

/**
 * Created by I on 2017/9/3dpager1.
 */

public interface MainPresenter {
    void onCreate();

    void onResume();

    void onItemClicked(int position);

    void onDestroy();

}
