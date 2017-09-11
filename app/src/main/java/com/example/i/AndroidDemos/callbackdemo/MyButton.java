package com.example.i.AndroidDemos.callbackdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/***
 * Created by I on 2017/9/9.
 */

public class MyButton extends android.support.v7.widget.AppCompatButton {
    public OnMyClickListener onMyClickListener;

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnMyClickListener(OnMyClickListener onMyClickListener) {
//        if (!isClickable()) {
//            setClickable(true);
//        }
//        getListenerInfo().mOnClickListener = l;
        this.onMyClickListener = onMyClickListener;
    }


    public interface OnMyClickListener {
        void onMyClick(View view);
    }

    public void doWork() {
        onMyClickListener.onMyClick(this);
    }
}
