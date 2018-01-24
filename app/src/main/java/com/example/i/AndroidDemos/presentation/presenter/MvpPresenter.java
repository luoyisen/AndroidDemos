package com.example.i.AndroidDemos.presentation.presenter;

import com.example.i.AndroidDemos.base.BaseView;

/***
 * Created by I on 2017/9/24.
 */

public interface MvpPresenter<V extends BaseView> {
    void attachView(V view);

    void detachView();
}