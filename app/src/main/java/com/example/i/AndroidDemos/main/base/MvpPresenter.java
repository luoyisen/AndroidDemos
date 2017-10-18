package com.example.i.AndroidDemos.main.base;

/***
 * Created by I on 2017/9/24.
 */

public interface MvpPresenter<V extends BaseView> {
    void attachView(V view);

    void detachView();
}