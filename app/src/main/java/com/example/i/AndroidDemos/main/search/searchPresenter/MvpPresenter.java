package com.example.i.AndroidDemos.main.search.searchPresenter;

import com.example.i.AndroidDemos.main.base.BaseView;

/***
 * Created by I on 2017/9/24.
 */

public interface MvpPresenter<V extends BaseView> {
    void attachView(V view);

    void detachView();
}
