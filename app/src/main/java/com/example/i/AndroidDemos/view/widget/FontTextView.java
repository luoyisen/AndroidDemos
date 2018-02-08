package com.example.i.AndroidDemos.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.i.AndroidDemos.util.TypefaceHelper;

/**
 * Created by HHX on 2018/2/7.
 */

public class FontTextView extends AppCompatTextView {
    public FontTextView(Context context) {
        this(context,null);

    }

    public FontTextView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public FontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
//    @Override
//    public void setTypeface(Typeface tf, int style) {
//        TypefaceHelper.applyTypeface(this);
//
//    }

    public void init() {
        TypefaceHelper.applyTypeface(this);
    }
}
