package com.example.i.AndroidDemos.customizedview.customizedview.ProgressBarWithNumber;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;

import com.example.i.AndroidDemos.R;

import static com.example.i.AndroidDemos.customizedview.customizedview.ProgressBarWithNumber.ProgressBarWithNumber.ProgressTextVisibility.Invisible;
import static com.example.i.AndroidDemos.customizedview.customizedview.ProgressBarWithNumber.ProgressBarWithNumber.ProgressTextVisibility.Visible;

/***
 * Created by I on 2017/9/23.
 */

public class ProgressBarWithNumber extends View {

    private int mMaxProgress = 100;

    private int mCurrentProgress = 0;

    private int mReachedBarColor;

    private int mUnreachedBarColor;

    private int mTextColor;

    private float mTextSize;

    private float mReachedBarHeight;

    private float mUnreachedBarHeight;

    private String mSuffix = "%";

    private String mPrefix = "";

    private static final String INSTANCE_STATE = "saved_instance";
    private static final String INSTANCE_TEXT_COLOR = "text_color";
    private static final String INSTANCE_TEXT_SIZE = "text_size";
    private static final String INSTANCE_REACHED_BAR_HEIGHT = "reached_bar_height";
    private static final String INSTANCE_REACHED_BAR_COLOR = "reached_bar_color";
    private static final String INSTANCE_UNREACHED_BAR_HEIGHT = "unreached_bar_height";
    private static final String INSTANCE_UNREACHED_BAR_COLOR = "unreached_bar_color";
    private static final String INSTANCE_MAX = "max";
    private static final String INSTANCE_PROGRESS = "progress";
    private static final String INSTANCE_SUFFIX = "suffix";
    private static final String INSTANCE_PREFIX = "prefix";
    private static final String INSTANCE_TEXT_VISIBILITY = "text_visibility";

    private static final int PROGRESS_TEXT_VISIBLE = 0;

    private float mDrawTextStart;

    private float mDrawTextEnd;

    private String mCurrentDrawText;

    private Paint mReachedBarPaint;

    private Paint mUnreachedBarPaint;

    private Paint mTextPaint;

    private RectF mUnreachedRectF = new RectF(0, 0, 0, 0);

    private RectF mReachedRectF = new RectF(0, 0, 0, 0);

    private float mOffset;

    private boolean mDrawUnreachedBar = true;

    private boolean mDrawReachedBar = true;

    private boolean mIfDrawText = true;

    private OnProgressBarListener mListener;

    public enum ProgressTextVisibility {
        Visible, Invisible
    }

    public ProgressBarWithNumber(Context context) {
        this(context, null);
    }

    public ProgressBarWithNumber(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProgressBarWithNumber(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        float default_reached_bar_height = dp2px(1.5f);
        float default_unreached_bar_height = dp2px(1.0f);
        float default_text_size = sp2px(10);
        float default_progress_text_offset = dp2px(3.0f);

        //load styled attributes.
        final TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ProgressBarWithNumber,
                defStyleAttr, 0);

        int default_reached_color = Color.rgb(66, 145, 241);
        mReachedBarColor = attributes.getColor(R.styleable.ProgressBarWithNumber_progress_reached_color, default_reached_color);
        int default_unreached_color = Color.rgb(204, 204, 204);
        mUnreachedBarColor = attributes.getColor(R.styleable.ProgressBarWithNumber_progress_unreached_color, default_unreached_color);
        int default_text_color = Color.rgb(66, 145, 241);
        mTextColor = attributes.getColor(R.styleable.ProgressBarWithNumber_progress_text_color, default_text_color);
        mTextSize = attributes.getDimension(R.styleable.ProgressBarWithNumber_progress_text_size, default_text_size);

        mReachedBarHeight = attributes.getDimension(R.styleable.ProgressBarWithNumber_progress_reached_bar_height, default_reached_bar_height);
        mUnreachedBarHeight = attributes.getDimension(R.styleable.ProgressBarWithNumber_progress_unreached_bar_height, default_unreached_bar_height);
        mOffset = attributes.getDimension(R.styleable.ProgressBarWithNumber_progress_text_offset, default_progress_text_offset);

        int textVisible = attributes.getInt(R.styleable.ProgressBarWithNumber_progress_text_visibility, PROGRESS_TEXT_VISIBLE);
        if (textVisible != PROGRESS_TEXT_VISIBLE) {
            mIfDrawText = false;
        }

        setProgress(attributes.getInt(R.styleable.ProgressBarWithNumber_progress_current, 0));
        setMax(attributes.getInt(R.styleable.ProgressBarWithNumber_progress_max, 100));

        attributes.recycle();
        initializePainters();
    }

    @Override
    protected int getSuggestedMinimumWidth() {
        return (int) mTextSize;
    }

