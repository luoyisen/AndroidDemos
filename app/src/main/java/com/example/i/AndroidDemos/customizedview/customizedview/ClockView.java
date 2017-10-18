package com.example.i.AndroidDemos.customizedview.customizedview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;

import com.example.i.AndroidDemos.R;

import java.text.DecimalFormat;
import java.util.Calendar;

/***
 * Created by I on 2017/9/5.
 */

public class ClockView extends View {
    private final static int DEFAULT_SIZE = 400;
    private final static int MARK_WIDTH = 20;
    private final static int MARK_LENGTH = 20;
    private final static int MARK_GAP = 30;
    private final static int HOUR_LINE_WIDTH = 16;
    private final static int MINUTE_LINE_WIDTH = 10;
    private final static int SECOND_LINE_WIDTH = 4;
    private int centerX;
    private int centerY;
    private int radius;
    private Paint circlePaint;
    private Paint markPaint;
    private Paint hourPaint;
    private Paint minutePaint;
    private Paint secondPaint;
    private int hourLineLength;

    private int minuteLineLength;
    private int secondLineLength;

    private Bitmap hourBitmap;
    private Bitmap minuteBitmap;
    private Bitmap secondBitmap;

    private Canvas hourCanvas;
    private Canvas minuteCanvas;
    private Canvas secondCanvas;

    private int mCircleColor = Color.WHITE;
    private int mHourColor = Color.BLACK;
    private int mMinuteColor = Color.BLACK;
    private int mSecondColor = Color.RED;
    private int mQuarterMarkColor = Color.parseColor("#991111");
    private int mMinuteMarkColor = Color.parseColor("#EBEBEB");
    private boolean isDrawCenterCircle = false;
    private OnCurrentTimeListener onCurrentTimeListener;

    public void setOnCurrentTimeListener(OnCurrentTimeListener onCurrentTimeListener) {
        this.onCurrentTimeListener = onCurrentTimeListener;
    }

    public ClockView(Context context) {
        super(context);
        initPaint();
    }

    public ClockView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClockView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ClockView);
        mCircleColor = a.getColor(R.styleable.ClockView_circle_color, Color.WHITE);
        mHourColor = a.getColor(R.styleable.ClockView_hour_color, Color.BLACK);
        mMinuteColor = a.getColor(R.styleable.ClockView_minute_color, Color.BLACK);
        mSecondColor = a.getColor(R.styleable.ClockView_second_color, Color.RED);
        mQuarterMarkColor = a.getColor(R.styleable.ClockView_quarter_mark_color, Color.parseColor("#B5B5B5"));
        mMinuteMarkColor = a.getColor(R.styleable.ClockView_minute_mark_color, Color.parseColor("#EBEBEB"));
        isDrawCenterCircle = a.getBoolean(R.styleable.ClockView_draw_center_circle, false);
        a.recycle();
        initPaint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        reMeasure(widthMeasureSpec, heightMeasureSpec);
