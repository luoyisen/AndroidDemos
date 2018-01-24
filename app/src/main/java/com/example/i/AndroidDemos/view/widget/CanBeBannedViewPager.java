package com.example.i.AndroidDemos.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.example.i.AndroidDemos.R;

/***
 * Created by I on 2017/11/13.
 */

public class CanBeBannedViewPager extends ViewPager {
    private boolean canScroll;

    public CanBeBannedViewPager(Context context) {
        super(context);
    }

    public CanBeBannedViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CanBeBannedViewPager);
        canScroll = typedArray.getBoolean(R.styleable.CanBeBannedViewPager_isScroll, false);
        typedArray.recycle();
    }

    public void setCanScroll(boolean isCanScroll) {
        this.canScroll = isCanScroll;
    }

    public boolean ifCanScroll() {
        return canScroll;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return ifCanScroll() && super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ifCanScroll()) {
            return super.onInterceptTouchEvent(ev);
        }
        return false;
    }
}
