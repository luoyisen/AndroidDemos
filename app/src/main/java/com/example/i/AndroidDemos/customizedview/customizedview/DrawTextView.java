package com.example.i.AndroidDemos.customizedview.customizedview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.i.AndroidDemos.R;

/***
 * Created by I on 2017/9/12.
 */

public class DrawTextView extends View {
    private Paint paint;
    public String text = "";
    String[] strings;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public DrawTextView(Context context) {
        this(context, null);
    }

    public DrawTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        TypedArray array = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.DrawTextView, defStyleAttr, 0);
//        text = array.getString(R.styleable.DrawTextView_draw_text);//只能再xml文件中使用
        initPaint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        strings = text.split(" ");
        for (int i = 0; i < strings.length; i++) {
            canvas.drawText(strings[i], 200, 40 + 40 * i, paint);
        }
        canvas.save();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setColor(Color.parseColor("#3c5f78"));
        paint.setTextSize(getResources().getDimension(R.dimen.textsize_20dp));
        paint.setAntiAlias(true);
    }
}