    @Override
    protected int getSuggestedMinimumHeight() {
        return Math.max((int) mTextSize, Math.max((int) mReachedBarHeight, (int) mUnreachedBarHeight));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measure(widthMeasureSpec, true), measure(heightMeasureSpec, false));
    }

    private int measure(int measureSpec, boolean isWidth) {
        int result;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        int padding = isWidth ? getPaddingLeft() + getPaddingRight() : getPaddingTop() + getPaddingBottom();
        if (mode == MeasureSpec.EXACTLY) {
            result = size;
        } else {
            result = isWidth ? getSuggestedMinimumWidth() : getSuggestedMinimumHeight();
            result += padding;
            if (mode == MeasureSpec.AT_MOST) {
                if (isWidth) {
                    result = Math.max(result, size);
                } else {
                    result = Math.min(result, size);
                }
            }
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mIfDrawText) {
            calculateDrawRectF();
        } else {
            calculateDrawRectFWithoutProgressText();
        }

        if (mDrawReachedBar) {
            canvas.drawRect(mReachedRectF, mReachedBarPaint);
        }

        if (mDrawUnreachedBar) {
            canvas.drawRect(mUnreachedRectF, mUnreachedBarPaint);
        }

        if (mIfDrawText)
            canvas.drawText(mCurrentDrawText, mDrawTextStart, mDrawTextEnd, mTextPaint);
    }

    private void initializePainters() {
        mReachedBarPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mReachedBarPaint.setColor(mReachedBarColor);

        mUnreachedBarPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mUnreachedBarPaint.setColor(mUnreachedBarColor);

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(mTextColor);
        mTextPaint.setTextSize(mTextSize);
    }

    private void calculateDrawRectFWithoutProgressText() {
        mReachedRectF.left = getPaddingLeft();
        mReachedRectF.top = getHeight() / 2.0f - mReachedBarHeight / 2.0f;
        mReachedRectF.right = (getWidth() - getPaddingLeft() - getPaddingRight()) / (getMax() * 1.0f) * getProgress() + getPaddingLeft();
        mReachedRectF.bottom = getHeight() / 2.0f + mReachedBarHeight / 2.0f;

        mUnreachedRectF.left = mReachedRectF.right;
        mUnreachedRectF.right = getWidth() - getPaddingRight();
        mUnreachedRectF.top = getHeight() / 2.0f + -mUnreachedBarHeight / 2.0f;
        mUnreachedRectF.bottom = getHeight() / 2.0f + mUnreachedBarHeight / 2.0f;
    }

    private void calculateDrawRectF() {

        mCurrentDrawText = String.format("%d", getProgress() * 100 / getMax());
        mCurrentDrawText = mPrefix + mCurrentDrawText + mSuffix;
        float mDrawTextWidth = mTextPaint.measureText(mCurrentDrawText);

        if (getProgress() == 0) {
            mDrawReachedBar = false;
            mDrawTextStart = getPaddingLeft();
        } else {
            mDrawReachedBar = true;
            mReachedRectF.left = getPaddingLeft();
            mReachedRectF.top = getHeight() / 2.0f - mReachedBarHeight / 2.0f;
            mReachedRectF.right = (getWidth() - getPaddingLeft() - getPaddingRight()) / (getMax() * 1.0f) * getProgress() - mOffset + getPaddingLeft();
            mReachedRectF.bottom = getHeight() / 2.0f + mReachedBarHeight / 2.0f;
            mDrawTextStart = (mReachedRectF.right + mOffset);
        }

        mDrawTextEnd = (int) ((getHeight() / 2.0f) - ((mTextPaint.descent() + mTextPaint.ascent()) / 2.0f));

        if ((mDrawTextStart + mDrawTextWidth) >= getWidth() - getPaddingRight()) {
            mDrawTextStart = getWidth() - getPaddingRight() - mDrawTextWidth;
            mReachedRectF.right = mDrawTextStart - mOffset;
        }

        float unreachedBarStart = mDrawTextStart + mDrawTextWidth + mOffset;
        if (unreachedBarStart >= getWidth() - getPaddingRight()) {
            mDrawUnreachedBar = false;
        } else {
            mDrawUnreachedBar = true;
            mUnreachedRectF.left = unreachedBarStart;
            mUnreachedRectF.right = getWidth() - getPaddingRight();
            mUnreachedRectF.top = getHeight() / 2.0f + -mUnreachedBarHeight / 2.0f;
            mUnreachedRectF.bottom = getHeight() / 2.0f + mUnreachedBarHeight / 2.0f;
        }
    }

    public int getTextColor() {
        return mTextColor;
    }

    public float getProgressTextSize() {
        return mTextSize;
    }

    public int getUnreachedBarColor() {
        return mUnreachedBarColor;
    }

    public int getReachedBarColor() {
        return mReachedBarColor;
    }

    public int getProgress() {
        return mCurrentProgress;
    }

    public int getMax() {
        return mMaxProgress;
    }

    public float getReachedBarHeight() {
        return mReachedBarHeight;
    }

    public float getUnreachedBarHeight() {
        return mUnreachedBarHeight;
    }

    public void setProgressTextSize(float textSize) {
        this.mTextSize = textSize;
        mTextPaint.setTextSize(mTextSize);
        invalidate();
    }

    public void setProgressTextColor(int textColor) {
        this.mTextColor = textColor;
        mTextPaint.setColor(mTextColor);
        invalidate();
    }

    public void setUnreachedBarColor(int barColor) {
        this.mUnreachedBarColor = barColor;
        mUnreachedBarPaint.setColor(mUnreachedBarColor);
        invalidate();
    }

    public void setReachedBarColor(int progressColor) {
        this.mReachedBarColor = progressColor;
        mReachedBarPaint.setColor(mReachedBarColor);
        invalidate();
    }

    public void setReachedBarHeight(float height) {
        mReachedBarHeight = height;
    }

    public void setUnreachedBarHeight(float height) {
        mUnreachedBarHeight = height;
    }

    public void setMax(int maxProgress) {
        if (maxProgress > 0) {
            this.mMaxProgress = maxProgress;
            invalidate();
        }
    }

    public void setSuffix(String suffix) {
        if (suffix == null) {
            mSuffix = "";
        } else {
            mSuffix = suffix;
        }
    }

    public String getSuffix() {
        return mSuffix;
    }

    public void setPrefix(String prefix) {
        if (prefix == null)
            mPrefix = "";
        else {
            mPrefix = prefix;
        }
    }

    public String getPrefix() {
        return mPrefix;
    }

    public void incrementProgressBy(int by) {
        if (by > 0) {
            setProgress(getProgress() + by);
        }

        if(mListener != null){
            mListener.onProgressChange(getProgress(), getMax());
        }
    }

    public void setProgress(int progress) {
        if (progress <= getMax() && progress >= 0) {
            this.mCurrentProgress = progress;
            invalidate();
        }
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        final Bundle bundle = new Bundle();
        bundle.putParcelable(INSTANCE_STATE, super.onSaveInstanceState());
        bundle.putInt(INSTANCE_TEXT_COLOR, getTextColor());
        bundle.putFloat(INSTANCE_TEXT_SIZE, getProgressTextSize());
        bundle.putFloat(INSTANCE_REACHED_BAR_HEIGHT, getReachedBarHeight());
        bundle.putFloat(INSTANCE_UNREACHED_BAR_HEIGHT, getUnreachedBarHeight());
        bundle.putInt(INSTANCE_REACHED_BAR_COLOR, getReachedBarColor());
        bundle.putInt(INSTANCE_UNREACHED_BAR_COLOR, getUnreachedBarColor());
        bundle.putInt(INSTANCE_MAX, getMax());
        bundle.putInt(INSTANCE_PROGRESS, getProgress());
        bundle.putString(INSTANCE_SUFFIX, getSuffix());
        bundle.putString(INSTANCE_PREFIX, getPrefix());
        bundle.putBoolean(INSTANCE_TEXT_VISIBILITY, getProgressTextVisibility());
        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            final Bundle bundle = (Bundle) state;
            mTextColor = bundle.getInt(INSTANCE_TEXT_COLOR);
            mTextSize = bundle.getFloat(INSTANCE_TEXT_SIZE);
            mReachedBarHeight = bundle.getFloat(INSTANCE_REACHED_BAR_HEIGHT);
            mUnreachedBarHeight = bundle.getFloat(INSTANCE_UNREACHED_BAR_HEIGHT);
            mReachedBarColor = bundle.getInt(INSTANCE_REACHED_BAR_COLOR);
            mUnreachedBarColor = bundle.getInt(INSTANCE_UNREACHED_BAR_COLOR);
            initializePainters();
            setMax(bundle.getInt(INSTANCE_MAX));
            setProgress(bundle.getInt(INSTANCE_PROGRESS));
            setPrefix(bundle.getString(INSTANCE_PREFIX));
            setSuffix(bundle.getString(INSTANCE_SUFFIX));
            setProgressTextVisibility(bundle.getBoolean(INSTANCE_TEXT_VISIBILITY) ? Visible : Invisible);
            super.onRestoreInstanceState(bundle.getParcelable(INSTANCE_STATE));
            return;
        }
        super.onRestoreInstanceState(state);
    }

    public float dp2px(float dp) {
        final float scale = getResources().getDisplayMetrics().density;
        return dp * scale + 0.5f;
    }

    public float sp2px(float sp) {
        final float scale = getResources().getDisplayMetrics().scaledDensity;
        return sp * scale;
    }

    public void setProgressTextVisibility(ProgressTextVisibility visibility) {
        mIfDrawText = visibility == Visible;
        invalidate();
    }

    public boolean getProgressTextVisibility() {
        return mIfDrawText;
    }

    public void setOnProgressBarListener(OnProgressBarListener listener){
        mListener = listener;
    }
}
