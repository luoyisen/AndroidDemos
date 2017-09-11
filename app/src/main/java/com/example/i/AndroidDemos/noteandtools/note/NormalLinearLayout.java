package com.example.i.AndroidDemos.noteandtools.note;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by I on 2017/9/9.
 */

public class NormalLinearLayout extends LinearLayout {
    public NormalLinearLayout(Context context) {
        super(context);
    }

    public NormalLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NormalLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("事件传递机制","container dispatchTouchEvent ");

        Toast.makeText(getContext(), "container dispatchTouchEvent", Toast.LENGTH_SHORT).show();
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("事件传递机制","container onInterceptTouchEvent ");
        Toast.makeText(getContext(), "container onInterceptTouchEvent", Toast.LENGTH_SHORT).show();

        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("事件传递机制","container ACTION_DOWN ");

                Toast.makeText(getContext(), "container ACTION_DOWN", Toast.LENGTH_SHORT).show();
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("事件传递机制","container ACTION_MOVE ");

                Toast.makeText(getContext(), "container ACTION_MOVE", Toast.LENGTH_SHORT).show();
                break;
            case MotionEvent.ACTION_UP:
                Log.e("事件传递机制","container ACTION_UP ");

                Toast.makeText(getContext(), "container ACTION_UP", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onTouchEvent(event);
    }
}
