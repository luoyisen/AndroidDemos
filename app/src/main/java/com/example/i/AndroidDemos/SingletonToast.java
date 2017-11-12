package com.example.i.AndroidDemos;

import android.content.Context;
import android.widget.Toast;

/***
 * Created by I on 2017/11/11.
 */

public class SingletonToast extends Toast {// TODO: 2017/11/11 实现toast内容很快能改变

    private SingletonToast(Context context) {
        super(context);
    }

    private static class SingletonHolder {
        private static final SingletonToast INSTANCE = new SingletonToast(MyApplication.getContext());
    }

    public static SingletonToast getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
