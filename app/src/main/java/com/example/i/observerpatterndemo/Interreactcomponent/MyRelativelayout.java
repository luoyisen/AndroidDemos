package com.example.i.observerpatterndemo.Interreactcomponent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by I on 2017/8/23.
 */

public class MyRelativelayout extends RelativeLayout {

    public MyRelativelayout(Context context) {
        super(context);
    }

    public MyRelativelayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRelativelayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return false;//返回false，表示不分发事件
    }
}
