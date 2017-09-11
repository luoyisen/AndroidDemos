package com.example.i.AndroidDemos.customizedview.customizedview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.i.AndroidDemos.R;

import java.util.HashSet;
import java.util.Random;

/***
 * Created by I on 2017/8/29.
 */

public class ViewChangeText extends View {
    private int textColor;
    private int backgroundColor;
    private String text;
    private int textSize;
    private Paint mPaint;
    private Rect mRect;

    public ViewChangeText(Context context) {
        this(context, null);
    }

    public ViewChangeText(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewChangeText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ViewChangeText, defStyleAttr, 0);
        int n = typedArray.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = typedArray.getIndex(i);
            switch (attr) {
                case R.styleable.ViewChangeText_backgroundColor:
                    backgroundColor = typedArray.getColor(attr, Color.GREEN);
                    break;
                case R.styleable.ViewChangeText_textColor:
                    textColor = typedArray.getColor(attr, Color.RED);
                    break;
                case R.styleable.ViewChangeText_text:
                    text = typedArray.getString(attr);
                    break;
                case R.styleable.ViewChangeText_textSize:
                    textSize = typedArray.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;
                default:
                    break;
            }
        }
        typedArray.recycle();
        mPaint = new Paint();
        mPaint.setTextSize(textSize);
//        mPaint.setColor(textColor);
        mRect = new Rect();

        mPaint.getTextBounds(text, 0, text.length(), mRect);//// TODO: 2017/8/29
        // TODO: 2017/8/29  变换颜色

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                text = setRandomText();
                postInvalidate();//invalidate() 和 postInvalidate() 都是进行 UI 更新，invalidate() 在主线程中调用，而 postInvalidate 是在子线程中进行调用。
            }
        });
    }

    private String setRandomText() {
        Random random = new Random();//class Random implements java.io.Serializable
        HashSet<Integer> integers = new HashSet<>();
        while (integers.size() < 4) {
            int randomInt = random.nextInt(10);//返回0-10之间的数字
            integers.add(randomInt);
        }
        StringBuilder builder = new StringBuilder();
        for (Integer i : integers) {
            builder.append("").append(i);
        }
        return builder.toString();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = 0;
        int height = 0;
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);

        switch (specMode) {
            case MeasureSpec.EXACTLY:
                width = getPaddingLeft() + getPaddingRight() + specSize;
                break;
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                float textWidth = mPaint.measureText(text);
                width = (int) (getPaddingLeft() + getPaddingRight() + textWidth);
                break;
        }
        specMode = MeasureSpec.getMode(heightMeasureSpec);
        specSize = MeasureSpec.getSize(heightMeasureSpec);
        switch (specMode) {
            case MeasureSpec.EXACTLY:
                height = getPaddingTop() + getPaddingBottom() + specSize;
                break;
            case MeasureSpec.AT_MOST://一般为wrapcontent
            case MeasureSpec.UNSPECIFIED:
                Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
                float textHeight = Math.abs(fontMetrics.bottom - fontMetrics.top);
                height = (int) (getPaddingTop() + getPaddingBottom() + textHeight);
                break;
        }

        setMeasuredDimension(width, height);
    }

//    private void sourceOnMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        // super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int width = 0;
//        int height = 0;
//        /**
//         * 设置宽度
//         */
//        int specMode = MeasureSpec.getMode(widthMeasureSpec);
//        int specSize = MeasureSpec.getSize(widthMeasureSpec);
//        switch (specMode) {
//            case MeasureSpec.EXACTLY://明确指定了
//                width = getPaddingLeft() + getPaddingRight() + specSize;
//                break;
//            case MeasureSpec.AT_MOST:// 一般为WARP_CONTENT
//            case MeasureSpec.UNSPECIFIED:
////                int textWidth = mRect.width(); // 这样mRect.width()直接计算出来的会有误差
//                float textWidth = mPaint.measureText(text);
//                width = (int) (getPaddingLeft() + getPaddingRight() + textWidth);
//                break;
//        }
//        /**
//         * 设置高度
//         */
//        specMode = MeasureSpec.getMode(heightMeasureSpec);
//        specSize = MeasureSpec.getSize(heightMeasureSpec);
//        switch (specMode) {
//            case MeasureSpec.EXACTLY://明确指定了
//                height = getPaddingTop() + getPaddingBottom() + specSize;
//                break;
//            case MeasureSpec.AT_MOST:// 一般为WARP_CONTENT
//            case MeasureSpec.UNSPECIFIED:
////                int textHeight = mRect.height(); //直接计算出来的会有误差
//                Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
////                float textHeight = Math.abs((fontMetrics.descent - fontMetrics.ascent));
//                float textHeight = Math.abs((fontMetrics.bottom - fontMetrics.top));
//                height = (int) (getPaddingTop() + getPaddingBottom() + textHeight);
//                break;
//        }
//        setMeasuredDimension(width, height);
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(backgroundColor);
        mPaint.setAntiAlias(true);
        mPaint.setTextAlign(Paint.Align.LEFT);// TODO: 2017/8/29  
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);

        mPaint.setColor(textColor);
//        canvas.drawText(text, getWidth() / 2 - mRect.width() / 2 - mRect.left, getHeight() / 2 + mRect.height() / 2, mPaint);
        canvas.drawText(text, getWidth() / 2 - mRect.width() / 2 - mRect.left, getHeight() / 2 + mRect.height() / 2, mPaint);
    }
}
