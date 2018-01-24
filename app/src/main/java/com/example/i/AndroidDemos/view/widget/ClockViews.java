package com.example.i.AndroidDemos.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.i.AndroidDemos.R;

import java.util.Calendar;

/***
 * Created by I on 2017/9/10.
 */

public class ClockViews extends View {
    private final static int SECOND_LINE_WIDTH = 4;
    private int centerX;
    private int centerY;
    private int radius;
    private Paint secondPaint;

    private int secondLineLength;
    private int mSecondColor = Color.RED;


    public ClockViews(Context context) {
        super(context);
        init();
    }

    public ClockViews(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //MeasureSpec其实就是承担这种作用：MeasureSpec是父控件提供给子View的一个参数，作为设定自身大小参考，只是个参考，要多大，还是View自己说了算。先看下MeasureSpec的构成，MeasureSpec由size和mode组成，mode包括三种，UNSPECIFIED、EXACTLY、AT_MOST，size就是配合mode给出的参考尺寸
        //UNSPECIFIED(未指定),父控件对子控件不加任何束缚，子元素可以得到任意想要的大小，这种MeasureSpec一般是由父控件自身的特性决定的。比如ScrollView，它的子View可以随意设置大小，无论多高，都能滚动显示，这个时候，size一般就没什么意义。
        //EXACTLY(确定的，父控件为子View指定确切大小，希望子View完全按照自己给定尺寸来处理,这时的MeasureSpec一般是父控件根据自身的MeasureSpec跟子View的布局参数来确定的。一般这种情况下size>0,有个确定值。
        //AT_MOST(至多)，父控件为子元素指定最大参考尺寸，希望子View的尺寸不要超过这个尺寸。这种模式也是父控件根据自身的MeasureSpec跟子View的布局参数来确定的，一般是子View的布局参数采用wrap_content的时候。
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = (int) getContext().getResources().getDimension(R.dimen.width);
        int height = (int) getContext().getResources().getDimension(R.dimen.width);
        int measuredWidth = MeasureSpec.getSize(widthMeasureSpec);
        int measuredHeight = MeasureSpec.getSize(heightMeasureSpec);
        int measuredWidthMode = MeasureSpec.getMode(widthMeasureSpec);
        int measuredHeightMode = MeasureSpec.getMode(widthMeasureSpec);
//        int height = getMeasuredHeight();
        centerX = width / 2;
        centerY = height / 2;
        radius = Math.min(width, height) / 2;
        secondLineLength = radius * 3 / 4;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Calendar calendar = Calendar.getInstance();
        int second = calendar.get(Calendar.SECOND);
        String s = second + "";
        secondPaint.setTextSize(90);
        canvas.save();
        canvas.drawText("99", 800, 600, secondPaint);
//        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
//        canvas.rotate(second * 6, centerX, centerY);
//        canvas.drawLine(centerX, centerY,
//                centerX, centerY - secondLineLength, secondPaint);
        canvas.restore();
        postInvalidateDelayed(0);

    }


    private void init() {
        secondPaint = new Paint();
        secondPaint.setAntiAlias(true);
        secondPaint.setColor(mSecondColor);
        secondPaint.setStyle(Paint.Style.FILL);
        secondPaint.setStrokeCap(Paint.Cap.ROUND);
        secondPaint.setStrokeWidth(SECOND_LINE_WIDTH);
    }

}
