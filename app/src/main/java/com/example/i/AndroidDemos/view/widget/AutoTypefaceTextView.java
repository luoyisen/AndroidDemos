package com.example.i.AndroidDemos.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextPaint;
import android.util.AttributeSet;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.util.TypefaceHelper;

import java.util.regex.Pattern;

/**
 * Created by HHX on 2018/2/8.
 */

public class AutoTypefaceTextView extends AppCompatTextView {
    private TextPaint letterTextPaint;
    private TextPaint chineseTextPaint;
    private int textsize = 50;

    private float letterBaseY;
    private float letterTranslate;
    private float chineseTranslate;

    private String textToBeDrawn;
    private float calculatedLineWidth;
    private float calculatedCharWidth;

    float calculatedWidth = 1.0f;
    float calculatedHeight = 0.0f;
    float textHeight;

    public AutoTypefaceTextView(Context context) {
        this(context, null);
    }

    public AutoTypefaceTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AutoTypefaceTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.AutoTypefaceTextView, defStyleAttr, 0);
        textToBeDrawn = typedArray.getString(R.styleable.AutoTypefaceTextView_text_auto);
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        init();

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension((int) calculatedWidth, (int) calculatedHeight);
            // 宽 / 高任意一个模式为AT_MOST（即wrap_content）时，都设置默认值
        } else if (widthMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension((int) calculatedWidth, heightSize);
        } else if (heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSize, (int) calculatedHeight);
        } else {
            setMeasuredDimension(widthSize, heightSize);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //绘制中文的TextPaint
        chineseTextPaint = new TextPaint();
        TypefaceHelper.applyChineseTypefaceForTextPaint(chineseTextPaint);
        chineseTextPaint.setAntiAlias(true);
        chineseTextPaint.setTextSize(textsize);

        //绘制字母的TextPaint
        letterTextPaint = new TextPaint();
        TypefaceHelper.applyLetterTypefaceForTextPaint(letterTextPaint);
        letterTextPaint.setAntiAlias(true);
        letterTextPaint.setTextSize(textsize);

        Paint.FontMetrics fontMetrics = letterTextPaint.getFontMetrics();
        float i = fontMetrics.bottom - fontMetrics.top;
        textHeight = i + 0;
        letterBaseY = (int) ((textHeight / 2) - ((letterTextPaint.descent() + letterTextPaint.ascent()) / 2));

        chineseTranslate = chineseTextPaint.measureText("我");
        calculatedHeight = textHeight;
    }

    private void init() {


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < textToBeDrawn.length(); i++) {
            String s = textToBeDrawn.charAt(i) + "";
            //如果是中文
            if (Pattern.compile("[\u4e00-\u9fa5]").matcher(
                    String.valueOf(textToBeDrawn.charAt(i))).find()) {
                canvas.drawText(s, 0, letterBaseY, chineseTextPaint);
                canvas.translate(chineseTranslate, 0);
                calculatedWidth += chineseTranslate;
                calculatedLineWidth += chineseTranslate;
                if (calculatedLineWidth > 600) {
                    calculatedHeight += textHeight;
                }
            } else {
                canvas.drawText(s, 0, letterBaseY, letterTextPaint);
                calculatedCharWidth = letterTextPaint.measureText(s);
                canvas.translate(calculatedCharWidth, 0);
                calculatedWidth += calculatedCharWidth;
                calculatedLineWidth += calculatedCharWidth;

                if (calculatedLineWidth > 600) {
                    calculatedHeight += textHeight;
                }
            }

            if (i == textToBeDrawn.length()) {
                calculatedWidth = 10.0f;
                calculatedHeight = 0.0f;
                invalidate();
            }
        }
    }
}
