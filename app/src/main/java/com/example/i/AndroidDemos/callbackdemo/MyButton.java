package com.example.i.AndroidDemos.callbackdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.Button;

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
        this.onMyClickListener = onMyClickListener;
    }

    public interface OnMyClickListener {
        public void onMyClick(Button button);
    }

    public void doWork() {
        onMyClickListener.onMyClick(this);
    }
}
