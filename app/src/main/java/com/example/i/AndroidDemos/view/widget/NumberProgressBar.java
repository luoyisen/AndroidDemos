package com.example.i.AndroidDemos.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.i.AndroidDemos.MyApplication;
import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.util.DisplayMetricsConvert;

/***
 * Created by I on 2017/9/23.
 */

public class NumberProgressBar extends View {
    private Paint paint;

    public NumberProgressBar(Context context) {
        super(context);
        init();
    }

    public NumberProgressBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
        init();
    }

    public NumberProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(getResources().getColor(R.color.colorread));
        paint.setTextSize(DisplayMetricsConvert.pxToDp(MyApplication.getContext(),20));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String s = 9 + "";
        canvas.drawText(s,getMeasuredWidth()/2,getMeasuredHeight()/2,paint);
    }

}
