package com.example.i.AndroidDemos.noteandtools.note;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

/**
 * Created by I on 2017/9/9.
 */

public class NormalButton extends android.support.v7.widget.AppCompatButton {
    public NormalButton(Context context) {
        super(context);
    }

    public NormalButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("事件传递机制","button dispatchTouchEvent");
        Toast.makeText(getContext(), "button dispatchTouchEvent", Toast.LENGTH_SHORT).show();
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("事件传递机制","button ACTION_DOWN");

                Toast.makeText(getContext(), "button ACTION_DOWN", Toast.LENGTH_SHORT).show();
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("事件传递机制","button ACTION_MOVE");

                Toast.makeText(getContext(), "button ACTION_MOVE", Toast.LENGTH_SHORT).show();
                break;
            case MotionEvent.ACTION_UP:
                Log.e("事件传递机制","button ACTION_UP");

                Toast.makeText(getContext(), "button ACTION_UP", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onTouchEvent(event);
    }
}
