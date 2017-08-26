package com.example.i.observerpatterndemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by I on 2017/8/24.
 */

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(setLayoutResourceId(), container, false);// 第三个参数必须为false  // TODO: 2017/8/26  第二第三个参数的意义 http://blog.csdn.net/u012702547/article/details/52628453
    }

    public abstract int setLayoutResourceId();

}
