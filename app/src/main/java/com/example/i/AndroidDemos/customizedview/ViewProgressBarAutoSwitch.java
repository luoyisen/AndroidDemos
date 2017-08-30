package com.example.i.AndroidDemos.customizedview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.i.AndroidDemos.R;

/**
 * Created by I on 2017/8/30.
 */

public class ViewProgressBarAutoSwitch extends View {
    private int width;
    private Paint paint;
    private int strokeWidth = 50;
    private boolean inProgress = true;
    private int progress = 0;
    private int speed = 15;

    public ViewProgressBarAutoSwitch(Context context) {
        this(context, null);
    }

    public ViewProgressBarAutoSwitch(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewProgressBarAutoSwitch(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        new Thread() {
            @Override
            public void run() {
                while (inProgress) {
                    progress++;
                    if (progress == 360) {
                        progress = 0;
                    }
                    postInvalidate();
                    try {
                        Thread.sleep(100 / speed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);

        if (modeWidth == MeasureSpec.EXACTLY) {
            width = sizeWidth;
        } else {
            width = (int) getContext().getResources().getDimension(R.dimen.width);
        }
        setMeasuredDimension(width, width);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int center = getWidth() / 2;
        int radius = center - strokeWidth / 2;
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setColor(getResources().getColor(R.color.colorPrimary));
        canvas.drawCircle(center, center,radius , paint);

        RectF rectF = new RectF(center - radius, center - radius, center + radius, center + radius);
        paint.setColor(getResources().getColor(R.color.colorwhite));
        canvas.drawArc(rectF, -90, progress, false, paint);// 根据进度画圆弧
    }
}
