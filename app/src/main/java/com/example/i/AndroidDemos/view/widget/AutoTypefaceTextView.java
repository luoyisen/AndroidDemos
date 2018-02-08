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
    private int textsize = 70;

    private float letterBaseY;
    private float letterTranslate;
    private float chineseTranslate;

    private String textToBeDrawn;
    private float calculatedLineWidth;
    private float calculatedCharWidth;

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
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        init();
    }

    private void init() {
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
        letterBaseY = (int) ((i / 2) - ((letterTextPaint.descent() + letterTextPaint.ascent()) / 2));

        chineseTranslate = chineseTextPaint.measureText("我");

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
                calculatedLineWidth += chineseTranslate;
                if(calculatedLineWidth > getMeasuredWidth()){

                }

            } else {
                canvas.drawText(s, 0, letterBaseY, letterTextPaint);
                calculatedCharWidth = letterTextPaint.measureText(s);
                canvas.translate(calculatedCharWidth, 0);
                calculatedLineWidth += calculatedCharWidth;
            }
        }
    }
}
