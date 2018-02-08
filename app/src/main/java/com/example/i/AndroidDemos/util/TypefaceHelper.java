package com.example.i.AndroidDemos.util;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by HHX on 2018/2/7.
 */

public class TypefaceHelper {
    private static Typeface letterTypeface;
    private static Typeface chineseTypeface;

    public static void generateTypeface(Context context) {
        letterTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/Arial_Rounded_MT_Bold.ttf");
        chineseTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/fzbwksj.ttf");
    }

    //为TextView设置英文字体
    public static void applyTypeface(TextView textView) {
        textView.setTypeface(letterTypeface);
    }

    //为TextPaint设置中文字体
    public static void applyChineseTypefaceForTextPaint(TextPaint textPaint) {
        textPaint.setTypeface(chineseTypeface);
    }

    //为TextPaint设置英文字体
    public static void applyLetterTypefaceForTextPaint(TextPaint textPaint) {
        textPaint.setTypeface(letterTypeface);
    }

}
