package com.example.i.AndroidDemos.noteandtools.note;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

import com.example.i.AndroidDemos.MyApplication;

/***
 * Created by I on 2017/9/6.
 */

public class MyButton extends android.support.v7.widget.AppCompatButton {
    public int dispatchMode;
    public int touchMode;

    public int getDispatchMode() {
        return dispatchMode;
    }

    public int getTouchMode() {
        return touchMode;
    }

    public void setDispatchMode(int dispatchTouchEventMode) {
        this.dispatchMode = dispatchTouchEventMode;
    }

    public void setTouchMode(int onTouchEventMode) {
        this.touchMode = onTouchEventMode;
    }

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("事件传递机制","button dispatchTouchEvent");
        int i = getDispatchMode();
        if (i == 0) {
            return super.dispatchTouchEvent(ev);
        } else if (i == 1) {
            return false;
        } else if (i == 2) {
            return true;
        } else
            return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int i = getTouchMode();
        if (i == 0) {
            processEvent(event);
            return super.onTouchEvent(event);
        } else if (i == 1) {
            processEvent(event);
            return false;
        } else if (i == 2) {
            processEvent(event);
            return true;
        } else
            return super.onTouchEvent(event);
    }

    public void processEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("事件传递机制","button ACTION_DOWN");
                Toast.makeText(MyApplication.getContext(), "BUTTON---ACTION_DOWN事件", Toast.LENGTH_SHORT).show();
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("事件传递机制","button ACTION_MOVE");

                Toast.makeText(MyApplication.getContext(), "BUTTON---ACTION_MOVE事件", Toast.LENGTH_SHORT).show();
                break;
            case MotionEvent.ACTION_UP:
                Log.e("事件传递机制","button ACTION_UP");

                Toast.makeText(MyApplication.getContext(), "BUTTON---ACTION_UP事件", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
