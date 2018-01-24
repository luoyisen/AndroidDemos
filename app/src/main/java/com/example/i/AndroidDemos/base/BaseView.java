package com.example.i.AndroidDemos.base;

import android.content.Context;
import android.os.Bundle;

/***
 * Created by I on 2017/9/24.
 */

public interface BaseView {
    void showOnError(String s);

    void showOnLoading();

    void showOnSuccess();

    void initData(Bundle savedInstanceState);

    void initView();

    Context getViewContext();

}
