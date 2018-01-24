package com.example.i.AndroidDemos.view.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.i.AndroidDemos.R;

/***
 * Created by I on 2017/9/23.
 */


public class MaterialProgressbar extends View {
    private Paint paint, linePaint;
    private int width;
    private final int margin = 10;
    private RectF rectF;
    private Bitmap bitmap;
    public MaterialProgressbar(Context context) {
        super(context);
        init();
    }

    public MaterialProgressbar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
        init();
    }

    public MaterialProgressbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        rectF = new RectF(0, 0, 500, 500);
        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.search_databasep);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int startX = getMeasuredWidth() / 2;
        int count = 100;
        final int pointinline = getMeasuredHeight() / 2 / 15;
        paint.setColor(getResources().getColor(R.color.colorPrimary));
        canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, getMeasuredHeight() / 2, paint);
        paint.setColor(getResources().getColor(R.color.colorread));
        canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, getMeasuredHeight() / 2 - pointinline, paint);
        paint.setColor(getResources().getColor(R.color.colorwhite));
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(3);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(R.color.colorAccent));
//        canvas.drawOval(rectF,paint);
        canvas.drawArc(rectF, 0, 100, true, paint);
        canvas.drawBitmap(bitmap,0,0,paint);
    }
}