//        int width = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
//        int height = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
//        centerX = width / 2 + getPaddingLeft();
//        centerY = height / 2 + getPaddingTop();
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        centerX = width / 2;
        centerY = height / 2;
        radius = Math.min(width, height) / 2;

        hourLineLength = radius / 2;
        minuteLineLength = radius * 3 / 5;
        secondLineLength = radius * 3 / 4;

        hourBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        hourCanvas = new Canvas(hourBitmap);

        minuteBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        minuteCanvas = new Canvas(minuteBitmap);

        secondBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        secondCanvas = new Canvas(secondBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawColor(Color.BLACK);默认颜色为透明的
        canvas.drawCircle(centerX, centerY, radius, circlePaint);
//===========================画数字3，6，9，12==============================
        markPaint.setColor(mQuarterMarkColor);
        markPaint.setColor(Color.WHITE);
        markPaint.setAntiAlias(true);
        markPaint.setTextSize(60);
        Paint.FontMetrics fontMetrics = markPaint.getFontMetrics();
        //(-fontMetrics.ascent + fontMetrics.descent) / 2
        canvas.drawText("12", radius - markPaint.measureText("12") / 2, MARK_GAP - fontMetrics.ascent - fontMetrics.descent, markPaint);
        canvas.drawText("6", radius - markPaint.measureText("6") / 2, radius * 2 - MARK_GAP, markPaint);
        canvas.drawText("3", radius * 2 - MARK_GAP - markPaint.measureText("3"), radius + (-fontMetrics.ascent - fontMetrics.descent) / 2, markPaint);
        canvas.drawText("9", MARK_GAP, radius + (-fontMetrics.ascent - fontMetrics.descent) / 2, markPaint);
        canvas.save();
//===========================分别使用三个新的画布来画时针、分针、秒针===============================
        Calendar calendar = Calendar.getInstance();
        int hour12 = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        hourCanvas.save();//保存画布的状态，因为下面有了画布的旋转操作
        hourCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        hourCanvas.rotate(hour12 * 30 + minute * 0.5f, centerX, centerY);
        hourCanvas.drawLine(centerX, centerY,
                centerX, centerY - hourLineLength, hourPaint);
        if (isDrawCenterCircle)//根据指针的颜色绘制圆心
            hourCanvas.drawCircle(centerX, centerY, 2 * HOUR_LINE_WIDTH, hourPaint);
        hourCanvas.restore();

        minuteCanvas.save();
        minuteCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        minuteCanvas.rotate(minute * 6 + second * 0.1f, centerX, centerY);
        minuteCanvas.drawLine(centerX, centerY,
                centerX, centerY - minuteLineLength, minutePaint);
        if (isDrawCenterCircle)//根据指针的颜色绘制圆心
            minuteCanvas.drawCircle(centerX, centerY, 2 * MINUTE_LINE_WIDTH, minutePaint);
        minuteCanvas.restore();

        secondCanvas.save();
        secondCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);//过一秒就清除之前画的秒针
        secondCanvas.rotate(second * 6, centerX, centerY);
        secondCanvas.drawLine(centerX, centerY,
                centerX, centerY - secondLineLength, secondPaint);
        if (isDrawCenterCircle)//根据指针的颜色绘制圆心
            secondCanvas.drawCircle(centerX, centerY, 2 * SECOND_LINE_WIDTH, secondPaint);
        secondCanvas.restore();

        canvas.drawBitmap(hourBitmap, 0, 0, null);
        canvas.drawBitmap(minuteBitmap, 0, 0, null);
        canvas.drawBitmap(secondBitmap, 0, 0, null);

        postInvalidateDelayed(100);

        if (onCurrentTimeListener != null) {
            int h = calendar.get(Calendar.HOUR_OF_DAY);
            String currentTime = intAdd0(h) + ":" + intAdd0(minute) + ":" + intAdd0(second);
            onCurrentTimeListener.currentTime(currentTime);
        }
    }

    private void initPaint() {
        circlePaint = new Paint();
        circlePaint.setAntiAlias(true);
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setColor(mCircleColor);

        markPaint = new Paint();
        circlePaint.setAntiAlias(true);
        markPaint.setStyle(Paint.Style.FILL);
        markPaint.setStrokeCap(Paint.Cap.ROUND);
        markPaint.setStrokeWidth(MARK_WIDTH);

        hourPaint = new Paint();
        hourPaint.setAntiAlias(true);
        hourPaint.setColor(mHourColor);
        hourPaint.setStyle(Paint.Style.FILL);
        hourPaint.setStrokeCap(Paint.Cap.ROUND);
        hourPaint.setStrokeWidth(HOUR_LINE_WIDTH);

        minutePaint = new Paint();
        minutePaint.setAntiAlias(true);
        minutePaint.setColor(mMinuteColor);
        minutePaint.setStyle(Paint.Style.FILL);
        minutePaint.setStrokeCap(Paint.Cap.ROUND);
        minutePaint.setStrokeWidth(MINUTE_LINE_WIDTH);

        secondPaint = new Paint();
        secondPaint.setAntiAlias(true);
        secondPaint.setColor(mSecondColor);
        secondPaint.setStyle(Paint.Style.FILL);
        secondPaint.setStrokeCap(Paint.Cap.ROUND);
        secondPaint.setStrokeWidth(SECOND_LINE_WIDTH);
    }

    private void reMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measureWidth = MeasureSpec.getSize(widthMeasureSpec);
        int measureHeight = MeasureSpec.getSize(heightMeasureSpec);
        int measureWidthMode = MeasureSpec.getMode(widthMeasureSpec);
        int measureHeightMode = MeasureSpec.getMode(heightMeasureSpec);
        int width = (int) getContext().getResources().getDimension(R.dimen.width);
        if (measureWidthMode == MeasureSpec.AT_MOST
                && measureHeightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(width, width);
        } else if (measureWidthMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(width, measureHeight);
        } else if (measureHeightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(measureWidth, width);
        }
    }

    public interface OnCurrentTimeListener {
        void currentTime(String time);
    }

    private String intAdd0(int i) {
        DecimalFormat df = new DecimalFormat("00");
        if (i < 10) {
            return df.format(i);
        } else {
            return i + "";
        }
    }

    @Override
    public void setElevation(float elevation) {
        super.setElevation(elevation);
    }
}
